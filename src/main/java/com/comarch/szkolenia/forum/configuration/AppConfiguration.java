package com.comarch.szkolenia.forum.configuration;

import com.comarch.szkolenia.forum.filters.AdminFilter;
import com.comarch.szkolenia.forum.filters.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.comarch.szkolenia.forum")
public class AppConfiguration {

    @Bean
    public FilterRegistrationBean<AdminFilter> adminRegistrationBean(AdminFilter adminFilter) {
        FilterRegistrationBean<AdminFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(adminFilter);
        registrationBean.addUrlPatterns("/addTopic", "/editTopic/*");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<LoginFilter> loginRegistrationBean(LoginFilter loginFilter) {
        FilterRegistrationBean<LoginFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(loginFilter);
        registrationBean.addUrlPatterns(
            "/login",
            "/topics",
            "/topics/*",
            "/posts",
            "/posts/*"
        );
        return registrationBean;
    }
}
