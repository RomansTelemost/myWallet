package com.appWallet.myWallet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class TestDatasourceConfig implements DataSourceConf {

    public TestDatasourceConfig() {
        String a = "a";
    }

//    @Bean
    public void devBean() {
        String a = "a";
    }
}
