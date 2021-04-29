package com.trink.mybatisplusconfig;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Trink丶
 */
@Configuration
public class MPConfiguration {
    /**
     * 逻辑删除，mybatis plus 3.1.1后无需配置
     * @return
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }
}