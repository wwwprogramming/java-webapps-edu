package edu.uta.sis.cnfg.config.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import javax.transaction.TransactionManager;
import java.util.Properties;

/**
 * Created by Hannu Lohtander on 17.4.2016.
 */

@Configuration
@ComponentScan(value = "edu.uta.sis.cnfg.domain.*")
@PropertySource(value = "classpath:app.properties", ignoreResourceNotFound = true)
@EnableTransactionManagement
public class AppConfig {

    @Autowired
    Environment env;

    /**
     * Property placeholder configurer needed to process @Value annotations
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(name = "entityManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        // configure and return a class having @Transactional methods
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dataSource());
        bean.setPackagesToScan("edu.uta.sis");
        bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("app.hbm2ddl.auto"));
        jpaProperties.setProperty("hibernate.dialect", env.getProperty("app.hibernate.dialect"));
        jpaProperties.setProperty("hibernate.connection.useUnicode", "true");
        jpaProperties.setProperty("hibernate.connection.characterEncoding", "utf8");
        jpaProperties.setProperty("hibernate.connection.charSet", "utf8");
        jpaProperties.setProperty("hibernate.dialect", env.getProperty("app.hibernate.dialect"));


        bean.setJpaProperties(jpaProperties);
        return bean;
    }

    @Bean
    public DataSource dataSource() {
        // configure and return the necessary JDBC DataSource
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(env.getProperty("app.db.driver"));
        driverManagerDataSource.setUrl(env.getProperty("app.db.url"));
        driverManagerDataSource.setUsername(env.getProperty("app.db.user"));
        driverManagerDataSource.setPassword(env.getProperty("app.db.password"));
        return driverManagerDataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

    /***
    @Bean
    public JpaTransactionManager txManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }
    **/
}
