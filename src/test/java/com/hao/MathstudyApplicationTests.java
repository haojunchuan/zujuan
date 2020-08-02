package com.hao;

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

    @Test
    void contextLoads() {
        Question q=questionService.getQuestionById("1000290");
        System.out.println(q);
    }

}
