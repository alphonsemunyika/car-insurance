package com.alphonsemunyika.insure.config;

import static org.hibernate.cfg.AvailableSettings.C3P0_ACQUIRE_INCREMENT;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_STATEMENTS;
import static org.hibernate.cfg.AvailableSettings.C3P0_MIN_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_TIMEOUT;
import static org.hibernate.cfg.AvailableSettings.DRIVER;
import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;
import static org.hibernate.cfg.AvailableSettings.PASS;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;
import static org.hibernate.cfg.AvailableSettings.URL;
import static org.hibernate.cfg.AvailableSettings.USER;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.alphonsemunyika.insure.model.Claim;
import com.alphonsemunyika.insure.model.Insured;
import com.alphonsemunyika.insure.model.Policy;
import com.alphonsemunyika.insure.model.Vehicle;

@Configuration
//@Import(HibernateConfig.class)
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.alphonsemunyika.insure.service","com.alphonsemunyika.insure.model","com.alphonsemunyika.insure.dao","com.alphonsemunyika.insure.config"},excludeFilters={@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)})
public class AppConfig {
	@Autowired
	Environment env;
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean fb = new LocalSessionFactoryBean();
		Properties props=new Properties();
		
		props.put(DRIVER, env.getProperty("jdbc.driverClassName"));
		props.put(URL, env.getProperty("jdbc.url"));
		props.put(USER, env.getProperty("jdbc.user"));
		props.put(PASS, env.getProperty("jdbc.pass"));
		
		props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
		props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
		
		//c3p0
		props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
		props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
		props.put(C3P0_ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
		props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
		props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statemnts"));
		
		fb.setHibernateProperties(props);
		fb.setPackagesToScan("com.alphonsemunyika.insure.model");
		return fb;
	}
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager= new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}
	@Bean
	public Vehicle vehicle() {
	return new Vehicle();	
	}
	
	@Bean
	public Insured insured() {
		return new Insured();
	}
	
	@Bean
	public Claim claim() {
		return new Claim();
	}
	
	@Bean
	public Policy policy() {
		return new Policy();
	}
}