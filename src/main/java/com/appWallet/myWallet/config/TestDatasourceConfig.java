package com.appWallet.myWallet.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class TestDatasourceConfig {
}
