package com.trink.config;

import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultBeanFactoryPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Aspect //相当于做了一个AOP
@Configuration
public class DruidSpringConfiguration {
    /**
     * 拦截器
     * @return
     */
    @Bean
    public DruidStatInterceptor druidStatInterceptor() {
        return new DruidStatInterceptor();
    }
    /**
     * 切点
     * @return
     */
    @Bean
    @Scope("prototype")
    public JdkRegexpMethodPointcut druidStatPointcut() {
        JdkRegexpMethodPointcut jdkRegexpMethodPointcut = new JdkRegexpMethodPointcut();
        //指明需要监控的类
        jdkRegexpMethodPointcut.setPatterns("com.trink.controller.*", "com.trink.service.*");
        return jdkRegexpMethodPointcut;
    }
    /**
     * 通知
     * @return
     */
    @Bean
    public Advisor druidAdviceAdvisor() {
        DefaultBeanFactoryPointcutAdvisor defaultBeanFactoryPointcutAdvisor = new DefaultBeanFactoryPointcutAdvisor();
        defaultBeanFactoryPointcutAdvisor.setAdvice(druidStatInterceptor());
        defaultBeanFactoryPointcutAdvisor.setPointcut(druidStatPointcut());
        return defaultBeanFactoryPointcutAdvisor;
    }
}