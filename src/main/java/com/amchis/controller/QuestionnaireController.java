package com.amchis.controller;

import com.amchis.bean.Questionnaire;
import com.amchis.bean.base.BaseApiService;
import com.amchis.bean.base.BaseResponse;
import com.amchis.bean.query.QuestionnaireQuery;
import com.amchis.common.DateUtils;
import com.amchis.service.QuestionnaireService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 问卷调查
 */
@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController extends BaseApiService<Questionnaire> {

    @Autowired
    private QuestionnaireService questionnaireService;

    /**
     * 添加修改
     *
     * @param record        问卷
     * @param bindingResult 校验
     * @return 统一封装返回信息
     */
    @PostMapping(value = "/add")
    public BaseResponse<Questionnaire> addQuestionnaire(@Valid @RequestBody Questionnaire record, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String defaultMessage = bindingResult.getFieldError().getDefaultMessage();
            return setResultError(defaultMessage);
        } else {
            if ((record.getId() == null)) {
                record.setCreateTime(DateUtils.getTime());
                record.setValid("未查看");
                int i = questionnaireService.insert(record);
                if (!toDaoResult(i)) {
                    return setResultError("系统错误");
                }
                return setResultSuccess();
            }
            return setResultError("保存失败");
        }
    }

    /**
     * 新闻列表查询
     *
     * @param query 新闻查询
     * @return 分页
     */
    @PostMapping(value = "/get")
    public PageInfo<Questionnaire> lists(@RequestBody QuestionnaireQuery query) {
        String startTime = query.getStartTime();
        String endTime = query.getEndTime();
        if (StringUtils.isEmpty(startTime) && StringUtils.isEmpty(endTime)) {
            PageHelper.startPage(query.getPageNo(), query.getPageSize());
        }
        return new PageInfo(questionnaireService.getQuestionnaire(query));
    }

    /**
     * 获取一条新闻
     *
     * @param record 参数封装
     * @return 统一返回信息
     */
    @PostMapping(value = "/getOne")
    public BaseResponse<Questionnaire> getOneQuestionnaire(@RequestBody QuestionnaireQuery record) {
        Questionnaire questionnaire = questionnaireService.selectByPrimaryKey(record.getId());
        questionnaire.setValid("已查看");
        questionnaireService.updateByPrimaryKeySelective(questionnaire);
        return setResultSuccess(questionnaire);
    }
}
