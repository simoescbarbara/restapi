package com.spring.boot.learning.vams.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    basePackages = "com.spring.boot.learning.vams.repository",
    entityManagerFactoryRef = "vamsEntityManager",
    transactionManagerRef = "vamsTransactionManager"
)
@EntityScan(basePackages = "com.spring.boot.learning.vams.model")
public class PersistenceVamsConfiguration {
    
    @Autowired
    private Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean vamsEntityManager() {
        LocalContainerEntityManagerFactoryBean em
          = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(vamsDataSource(dataSourcePropertiesVams()));
        em.setPackagesToScan(
          new String[] { "com.spring.boot.learning.vams.model" });

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect",
          env.getProperty("org.hibernate.dialect.PostgreSQLDialect"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    @ConfigurationProperties("spring.second-datasource")
    public DataSourceProperties dataSourcePropertiesVams() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties( prefix = "spring.second-datasource")
    public DataSource vamsDataSource(DataSourceProperties properties){
      properties.setUrl(env.getProperty("spring.second-datasource.url"));
      properties.setUsername(env.getProperty("spring.second-datasource.username"));
      properties.setPassword(env.getProperty("spring.second-datasource.password"));
        return properties.initializeDataSourceBuilder().type(HikariDataSource.class)
        .build();
    }

    @Bean
    public PlatformTransactionManager vamsTransactionManager() {
 
        JpaTransactionManager transactionManager
          = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
            vamsEntityManager().getObject());
        return transactionManager;
    }
}
