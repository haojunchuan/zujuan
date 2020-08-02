package com.hao.service;

import com.hao.domain.Question;

/**
 * @author jack hao
 * @createTime 2020-08-02-21:17
 */
public interface QuestionService {
//    通过id获取题干数据
    public Question getQuestionById(String id);
}
