package com.spring.boot.learning.event.config;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource({"classpath:db.properties"})
@EnableJpaRepositories(
    basePackages = "com.spring.boot.learning.event.repository",
    entityManagerFactoryRef = "eventsEntityManager",
    transactionManagerRef = "eventsTransactionManager"
)
public class PersistenceEventsConfiguration {

@Autowired
private Environment env;

@Bean
@Primary
public LocalContainerEntityManagerFactoryBean eventsEntityManager (){
    LocalContainerEntityManagerFactoryBean em
          = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(eventsDataSource(dataSourceProperties()));
        em.setPackagesToScan(
          new String[] { "com.spring.boot.learning.event.model" });

          HibernateJpaVendorAdapter vendorAdapter
          = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto",
          env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect",
          env.getProperty("org.hibernate.dialect.PostgreSQLDialect"));
        em.setJpaPropertyMap(properties);

        return em;

}

@Bean
@Primary
@ConfigurationProperties("spring.datasource")
 public DataSourceProperties dataSourceProperties() {
    return new DataSourceProperties();
}

@Primary
 @Bean
@ConfigurationProperties(prefix = "spring.datasource")
public HikariDataSource  eventsDataSource(DataSourceProperties properties){
    return properties.initializeDataSourceBuilder().type(HikariDataSource.class)
        .build();
 }

@Primary
@Bean
public PlatformTransactionManager eventsTransactionManager() {

    JpaTransactionManager transactionManager
      = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(
        eventsEntityManager().getObject());
    return transactionManager;
}
    
}
