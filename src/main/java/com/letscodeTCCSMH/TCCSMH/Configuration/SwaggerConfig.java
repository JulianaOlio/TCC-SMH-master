package com.letscodeTCCSMH.TCCSMH.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
@EnableWebMvc

public class SwaggerConfig  implements WebMvcConfigurer {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfoSistemaManutencaoHeadSet(){
        return new ApiInfoBuilder().title("Sistema Manutencao HeadSet")
                .description("endpoint Sistema Manutencao HeadSet")
                .contact(new Contact( "Sistema Manutencao HeadSet", null, "sistema.manutencao.headset@bradesco.com.br"))
                        .license ("Apache 2.0")
                        .licenseUrl ("http://www.apache.org/licenses/LICENSES-2.0.html")
                        .build ();
    }

    }

