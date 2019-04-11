package com.amchis.bean;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class HomeNews implements Serializable {
    private Integer id;

    private Integer newsType;

    @NotBlank(message = "新闻副标题不能为空")
    private String newsSubTitle;

    @NotBlank(message = "新闻标题不能为空")
    private String newsTitle;

    @NotBlank(message = "新闻内容不能为空")
    private String newsContent;

    private Integer newIsValid;

    private String createTime;

    private String createUserid;

    private String createUsername;

    private String updateTime;

    private String updateUserid;

    private String updateUsername;

    @NotBlank(message = "新闻图片不能为空")
    private String newsMainImage;

    //新闻分类
    private Integer classification;
}