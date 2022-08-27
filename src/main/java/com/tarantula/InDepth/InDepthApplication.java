package com.tarantula.InDepth;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class InDepthApplication {

    private static final Logger mainLogger = LoggerFactory.getLogger(InDepthApplication.class);

    public static void main(String[] args) {
        ApplicationContext appContext = SpringApplication.run(InDepthApplication.class, args);
//        System.out.println("Total beans count: " + appContext.getBeanDefinitionCount());
        mainLogger.info("Total beans count: " + appContext.getBeanDefinitionCount());
    }

//    @Bean
//    public CommandLineRunner yohoho(ApplicationContext applicationContext) {
//        return args -> {
//            String[] beans = applicationContext.getBeanDefinitionNames();
//            beansModel.setBeans(beans);
//        };
//    }

}
