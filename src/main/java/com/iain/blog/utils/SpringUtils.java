package com.iain.blog.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @Classname SpringUtils
 * @Description Spring Bean 工厂，用于获取容器内的Bean实例。
 * @Date 2021/5/15 上午10:58
 * @Created by wht
 */
public class SpringUtils implements BeanFactoryPostProcessor {

    private static BeanFactory BEAN_FACTORY;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        this.BEAN_FACTORY = configurableListableBeanFactory;
    }
}
