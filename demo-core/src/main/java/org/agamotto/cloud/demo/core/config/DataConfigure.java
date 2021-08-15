package org.agamotto.cloud.demo.core.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan("org.agamotto.cloud.demo.core.mapper")
public class DataConfigure {


 /*   public DataConfigure(DataSourceProperties dataSourceProperties) {
        if (StringUtils.isEmpty(dataSourceProperties.getDriverClassName())) {
            dataSourceProperties.setDriverClassName(com.mysql.cj.jdbc.Driver.class.getName());
        }
        if (StringUtils.isEmpty(dataSourceProperties.getPassword())) {
            dataSourceProperties.setPassword("agamotto123");
        }
        if (StringUtils.isEmpty(dataSourceProperties.getUsername())) {
            dataSourceProperties.setUsername("root");
        }
    }*/
}
