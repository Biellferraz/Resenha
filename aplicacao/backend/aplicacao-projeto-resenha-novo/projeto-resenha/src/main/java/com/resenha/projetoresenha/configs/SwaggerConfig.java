package com.resenha.projetoresenha.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.resenha.projetoresenha.controle"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {

        ApiInfo apiInfo2 = new ApiInfoBuilder()
                .title("Resenha API REST")
                .description("Essa é uma API para agendamentos de quadras")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0%22")
                .termsOfServiceUrl("/service.html")
                .version("1.0.0")
                .contact(new Contact("@Resenha", "https://github.com/Biellferraz/Resenha", "212-3b-grupo9@bandtec.com.br"))
                .build();

        return apiInfo2;
    }

}
