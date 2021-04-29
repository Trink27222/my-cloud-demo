package com.trink.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfiguration {
    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        //stat视图设置StatViewServlet()
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*"); //对应路径映射
        Map<String, String> initParameters = new HashMap();
        initParameters.put("loginUsername", "admin"); // 登录监控页面的用户名
        initParameters.put("loginPassword", "admin"); // 登录监控页面的密码
        initParameters.put("resetEnable", "false"); // 禁用HTML页面上的“Reset All”功能
        initParameters.put("allow", ""); // IP白名单 (没有配置或者为空，则允许所有访问)
        initParameters.put("deny", "192.168.20.38");// IP黑名单 (存在共同时，deny优先于allow),如果满足deny的话提示:Sorry, you are not permitted to view this page.
        servletRegistrationBean.setInitParameters(initParameters);
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        WebStatFilter webStatFilter = new WebStatFilter();
        webStatFilter.setProfileEnable(true);
        webStatFilter.setSessionStatEnable(true);
        filterRegistrationBean.setFilter(webStatFilter);
        filterRegistrationBean.addUrlPatterns("/*");
        Map<String, String> initParameters = new HashMap();
        initParameters.put("sessionStatMaxCount", "1000");
        initParameters.put("principalCookieName", "USER_COOKIE");
        initParameters.put("principalSessionName", "USER_SESSION");
        initParameters.put("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*"); //设置忽略资源
        filterRegistrationBean.setInitParameters(initParameters);
        return filterRegistrationBean;
    }

}