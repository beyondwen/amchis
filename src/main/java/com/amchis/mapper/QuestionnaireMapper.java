package com.amchis.mapper;

import com.amchis.bean.Questionnaire;
import com.amchis.bean.query.QuestionnaireQuery;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionnaireMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Questionnaire record);

    int insertSelective(Questionnaire record);

    Questionnaire selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Questionnaire record);

    int updateByPrimaryKey(Questionnaire record);

    Page<Questionnaire> getQuestionnaire(QuestionnaireQuery query);
}