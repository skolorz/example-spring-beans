package com.example.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Slf4j
public class MyBean implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, InitializingBean, DisposableBean {

    private String beanName;

    @Override
    public void setBeanName(String name) {
        beanName = name;
        log.debug(beanName + ": " + ("Name of the bean: " + name));
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        log.debug(beanName + ": " + "ClassLoader instance passed");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.debug(beanName + ": " + "BeanFactory instance passed");
    }

    @Override
    public void afterPropertiesSet() {
        log.debug(beanName + ": " + "Properties are set");
    }

    @PostConstruct
    public void exampleConstructMethod() {
        log.debug(beanName + ": " + "Method with @PostConstruct annotation");
    }

    @Override
    public void destroy() {
        log.debug(beanName + ": " + "Method destroy has been called");
    }

    @PreDestroy
    public void exampleDestroyMethod() {
        log.debug(beanName + ": " + "Method with @PreDestroy annotation");
    }
}
