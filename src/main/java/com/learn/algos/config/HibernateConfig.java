package com.learn.algos.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableWebSecurity
@EnableTransactionManagement
public class HibernateConfig {

    @Bean
    public SessionFactory getSessionFactory() throws IOException {
	LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
	factoryBean.setPackagesToScan("com.prototype.toaster");
	factoryBean.setHibernateProperties(getHibernateProperties());
	factoryBean.setDataSource(getDatasource());
	factoryBean.afterPropertiesSet();
	return factoryBean.getObject();
    }

    @Bean
    public DataSource getDatasource() {

	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
	dataSource.setUrl("jdbc:mysql://localhost:3306/toaster_checklist?useSSL=false");
	dataSource.setUsername("toasterconn");
	dataSource.setPassword("toasterconn");

	return dataSource;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() throws IOException {
	HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	transactionManager.setSessionFactory(getSessionFactory());
	return transactionManager;
    }

    private static Properties getHibernateProperties() {
	Properties hibernateProperties = new Properties();
	hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
	hibernateProperties.put("hibernate.show_sql", true);
	hibernateProperties.put("hibernate.c3p0.min_size", 5);
	hibernateProperties.put("hibernate.c3p0.max_size", 10);
	hibernateProperties.put("hibernate.c3p0.acquire_increment", 1);
	hibernateProperties.put("hibernate.c3p0.max_statements", 150);
	hibernateProperties.put("hibernate.hbm2ddl.auto", "update");

	return hibernateProperties;
    }
}