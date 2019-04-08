package com.amchis.bean.query;

import lombok.Data;

/**
 * 参数封装
 */
@Data
public class HomeNewQuery extends BasePageQuery {

    /**
     * 新闻id
     */
    private Integer newsId;
    /**
     * 是否有效(0已发布/1未发布)
     */
    private Integer valid;

    /**
     * 新闻类型(1新闻/2论坛)
     */
    private Integer type = 0;

    /**
     * 新闻分类(1/2/3/4/5)
     */
    private Integer classification = 0;

}
