package com.hao.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hao.common.Constant;
import com.hao.dao.QuestionIndexDao;
import com.hao.domain.QuestionIndex;
import com.hao.service.QuestionIndexService;
import com.hao.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jack hao
 * @createTime 2020-08-08-22:04
 */
@Service
public class QuestionIndexServiceImpl implements QuestionIndexService {
    @Resource
    QuestionIndexDao questionIndexDao;

    @Override
    public List<String> selectIdByCate_page(Integer pagenum,String cateid) {
        List<String> ids=new ArrayList<>();
        QueryWrapper<QuestionIndex> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("cateid",cateid);
        Page<QuestionIndex> page=new Page<>(pagenum, Constant.PAGE_SIZE);
        Page<QuestionIndex> questionIndexPage = questionIndexDao.selectPage(page, queryWrapper);
        List<QuestionIndex> questionIndexList = questionIndexPage.getRecords();
        for (QuestionIndex qindex:questionIndexList) {
            ids.add(qindex.getQuestion_id());
        }
        return ids;
    }

    @Override
    public long getTotal(Integer pagenum, String cateid) {
        List<String> ids=new ArrayList<>();
        QueryWrapper<QuestionIndex> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("cateid",cateid);
        Page<QuestionIndex> page=new Page<>(pagenum, Constant.PAGE_SIZE);
        return page.getTotal();
    }

    @Override
    public Page<QuestionIndex> getIPage(Integer pagenum, String cateid) {
        List<String> ids=new ArrayList<>();
        QueryWrapper<QuestionIndex> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("cateid",cateid);
        Page<QuestionIndex> page=new Page<>(pagenum, Constant.PAGE_SIZE);
        Page<QuestionIndex> questionIndexPage = questionIndexDao.selectPage(page, queryWrapper);
        return questionIndexPage;
    }
}
