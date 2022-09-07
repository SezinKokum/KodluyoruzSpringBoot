package com.afordisman.bean;

import com.afordisman.dto.BeanDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {

    @Bean(initMethod = "initialBeanMethod44",destroyMethod = "destroyBeanMethod44")
    @Scope("singleton") //request session

    public BeanDto beanDto(){

        return BeanDto.
                builder().
                    id(0L).beanName("bean Adi").beanData("bean Data").
                build();
    }
}