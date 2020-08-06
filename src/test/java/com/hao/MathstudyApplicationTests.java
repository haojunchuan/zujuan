package com.hao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hao.common.tools.DealwithQuestion;
import com.hao.dao.QuestionDao;
import com.hao.domain.Question;
import com.hao.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MathstudyApplicationTests {
    @Autowired
    private QuestionService questionService;

    @Resource
    private QuestionDao questionDao;

    @Test
    void contextLoads() {
        Question q=questionService.getQuestionById("1000290");
        System.out.println(q);
    }

    @Test
    void testDealwithOptions(){
//        String option="{\"A\": \"0\", \"B\": \"-1\", \"C\": \"0或-1\", \"D\": \"0或1\"}";
        Question q=questionDao.selectById("10373898");
//        String option = q.getOptions().toString();
//        String dealwith = DealwithQuestion.dealwithOption(option);
//        System.out.println(dealwith);

        String ques=q.getQuestion_text();
        System.out.println(DealwithQuestion.dealwithquestiontext(ques));
    }


    @Test
    void testDao(){
        QueryWrapper<Question> wrapper =new QueryWrapper<>();
        wrapper.eq("cateid","10201");
        Page<Question> page=new Page<>(1,3);
        IPage<Question> questionIPage=questionDao.selectPage(page,wrapper);
        List<Question> records = questionIPage.getRecords();
        for (Question q:records
             ) {
            System.out.println(q.toString());
        }
    }

    @Test
    void testDao2(){
//        List<Question> questions = questionService.pageGetQuestionByCateId(2, "10201");
//        for (Question q:questions) {
//            System.out.println(DealwithQuestion.DealwithOneQuestion(q).toString());
//        }
    }
}
