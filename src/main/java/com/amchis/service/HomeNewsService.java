package com.amchis.service;

import com.amchis.bean.HomeNews;
import com.amchis.bean.query.HomeNewQuery;
import com.amchis.mapper.HomeNewsMapper;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeNewsService {

    @Autowired
    private HomeNewsMapper homeNewsMapper;

    public int deleteByPrimaryKey(int newsId) {
        return homeNewsMapper.deleteByPrimaryKey(newsId);
    }

    public int insert(HomeNews record) {
        return homeNewsMapper.insert(record);
    }

    public int insertSelective(HomeNews record) {
        return homeNewsMapper.insertSelective(record);
    }

    public HomeNews selectByPrimaryKey(int newsId) {
        return homeNewsMapper.selectByPrimaryKey(newsId);
    }

    public int updateByPrimaryKeySelective(HomeNews record) {
        return homeNewsMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(HomeNews record) {
        return homeNewsMapper.updateByPrimaryKey(record);
    }

    public Page<HomeNews> getNews(HomeNewQuery query) {
        Integer classification = query.getClassification();
        Integer type = query.getType();
        if (0 == classification) {
            classification = null;
            query.setClassification(classification);
        }
        if (0 == type) {
            type = null;
            query.setType(type);
        }
        return homeNewsMapper.getNews(query);
    }
}