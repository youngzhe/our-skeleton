package com.our.ourweb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 重写请求映射处理器处理版本url映射
 *
 * @author chen
 * @version v1.0
 * @ClassName WebMvcConfig
 * @create 2018年10月31日 下午3:38:49
 * @lastUpdate 2018年10月31日 下午3:38:49
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Value("${file.static-map-path}")
    private String staticMapPath;
    @Value("${file.static-location}")
    private String staticLocation;


    @Bean
    public AuthRestInterceptor getAuthInterceptor() {
        return new AuthRestInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] patterns = new String[]{"/login", "/*.html", "/swagger-resources/**", "/webjars/**", "/v2/api-docs"};
        registry.addInterceptor(getAuthInterceptor())
                .addPathPatterns("/**")
                .order(2)
                .excludePathPatterns(patterns);

//        registry.addInterceptor(getAuthInterceptor())
//                .addPathPatterns("/v1/**")
//                .order(1)
//                .excludePathPatterns(patterns);
    }
    /**
     * 拦截器对跨域处理有影响，这里用filter来处理跨域
     */
    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        // 允许请求带有验证信息
        config.setAllowCredentials(true);
        // 设置你要允许的网站域名，如果全允许则设为 *
        config.addAllowedOrigin("*");
        // 如果要限制 HEADER 或 METHOD 请自行更改
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        // 这个顺序很重要，为避免麻烦请设置在最前
        bean.setOrder(0);
        return bean;
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(staticMapPath).addResourceLocations("file:" + staticLocation);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("*");
    }

//    /**
//     * 配置转换器:将null转换为空串
//     */
//    @Bean
//    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
//        final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        JsonObjectMapper mapper = new JsonObjectMapper();
//        converter.setObjectMapper(mapper);
//        return converter;
//    }
//
//    /**
//     * 注册转换器
//     */
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(mappingJackson2HttpMessageConverter());
//    }

    /*@Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader(CorsConfiguration.ALL);
        config.addAllowedMethod(CorsConfiguration.ALL);
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }*/
}