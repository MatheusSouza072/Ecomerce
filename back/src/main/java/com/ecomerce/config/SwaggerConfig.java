package com.ecomerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
public class SwaggerConfig {

    private static final String BASE_PACKAGE = "com.ecomerce";
    private static final String API_TITLE = "User Register";
    private static final String API_DESCRIPTION = "Api for register users";
    private static final String API_VERSION = "1.0.0";
    private static final String CONTACT_NAME = "Adriel Graminho e Leonnan Lessa";
    private static final String CONTACT_SITE = "https://github.com/AdrielGraminho";
    private static final String CONTACT_EMAIL = "adrielgraminho@gmail.com";

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ecomerce"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(buildApiInfo());
    }

    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title(API_TITLE)
                .description(API_DESCRIPTION)
                .version(API_VERSION)
                .contact(new Contact(CONTACT_NAME, CONTACT_SITE, CONTACT_EMAIL))
                .build();
    }
}
