package ru.magazus.data.loaders;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@PropertySource(value = {"classpath:app.properties"})
@EnableJpaRepositories(basePackages = "ru.magazus.data.loaders.repositories")
public class PersistenceConfig {

    @Value("${hibernate.hbm2ddl.auto}")
    private String hibernate_hbm2ddl_auto;

    @Value("${hibernate.dialect}")
    private String hibernate_dialect;

    @Value("${hibernate.show_sql}")
    private String hibernate_show_sql;

    @Value("${jdbc.driverClassName}")
    private String jdbc_driverClassName;

    @Value("${jdbc.url}")
    private String jdbc_url;

    @Value("${jdbc.username}")
    private String jdbc_username;

    @Value("${jdbc.password}")
    private String jdbc_password;

    @Value("${init-db}")
    private String initDatabase;

    @Bean
    public PlatformTransactionManager transactionManager() {
        EntityManagerFactory factory = entityManagerFactory().getObject();
        return new JpaTransactionManager(factory);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(Boolean.TRUE);
        vendorAdapter.setShowSql(Boolean.TRUE);

        factory.setDataSource(dataSource());
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("ru.magazus.data.loaders.repositories.entities");

        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.hbm2ddl.auto", hibernate_hbm2ddl_auto);
        jpaProperties.put("hibernate.dialect", hibernate_dialect);
        jpaProperties.put("hibernate.show_sql", hibernate_show_sql);
        factory.setJpaProperties(jpaProperties);

        factory.afterPropertiesSet();
        factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        return factory;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(jdbc_driverClassName);
        dataSource.setUrl(jdbc_url);
        dataSource.setUsername(jdbc_username);
        dataSource.setPassword(jdbc_password);
        return dataSource;
    }
}
