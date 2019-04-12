package com.amchis;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.amchis.mapper")
@NacosPropertySource(dataId = "amchisofficalwebsite", autoRefreshed = true)
public class AmchisApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmchisApplication.class, args);
    }

}
