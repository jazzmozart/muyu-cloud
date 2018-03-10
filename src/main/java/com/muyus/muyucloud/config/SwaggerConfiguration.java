package com.muyus.muyucloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletContext;

/**
 * SwaggerConfiguration
 *
 * @author: WangHui
 * @email: adan_wang@dingyuegroup.cn
 * @date: 2018/3/3
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket createRestApi(ServletContext servletContext) {
        return new Docket(DocumentationType.SWAGGER_2)
                .host("http://blog.muyus.com")
                .pathProvider(new RelativePathProvider(servletContext))
                .groupName("木渔博客")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.muyus.muyucloud.view.api.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("更多Spring Boot相关文章请关注：http://www.muyus.com")
                .termsOfServiceUrl("http://blog.muyus.com")
                .version("1.0")
                .build();
    }

}
