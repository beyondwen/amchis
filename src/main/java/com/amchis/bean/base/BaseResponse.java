package com.amchis.bean.base;

import lombok.Data;

@Data
public class BaseResponse<T> {

    private Integer code;

    private String msg;

    private T obj;


    public BaseResponse() {
    }

    public BaseResponse(Integer code, String msg, T obj) {
        this.code = code;
        this.msg = msg;
        this.obj = obj;
    }
}
