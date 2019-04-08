package com.amchis.bean.query;

import lombok.Data;

@Data
public class BasePageQuery {

    private int pageNo = 1;
    private int pageSize = 10;
}
