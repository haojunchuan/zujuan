package com.hao;

import com.hao.common.tools.DealwithQuestion;
import com.hao.dao.QuestionDao;
import com.hao.domain.Question;
import com.hao.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

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

}
