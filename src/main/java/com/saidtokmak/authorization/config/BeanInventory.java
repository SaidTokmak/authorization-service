package com.saidtokmak.authorization.config;


import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class BeanInventory {

    private final ConfigurableApplicationContext configurableApplicationContext;

    public BeanInventory(ConfigurableApplicationContext context) {
        this.configurableApplicationContext = context;
    }

    @PostConstruct
    public void after() {
        String[] allBeanNames = configurableApplicationContext.getBeanDefinitionNames();
        AtomicInteger counter = new AtomicInteger();
        String SPACE = " ";

        Arrays.stream(allBeanNames)
                .sorted()
                .map(beanName -> counter.incrementAndGet() +
                        SPACE +
                        beanName)
                .forEach(System.out::println);
    }
}
