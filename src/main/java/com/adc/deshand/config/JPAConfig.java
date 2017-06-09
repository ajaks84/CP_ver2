package com.adc.deshand.config;

import java.net.URI;
import java.net.URISyntaxException;

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

	String databaseUrl = System.getenv("DATABASE_URL");
	URI dbUri = getUri();
	private URI getUri() {
		try {
			dbUri = new URI(databaseUrl);
		} catch (URISyntaxException e) {
			return null;
		}
		return dbUri;
	}
	String username = dbUri.getUserInfo().split(":")[0];
	String password = dbUri.getUserInfo().split(":")[1];
	String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+databaseUrl);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+dbUrl);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+username);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+password);

		DriverManagerDataSource driver = new DriverManagerDataSource();
		driver.setDriverClassName("org.postgresql.Driver");
		driver.setUrl(dbUrl);
		driver.setUsername(username);
		driver.setPassword(password);

		return driver;
	}
	
	// That is for embedded DB
	
	// @Bean(name = "dataSource")
	// public DataSource dataSource() {
	// return new
	// EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).setName("myDb")
	// .addScript("classpath:schema.sql").addScript("classpath:data.sql").build();
	// }

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.POSTGRESQL);
//		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan(getClass().getPackage().getName());
		factory.setDataSource(dataSource());
		factory.setPackagesToScan(new String[] { "com.adc.deshand.persist" });

		return factory;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	public DozerBeanMapper getMapper() {
		return new DozerBeanMapper();
	}

}
