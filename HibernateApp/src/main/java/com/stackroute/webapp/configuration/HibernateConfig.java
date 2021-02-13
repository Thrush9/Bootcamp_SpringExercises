package com.stackroute.webapp.configuration;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.stackroute.webapp.model.User;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {

	@Bean
	public DataSource getDataSource() {
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/portal");
		source.setUsername("root");
		source.setPassword("root");
        return source;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory(DataSource source) throws IOException {
		LocalSessionFactoryBean sessionfactory = new LocalSessionFactoryBean();
		sessionfactory.setDataSource(source);
		Properties property=new Properties();
		property.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
		property.put("hibernate.hbm2ddl.auto", "update");
		property.put("hibernate.show_sql","true");
		sessionfactory.setHibernateProperties(property);
		sessionfactory.setAnnotatedClasses(User.class);
		sessionfactory.afterPropertiesSet();
		return sessionfactory;
	}
	
	@Bean
	public HibernateTransactionManager getTransaction(SessionFactory sessionfactory)
	{
		HibernateTransactionManager manager=new HibernateTransactionManager();
		manager.setSessionFactory(sessionfactory);
		return manager;
		
	}

}
