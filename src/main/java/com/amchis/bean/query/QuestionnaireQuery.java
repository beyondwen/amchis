package com.amchis.bean.query;

import lombok.Data;

@Data
public class QuestionnaireQuery extends BasePageQuery {

    private String name;

    private Integer id;

    private String startTime;

    private String endTime;
}
