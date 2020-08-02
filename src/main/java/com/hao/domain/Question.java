package com.hao.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author jack hao
 * @createTime 2020-07-29-21:31
 */
@Data
@TableName("question")
public class Question {
    @TableId(value = "question_id")
    private String question_id;
    private String question_text;
    private String answer;
    private String explanation;
    private String channel_type_name;
    private String question_channel_type;
    private String question_type;
    private String difficult_index;
    private String difficult_name;
    private String exam_name;
    private String knowledge;
    private String knowledge_path;
    private String category;
    private String category_path;
    private Object options;
    private String paper_source;
    private String paper_title;
    private String paperid;
    private Integer save_num;
    private Integer cateid;
}
