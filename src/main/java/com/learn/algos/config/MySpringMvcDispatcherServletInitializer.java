package com.learn.algos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
@EnableWebSecurity
public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    public MySpringMvcDispatcherServletInitializer() {
	// TODO Auto-generated constructor stub
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
	return new Class[] { SecurityConfigurerAdapter.class, HibernateConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
	return new Class[] { AppConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
	// TODO Auto-generated method stub
	return new String[] { "/" };
    }

//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//	// TODO Auto-generated method stub
//	return null;
//    }

}
