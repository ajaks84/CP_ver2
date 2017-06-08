package com.adc.deshand.config;

import javax.sql.DataSource;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.adc.deshand.persist")
@EnableJpaRepositories("com.adc.deshand.persist")
public class JPAConfig {

	// @Bean(name = "dataSource")
	// public DataSource dataSource() {
	// return new
	// EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).setName("myDb")
	// .addScript("classpath:schema.sql").addScript("classpath:data.sql").build();
	// }

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource driver = new DriverManagerDataSource();
		driver.setDriverClassName("org.postgresql.Driver");
		driver.setUrl("jdbc:postgresql:counter_project");
		driver.setUsername("postgres");
		driver.setPassword("postgres");

		return driver;
	}

	// @Bean(name = "entityManagerFactory")
	// public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean()
	// {
	// LocalContainerEntityManagerFactoryBean factoryBean = new
	// LocalContainerEntityManagerFactoryBean();
	// factoryBean.setDataSource(dataSource());
	// factoryBean.setPackagesToScan(new String[] { "com.adc.deshand.persist"
	// });
	// HibernateJpaVendorAdapter vendorAdapter = new
	// HibernateJpaVendorAdapter();
	// vendorAdapter.setShowSql(true);
	// factoryBean.setJpaVendorAdapter(vendorAdapter);
	// return factoryBean;
	// }

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.POSTGRESQL);
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan(getClass().getPackage().getName());
		factory.setDataSource(dataSource());
		factory.setPackagesToScan(new String[] { "com.adc.deshand.persist"});

		return factory;
	}

	 @Bean
	 public PlatformTransactionManager transactionManager() {
	 JpaTransactionManager transactionManager = new JpaTransactionManager();
	 transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
	 return transactionManager;
	 }

//	@Bean
//	@Autowired
//	public JpaTransactionManager transactionManager() {
//		JpaTransactionManager txManager = new JpaTransactionManager();
//		txManager.setEntityManagerFactory(entityManagerFactory().getObject());
//
//		return txManager;
//	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	public DozerBeanMapper getMapper() {
		return new DozerBeanMapper();
	}

}
