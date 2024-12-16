package com.appWallet.myWallet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
public class DevDatasourceConfig implements DataSourceConf {

    public DevDatasourceConfig() {
        String b = "b";
    }

//    @Bean
    public void devBean() {
        String b = "b";
    }
}
