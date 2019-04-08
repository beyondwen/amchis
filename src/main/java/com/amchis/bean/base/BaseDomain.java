package com.amchis.bean.base;

import lombok.Data;

@Data
public class BaseDomain {

    //id
    private String id;

    //创建时间
    private String createTime;

    //创建人
    private String createUser;

    //创建人id
    private String createUserId;

    //更新时间
    private String updateTime;

    //更新人id
    private String updateUserId;

    //更新人
    private String updateUser;

    //是否有效
    private int valid;
}
