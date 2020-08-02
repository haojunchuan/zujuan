package com.hao.service.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.hao.dao.QuestionDao;
import com.hao.domain.Question;
import com.hao.service.QuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jack hao
 * @createTime 2020-08-02-21:19
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Resource
    private QuestionDao questionDao;

    @Override
    public Question getQuestionById(String id) {
        Question question=questionDao.selectById(id);
        //处理选择
        if(question != null){
            System.out.println(question.getQuestion_channel_type());
            if(question.getQuestion_channel_type().equals("1")){
                Object option=question.getOptions();
                JSONObject newOption = JSONObject.parseObject(option.toString());
                StringBuffer option_=new StringBuffer();
                option_.append("<span class=\"op-item\" w=\"112\" h=\"24\" style=\"width: 221px; margin-right: 0px; height: 24px; clear: none;\">");
                newOption.forEach( (e,x) -> {
                    String a="<span class=\"op-item-nut\" style=\"margin-top: 0px;\">"+e+" . </span>";
                    String b="<span class=\"op-item-meat\" style=\"margin-top: 0px; white-space: normal;\">"+x+"</span>";
                    option_.append(a+b);
                });
                option_.append("</span>");
                question.setOptions(option_.toString());
            }
        }

        return question;
    }
}
