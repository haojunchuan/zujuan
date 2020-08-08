package com.hao.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hao.common.tools.DealwithQuestion;
import com.hao.dao.QuestionDao;
import com.hao.domain.Question;
import com.hao.domain.QuestionIndex;
import com.hao.service.QuestionIndexService;
import com.hao.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @Autowired
    private QuestionIndexService questionIndexService;

    @Resource
    private QuestionDao questionDao;

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

    @GetMapping("/questions")
    public String show(Model model){
//        Page<Question> questionPage = questionService.pageGetQuestionByCateId(1, chapterid);
//        long total = questionIndexService.getTotal(1, chapterid);
        //这里代码有点冗余 后期可以做一下优化
        List<String> ids=new ArrayList<>();
        Page<QuestionIndex> iPage = questionIndexService.getIPage(1, "10201");
        List<QuestionIndex> questionIndexList = iPage.getRecords();
        for (QuestionIndex qindex:questionIndexList) {
            ids.add(qindex.getQuestion_id());
        }
        List<Question> questions=questionDao.selectBatchIds(ids);
        long total=iPage.getTotal();
        List<Question> newQuestions=new ArrayList<>();
        for (Question q:questions) {
            newQuestions.add(DealwithQuestion.DealwithOneQuestion(q));
        }
        model.addAttribute("questions",newQuestions);
        model.addAttribute("total",total);
        return "showquestions";
    }

    @PostMapping("/getdata")
    @ResponseBody
    public List<Question> getData(@RequestParam Integer pageNum,@RequestParam String chapterid){
//        Page<Question> questionPage = questionService.pageGetQuestionByCateId(pageNum, chapterid);
        List<Question> questions=questionService.get10QuestionByCateid(pageNum,chapterid);
        List<Question> newQuestions=new ArrayList<>();
        for (Question q:questions) {
            newQuestions.add(DealwithQuestion.DealwithOneQuestion(q));
        }
        return newQuestions;
    }

    @PostMapping("/show")
    @ResponseBody
    public List<Question> show1(@RequestParam String chapterid){
//        Page<Question> questionPage = questionService.pageGetQuestionByCateId(pageNum, chapterid);
        List<Question> questions=questionService.get10QuestionByCateid(1,chapterid);
        List<Question> newQuestions=new ArrayList<>();
        for (Question q:questions) {
            newQuestions.add(DealwithQuestion.DealwithOneQuestion(q));
        }
        return newQuestions;
    }

    @GetMapping("/test/{pagenum}")
    @ResponseBody
    public List<Question> test(@PathVariable Integer pagenum){
        return questionService.get10QuestionByCateid(pagenum,"10270");
    }
}
