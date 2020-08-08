package com.hao.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hao.common.Constant;
import com.hao.common.tools.DealwithQuestion;
import com.hao.dao.QuestionDao;
import com.hao.domain.Question;
import com.hao.service.QuestionIndexService;
import com.hao.service.QuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jack hao
 * @createTime 2020-08-02-21:19
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Resource
    private QuestionDao questionDao;

    @Resource
    private QuestionIndexService questionIndexService;
    @Override
    public Question getQuestionById(String id) {
        Question question=questionDao.selectById(id);
        if(question != null){
            //处理单选题的选项
            if(question.getQuestion_channel_type().equals("1")){
                String option=question.getOptions().toString();
                String resOption= DealwithQuestion.dealwithOption(option);
                question.setOptions(resOption);
            }else{
                //处理大题的题号问题
                String questionText= question.getQuestion_text();
                if(questionText.contains("==>")){
                    questionText=DealwithQuestion.dealwithquestiontext(questionText);
                    question.setQuestion_text(questionText);
                }
            }
        }
        question.setAnswer(DealwithQuestion.dealwithanser(question.getAnswer()));
        return question;
    }

    @Override
    public Page<Question> pageGetQuestionByCateId(Integer pagenum, String cateid) {
        QueryWrapper<Question> wrapper=new QueryWrapper<>();
        wrapper.eq("cateid",cateid);
        Page<Question> page=new Page<>(pagenum, Constant.PAGE_SIZE);
        Page<Question> questionPage = questionDao.selectPage(page, wrapper);
        return questionPage;
    }

    @Override
    public List<Question> get10QuestionByCateid(Integer pagenum, String cateid){
        List<String> ids = questionIndexService.selectIdByCate_page(pagenum, cateid);
        List<Question> questions = questionDao.selectBatchIds(ids);
        return questions;
    }



}
