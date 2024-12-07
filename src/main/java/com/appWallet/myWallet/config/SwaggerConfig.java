package com.appWallet.myWallet.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Wallet service api",
                description = "API wallet",
                version = "1.0.0",
                contact = @Contact(
                        name = "Roman",
                        email = "leo_dialog@mail.ru",
                        url = "https://ro"
                )
        )
)
@SecurityScheme(
        name = "JWT",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class SwaggerConfig {

//    @Bean
//    public OpenAPI createOpenAPI() {
//        return new OpenAPI()
//                .info(new Info()
//                        .title("Wallet api iui")
//                        .description("API documentation iii")
//                        .version("1.0"));
//    }
}
