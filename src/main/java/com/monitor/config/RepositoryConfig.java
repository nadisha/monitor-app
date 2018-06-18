package com.monitor.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"com.monitor.dao"})
@PropertySource(name="propertyConfig", value = {"classpath:config.properties"})
@EnableTransactionManagement
public class RepositoryConfig {
	
	@Autowired
	private Environment env;

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName(env.getProperty("jdbc_driver_class"));
		bds.setUrl(env.getProperty("jdbc_url"));
		bds.setUsername(env.getProperty("jdbc_username"));
		bds.setPassword(env.getProperty("jdbc_password"));
		bds.setMaxIdle(Integer.parseInt(env.getProperty("jdbc_max_active")));
		bds.setInitialSize(Integer.parseInt(env.getProperty("jdbc_initial_size")));
		bds.setMaxIdle(Integer.parseInt(env.getProperty("jdbc_max_idle")));
		bds.setMinIdle(Integer.parseInt(env.getProperty("jdbc_min_idle")));
		bds.setMaxWaitMillis(Integer.parseInt(env.getProperty("jdbc_max_waitmillis")));		
		return bds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource());
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan(getPackagesToScan());
		factory.setDataSource(dataSource());		
		factory.setJpaProperties(additionalProperties());
		factory.afterPropertiesSet();

		return factory.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
		
	private String[] getPackagesToScan() {
		String [] packages = {
				"com.monitor.domain"
		};
		return packages;
	}
	
	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("jpa.hibernate.ddl.auto"));
		properties.setProperty("hibernate.dialect", env.getProperty("jpa.properties.hibernate.dialect"));
		return properties;
	}	
}
