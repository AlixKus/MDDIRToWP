package com.mcs.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.mcs.MDAppliction;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackageClasses = MDAppliction.class)
@PropertySource("classpath:/config.properties")
public class RootConfig {
	Logger log = LoggerFactory.getLogger(RootConfig.class);

	@Bean
	public String testProperties(@Value("${root}") String root) {
		log.info(root);
		return root;
	}

	@Bean
	public DataSource HikariCP() {
		HikariConfig config = new HikariConfig("src/main/resources/config/dataSource.properties");
		return new HikariDataSource(config);
	}

	@Bean
	public SqlSessionFactoryBean SqlSessionFactoryBean(DataSource dataSource) {
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setDataSource(dataSource);
		factory.setConfigLocation(new ClassPathResource("/config/mybatis/mybatis-config.xml"));
		return factory;
	}

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("SqlSessionFactoryBean");
		mapperScannerConfigurer.setBasePackage("com.mcs.repository");
		return mapperScannerConfigurer;
	}

	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager(DataSource ds) {
		DataSourceTransactionManager manager = new DataSourceTransactionManager();
		manager.setDataSource(ds);
		return manager;
	}
}
