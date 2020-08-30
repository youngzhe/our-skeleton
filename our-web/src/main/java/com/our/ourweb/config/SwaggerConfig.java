package com.our.ourweb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpSession;

/**
 * @Auther:
 * @Date:
 * @Description:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Value("${spring.profiles.active}")
    /**
     * 当前激活的配置文件
     */
    private String env;

    private static final String ENV_RELEASE = "release";

    @Bean
    public Docket commonDocket() {
        // ignoredParameterTypes 忽略参数类型，实现在接口文档中隐藏接口的某个参数
        boolean swaggerEnable = Boolean.TRUE;
        /**生产环境禁用swagger,防止暴露接口信息**/
        if (env.equals(ENV_RELEASE)) {
            swaggerEnable = Boolean.FALSE;
        }
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("会议管理系统接口文档").apiInfo(apiInfo())
                .ignoredParameterTypes(HttpSession.class)
                .enable(swaggerEnable)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.boe.cto.smmapi.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("会议管理系统接口文档")
                .description("会议管理系统的接口文档，符合RESTful API。")
                .version("0.0.1-SNAPSHOT")
                .build();
    }


}
