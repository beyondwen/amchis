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
        String[] favoriteSport = record.getFavoriteSport();
        StringBuilder favoriteSports = new StringBuilder();
        processString(favoriteSport, favoriteSports);
        record.setFavoriteSports(favoriteSports.toString());

        String[] weeklyExerciseTime = record.getWeeklyExerciseTime();
        StringBuilder weeklyExerciseTimes = new StringBuilder();
        processString(weeklyExerciseTime, weeklyExerciseTimes);
        record.setWeeklyExerciseTimes(weeklyExerciseTimes.toString());

        String[] healthInvestment = record.getHealthInvestment();
        StringBuilder healthInvestments = new StringBuilder();
        processString(healthInvestment, healthInvestments);
        record.setHealthInvestments(healthInvestments.toString());

        String[] diabetes = record.getDiabetes();
        StringBuilder diabetess = new StringBuilder();
        processString(diabetes, diabetess);
        record.setDiabetess(diabetess.toString());

        String[] cardiovascularDisease = record.getCardiovascularDisease();
        StringBuilder cardiovascularDiseases = new StringBuilder();
        processString(cardiovascularDisease, cardiovascularDiseases);
        record.setCardiovascularDiseases(cardiovascularDiseases.toString());

        String[] skinDisease = record.getSkinDisease();
        StringBuilder skinDiseases = new StringBuilder();
        processString(skinDisease, skinDiseases);
        record.setSkinDiseases(skinDiseases.toString());

        String[] infection = record.getInfection();
        StringBuilder infections = new StringBuilder();
        processString(infection, infections);
        record.setInfections(infections.toString());

        String[] medicalHistory = record.getMedicalHistory();
        StringBuilder medicalHistorys = new StringBuilder();
        processString(medicalHistory, medicalHistorys);
        record.setMedicalHistorys(medicalHistorys.toString());
        return questionnaireMapper.insert(record);
    }

    /**
     * 去除最后一个逗号
     *
     * @param strings       多选数组
     * @param stringBuilder sb
     */
    private void processString(String[] strings, StringBuilder stringBuilder) {
        int length = strings.length;
        int mark = 0;
        for (String s : strings) {
            stringBuilder.append(s);
            mark++;
            if (length != mark) {
                stringBuilder.append(",");
            }
        }
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