package com.example.telegrambot.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.core.env.Environment;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource({ "classpath:application.properties" })
@EnableJpaRepositories(basePackages = "com.example.telegrambot.repositorymysql")
public class HibernateMySqlConfig {

	@Autowired
	private Environment environment;

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		properties.put("hibernate.hbm2ddl", environment.getRequiredProperty("hibernate.hbm2ddl"));
		return properties;
	}

	@Bean(destroyMethod = "close")
	@Primary
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(environment.getRequiredProperty("dataSourceMysqlClassName"));
		System.out.println(environment.getRequiredProperty("dataSourceMysqlClassName"));

		config.setJdbcUrl(environment.getRequiredProperty("dataSourceMysql.url"));
		System.out.println(environment.getRequiredProperty("dataSourceMysql.url"));

		config.setUsername(environment.getRequiredProperty("dataSourceMysql.user"));
		System.out.println(environment.getRequiredProperty("dataSourceMysql.user"));
		
		config.setPassword("root");
		System.out.println(environment.getRequiredProperty("dataSourceMysql.password"));
		
		config.addDataSourceProperty("cachePrepStmts", environment.getRequiredProperty("dataSource.cachePrepStmts"));
		config.addDataSourceProperty("prepStmtCacheSize",environment.getRequiredProperty("dataSource.prepStmtCacheSize"));
		config.addDataSourceProperty("useServerPrepStmts",environment.getRequiredProperty("dataSource.useServerPrepStmts"));
		config.addDataSourceProperty("prepStmtCacheSqlLimit",environment.getRequiredProperty("dataSource.prepStmtCacheSqlLimit"));

		return new HikariDataSource(config);

	}
	
	
	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setPackagesToScan(new String[] { "com.example.telegrambot.modelmysql" });
		entityManagerFactory.setJpaProperties(hibernateProperties());
		entityManagerFactory.setPersistenceProvider(new HibernatePersistenceProvider());
		return entityManagerFactory;
	}
	
	
	@Primary
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return txManager;
	}
	

}
