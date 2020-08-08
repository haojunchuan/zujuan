package com.hao.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hao.domain.QuestionIndex;

import java.util.List;

/**
 * @author jack hao
 * @createTime 2020-08-08-22:03
 */
public interface QuestionIndexService {
    public List<String> selectIdByCate_page(Integer page,String cateid);

    public long getTotal(Integer pagenum,String cateid);

    public Page<QuestionIndex> getIPage(Integer pagenum,String cateid);
}
