package com.hao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hao.domain.Question;
import org.apache.ibatis.annotations.Select;

/**
 * @author jack hao
 * @createTime 2020-08-02-21:13
 */
public interface QuestionDao extends BaseMapper<Question> {
    @Select("select * from question where cateid=#{cid}")
    public Question[] selectByCateId(String cid);
}
