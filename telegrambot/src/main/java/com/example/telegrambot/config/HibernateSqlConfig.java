
package com.example.telegrambot.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.core.env.Environment;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration

@PropertySource({ "classpath:application.properties" })

@EnableJpaRepositories(basePackages = "com.example.telegrambot.repository",
transactionManagerRef = "transactionManager2",
entityManagerFactoryRef = "entityManagerFactory2")
public class HibernateSqlConfig {

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
	public DataSource seconddataSource() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(environment.getRequiredProperty("dataSourceSQLServerClassName"));
		config.setJdbcUrl(environment.getRequiredProperty("dataSourceSQLServer.url"));
		config.setUsername(environment.getRequiredProperty("dataSourceSQLServer.user"));
		config.setPassword(environment.getRequiredProperty("dataSourceSQLServer.password"));
		
		config.addDataSourceProperty("cachePrepStmts", environment.getRequiredProperty("dataSource.cachePrepStmts"));
		config.addDataSourceProperty("prepStmtCacheSize",
				environment.getRequiredProperty("dataSource.prepStmtCacheSize"));
		config.addDataSourceProperty("useServerPrepStmts",
				environment.getRequiredProperty("dataSource.useServerPrepStmts"));
		config.addDataSourceProperty("prepStmtCacheSqlLimit",
				environment.getRequiredProperty("dataSource.prepStmtCacheSqlLimit"));

		return new HikariDataSource(config);

	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory2() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(seconddataSource());
		entityManagerFactory.setPackagesToScan(new String[] { "com.example.telegrambot.model" });
		entityManagerFactory.setJpaProperties(hibernateProperties());
		entityManagerFactory.setPersistenceProvider(new HibernatePersistenceProvider());
		return entityManagerFactory;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager2(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory2().getObject());
		return txManager;
	}

}
