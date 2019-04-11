package com.amchis.service;

import com.amchis.bean.Questionnaire;
import com.amchis.bean.query.QuestionnaireQuery;
import com.amchis.mapper.QuestionnaireMapper;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireService {

    @Autowired
    private QuestionnaireMapper questionnaireMapper;

    public int deleteByPrimaryKey(int id) {
        return questionnaireMapper.deleteByPrimaryKey(id);
    }

    public int insert(Questionnaire record) {
        return questionnaireMapper.insert(record);
    }

    public int insertSelective(Questionnaire record) {
        return questionnaireMapper.insertSelective(record);
    }

    public Questionnaire selectByPrimaryKey(int id) {
        return questionnaireMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Questionnaire record) {
        return questionnaireMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Questionnaire record) {
        return questionnaireMapper.updateByPrimaryKey(record);
    }

    public Page<Questionnaire> getQuestionnaire(QuestionnaireQuery query) {
        return questionnaireMapper.getQuestionnaire(query);
    }
}