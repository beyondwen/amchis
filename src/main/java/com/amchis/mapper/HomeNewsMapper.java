package com.amchis.mapper;

import com.amchis.bean.HomeNews;
import com.amchis.bean.query.HomeNewQuery;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeNewsMapper {
    int deleteByPrimaryKey(int newsId);

    int insert(HomeNews record);

    int insertSelective(HomeNews record);

    HomeNews selectByPrimaryKey(int newsId);

    Page<HomeNews> getNews(HomeNewQuery query);

    int updateByPrimaryKeySelective(HomeNews record);

    int updateByPrimaryKey(HomeNews record);
}