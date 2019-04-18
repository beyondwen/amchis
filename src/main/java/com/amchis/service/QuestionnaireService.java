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
        String[] favoriteSport = record.getFavoriteSports();
        StringBuilder favoriteSports = new StringBuilder();
        processString(favoriteSport, favoriteSports);
        record.setFavoriteSport(favoriteSports.toString());

        String[] weeklyExerciseTime = record.getWeeklyExerciseTimes();
        StringBuilder weeklyExerciseTimes = new StringBuilder();
        processString(weeklyExerciseTime, weeklyExerciseTimes);
        record.setWeeklyExerciseTime(weeklyExerciseTimes.toString());

        String[] healthInvestment = record.getHealthInvestments();
        StringBuilder healthInvestments = new StringBuilder();
        processString(healthInvestment, healthInvestments);
        record.setHealthInvestment(healthInvestments.toString());

        String[] otherChronicDiseasess = record.getOtherChronicDiseasess();
        StringBuilder diabetess = new StringBuilder();
        processString(otherChronicDiseasess, diabetess);
        record.setOtherChronicDiseases(diabetess.toString());

        String[] illnesss = record.getIllnesss();
        StringBuilder illness = new StringBuilder();
        processString(illnesss, illness);
        record.setIllness(illness.toString());

        String[] diabetesTherapys = record.getDiabetesTherapys();
        StringBuilder diabetesTherapy = new StringBuilder();
        processString(diabetesTherapys, diabetesTherapy);
        record.setDiabetesTherapy(diabetesTherapy.toString());

        String[] controlBloodSugarMeasuress = record.getControlBloodSugarMeasuress();
        StringBuilder controlBloodSugarMeasures = new StringBuilder();
        processString(controlBloodSugarMeasuress, controlBloodSugarMeasures);
        record.setControlBloodSugarMeasures(controlBloodSugarMeasures.toString());

        String[] diabetesComplicationss = record.getDiabetesComplicationss();
        StringBuilder diabetesComplications = new StringBuilder();
        processString(diabetesComplicationss, diabetesComplications);
        record.setDiabetesComplications(diabetesComplications.toString());
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
                stringBuilder.append("、");
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
        Page<Questionnaire> questionnaire = questionnaireMapper.getQuestionnaire(query);
        return questionnaire;
    }
}