package com.amchis.controller;

import com.amchis.bean.HomeNews;
import com.amchis.bean.base.BaseApiService;
import com.amchis.bean.base.BaseResponse;
import com.amchis.bean.query.HomeNewQuery;
import com.amchis.common.DateUtils;
import com.amchis.service.HomeNewsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 官网相关
 */
@RestController
@RequestMapping("/officialwebsite")
public class HomeNewsController extends BaseApiService<HomeNews> {

    @Autowired
    private HomeNewsService homeNewsService;

    /**
     * 添加修改
     *
     * @param record        新闻记录
     * @param bindingResult 校验
     * @return 统一封装返回信息
     */
    @PostMapping(value = "/addNews")
    public BaseResponse<HomeNews> addNews(@Valid @RequestBody HomeNews record, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String defaultMessage = bindingResult.getFieldError().getDefaultMessage();
            return setResultError(defaultMessage);
        } else {
            if ((record.getId() == 0)) {
                record.setCreateTime(DateUtils.getTime());
                record.setNewIsValid(1);
                //record.setCreateUserid(UserUtils.getCurrentUser().getId() + "");
                //record.setCreateUsername(UserUtils.getCurrentUser().getUsername() + "");
                int i = homeNewsService.insertSelective(record);
                if (!toDaoResult(i)) {
                    return setResultError("系统错误");
                }
            } else {
                record.setNewIsValid(1);
                record.setUpdateTime(DateUtils.getTime());
                //record.setUpdateUserid(UserUtils.getCurrentUser().getId() + "");
                //record.setUpdateUsername(UserUtils.getCurrentUser().getUsername() + "");
                int i = homeNewsService.updateByPrimaryKeySelective(record);
                if (!toDaoResult(i)) {
                    return setResultError("系统错误");
                }
            }
            return setResultSuccess();
        }
    }

    /**
     * 新闻列表查询
     *
     * @param query 新闻查询
     * @return 分页
     */
    @PostMapping(value = "/news")
    public PageInfo<HomeNews> lists(@RequestBody HomeNewQuery query) {
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        PageInfo<HomeNews> pageInfo = new PageInfo(homeNewsService.getNews(query));
        return pageInfo;
    }

    /**
     * 获取一条新闻
     *
     * @param record 参数封装
     * @return 统一返回信息
     */
    @PostMapping(value = "/getOneNews")
    public BaseResponse<HomeNews> getOneNews(@RequestBody HomeNewQuery record) {
        HomeNews homeNews = homeNewsService.selectByPrimaryKey(record.getNewsId());
        return setResultSuccess(homeNews);
    }

    /**
     * 删除新闻
     *
     * @param record 参数封装
     * @return 统一返回信息
     */
    @PostMapping(value = "/deleteNew")
    public BaseResponse<HomeNews> deleteNew(@RequestBody HomeNewQuery record) {
        int i = homeNewsService.deleteByPrimaryKey(record.getNewsId());
        if (!toDaoResult(i)) {
            return setResultError("系统错误");
        }
        return setResultSuccess();
    }

    /**
     * 发布新闻
     *
     * @param record 参数封装
     * @return 统一返回信息
     */
    @PostMapping(value = "/releaseNew")
    public BaseResponse<HomeNews> releaseNew(@RequestBody HomeNewQuery record) {
        HomeNews homeNews = homeNewsService.selectByPrimaryKey(record.getNewsId());
        homeNews.setNewIsValid(0);
        homeNewsService.updateByPrimaryKeySelective(homeNews);
        return setResultSuccess();
    }
}
