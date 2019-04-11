package com.amchis.bean;

import lombok.Data;

@Data
public class Questionnaire {
    //id
    private Integer id;

    //姓名
    private String userName;

    //性别
    private String gender;

    //手机号码
    private String phone;

    //职业
    private String career;

    //文化程度
    private String educationalLevel;

    //婚姻状况
    private String maritalStatus;

    //睡眠状况
    private String sleepCondition;

    //吸烟情况
    private String smoking;

    //饮酒情况
    private String drink;

    //喜欢的运动
    private String favoriteSport;

    //周锻炼时间
    private String weeklyExerciseTime;

    //健康投资
    private String healthInvestment;

    //糖尿病
    private String diabetes;

    //心血管疾病
    private String cardiovascularDisease;

    //皮肤病
    private String skinDisease;

    //感染
    private String infection;

    //在服药物及不良反应
    private String adverseReactions;

    //家族病史
    private String medicalHistory;

    //手术史
    private String historyOfSurgery;

    //创建时间
    private String createTime;
}