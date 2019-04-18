package com.amchis.bean;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class Questionnaire {
    //id
    private Integer id;

    //姓名
    @NotBlank(message = "姓名不能为空")
    private String userName;

    //性别
    @NotBlank(message = "性别不能为空")
    private String gender;

    //(未查看/已查看查看)
    private String valid;

    //手机号码
    @NotBlank(message = "手机号码不能为空")
    private String phone;

    //体重
    @NotNull(message = "体重不能为空")
    private BigDecimal weight;

    //身高
    @NotNull(message = "身高不能为空")
    private BigDecimal height;

    //职业
    @NotBlank(message = "职业不能为空")
    private String career;

    //文化程度
    @NotBlank(message = "文化程度不能为空")
    private String educationalLevel;

    //直系亲属是否有糖尿病
    @NotBlank(message = "直系亲属是否有糖尿病不能为空")
    private String directDiabetes;

    //是否知道糖尿病知识
    @NotBlank(message = "是否知道糖尿病知识不能为空")
    private String isDiabetesKnowledge;

    //糖尿病类型
    @NotBlank(message = "糖尿病类型不能为空")
    private String diabetesType;

    //糖尿病疗法
    private String diabetesTherapy;
    @NotNull(message = "糖尿病疗法不能为空")
    private String[] diabetesTherapys;

    //口味
    @NotBlank(message = "口味不能为空")
    private String taste;

    //水果蔬菜食用情况
    @NotBlank(message = "水果蔬菜食用情况不能为空")
    private String fruitVegetableConsumption;

    //周锻炼时间
    private String weeklyExerciseTime;
    @NotNull(message = "周锻炼时间不能为空")
    private String[] weeklyExerciseTimes;

    //喜欢的运动
    private String favoriteSport;
    @NotNull(message = "喜欢的运动不能为空")
    private String[] favoriteSports;

    //能否保持8小时睡眠
    @NotBlank(message = "能否保持8小时睡眠不能为空")
    private String isKeepSleeping;

    //有哪些病症
    private String illness;
    @NotNull(message = "有哪些病症不能为空")
    private String[] illnesss;

    //健康投资
    private String healthInvestment;
    @NotNull(message = "健康投资不能为空")
    private String[] healthInvestments;

    //吸烟情况
    @NotBlank(message = "吸烟情况不能为空")
    private String smoking;

    //饮酒情况
    @NotBlank(message = "饮酒情况不能为空")
    private String drink;

    //低血糖反应
    @NotBlank(message = "低血糖反应不能为空")
    private String hypoglycemia;

    //其他慢性病
    private String otherChronicDiseases;
    @NotNull(message = "其他慢性病不能为空")
    private String[] otherChronicDiseasess;

    //糖尿病并发症
    @NotBlank(message = "糖尿病并发症不能为空")
    private String diabetesComplications;
    private String[] diabetesComplicationss;

    //是否控制血糖
    @NotBlank(message = "是否控制血糖不能为空")
    private String isControlBloodSugar;

    //控制血糖措施
    private String controlBloodSugarMeasures;
    @NotNull(message = "控制血糖措施不能为空")
    private String[] controlBloodSugarMeasuress;

    //如何使用降糖药
    @NotBlank(message = "如何使用降糖药不能为空")
    private String useHypoglycemicAgents;

    //创建时间
    private String createTime;
}