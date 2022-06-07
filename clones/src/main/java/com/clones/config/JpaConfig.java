package com.clones.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;


@Configuration
public class JpaConfig {

    @Value("${db.host}")
    private String dbhost;

    @Value("${prop.username}")
    private String username;

    @Value("${prop.password}")
    private String password;

    @Value("${c3p0.max_size}")
    private String c3p0Max_size;

    @Value("${c3p0.min_size}")
    private String c3p0Min_size;

    @Value("${c3p0.max_statements}")
    private String c3p0Max_statements;

    @Value("${c3p0.timeout}")
    private String c3p0Timeout;

    @Value("${c3p0.acquire_increment}")
    private String c3p0Acquire_increment;

    @Value("${c3p0.idle_test_period}")
    private String c3p0Idle_test_period;


    @Bean
    public EntityManagerFactory entityManagerFactory() {
        Map<String, String> prop = new HashMap<>();
        prop.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        prop.put("hibernate.connection.url", "jdbc:postgresql://"+dbhost+":5432/clones");
        prop.put("hibernate.connection.username", username);
        prop.put("hibernate.connection.password", password);
        prop.put("hibernate.show_sql", "false");
        prop.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        prop.put("hibernate.temp.use_jdbc_metadata_defaults", "false");
        prop.put("hibernate.hbm2ddl.auto", "validate");
        prop.put("hibernate.c3p0.max_size", c3p0Max_size);
        prop.put("hibernate.c3p0.min_size", c3p0Min_size);
        prop.put("hibernate.c3p0.max_statements", c3p0Max_statements);
        prop.put("hibernate.c3p0.timeout", c3p0Timeout);
        prop.put("hibernate.c3p0.acquire_increment", c3p0Acquire_increment);
        prop.put("hibernate.c3p0.idle_test_period", c3p0Idle_test_period);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-main", prop);

        return emf;
    }


    @Bean(destroyMethod = "close")
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public EntityManager requestScopedEntityManager(EntityManagerFactory emf) {
        return emf.createEntityManager();
    }
}
