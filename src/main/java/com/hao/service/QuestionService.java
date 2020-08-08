package com.hao.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hao.domain.Question;

import java.util.List;

/**
 * @author jack hao
 * @createTime 2020-08-02-21:17
 */
public interface QuestionService {
//    通过id获取题干数据
    public Question getQuestionById(String id);

    //通过章节ID获取该章节的所有试题信息（分页）
    public Page<Question> pageGetQuestionByCateId(Integer pagenum, String cateid);

    public List<Question> get10QuestionByCateid(Integer pagenum, String cateid);
}
