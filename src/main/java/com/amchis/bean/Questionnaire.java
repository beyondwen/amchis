package com.amchis.bean;

import lombok.Data;

@Data
public class Questionnaire {
    //id
    private Integer id;

    //姓名
    private String userName;

    //(未查看/已查看查看)
    private String valid;

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
    private String[] favoriteSport;
    private String favoriteSports;

    //周锻炼时间
    private String[] weeklyExerciseTime;
    private String weeklyExerciseTimes;

    //健康投资
    private String[] healthInvestment;
    private String healthInvestments;

    //糖尿病
    private String[] diabetes;
    private String diabetess;

    //心血管疾病
    private String[] cardiovascularDisease;
    private String cardiovascularDiseases;

    //皮肤病
    private String[] skinDisease;
    private String skinDiseases;

    //感染
    private String[] infection;
    private String infections;

    //在服药物及不良反应
    private String adverseReactions;

    //家族病史
    private String[] medicalHistory;
    private String medicalHistorys;

    //手术史
    private String historyOfSurgery;

    //创建时间
    private String createTime;
}