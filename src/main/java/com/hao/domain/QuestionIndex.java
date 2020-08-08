package com.hao.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author jack hao
 * @createTime 2020-08-08-22:02
 */
@Data
@TableName("questionindex")
public class QuestionIndex {
    private Integer id;
    private String question_id;
    private Integer cateid;
}
