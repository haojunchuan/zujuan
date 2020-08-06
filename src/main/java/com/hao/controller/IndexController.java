package com.hao.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hao.common.tools.DealwithQuestion;
import com.hao.domain.Question;
import com.hao.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack hao
 * @createTime 2020-08-02-20:44
 */
@Controller
public class IndexController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("index")
    public String index(){
        return "index";
    }

    @GetMapping("/q/{id}")
    public  String getQuestion(@PathVariable String id, Model model){
        Question question=questionService.getQuestionById(id);
        model.addAttribute("question",question);
        return "question";
    }

    @GetMapping("/show/{chapterid}")
    public String show(@PathVariable String chapterid,Model model){
        Page<Question> questionPage = questionService.pageGetQuestionByCateId(1, chapterid);
        List<Question> questions=questionPage.getRecords();
        List<Question> newQuestions=new ArrayList<>();
        for (Question q:questions) {
            newQuestions.add(DealwithQuestion.DealwithOneQuestion(q));
        }
        model.addAttribute("questions",newQuestions);
        return "showquestions";
    }
}
