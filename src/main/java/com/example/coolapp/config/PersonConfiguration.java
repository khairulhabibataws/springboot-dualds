package com.example.coolapp.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.coolapp.repository")
public class PersonConfiguration {

    @Bean
    public DataSource routingDataSource(){
        return new RoutingDS(
          primaryDS(),replicaDS()
        );
    }

    private DataSource primaryDS(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        config.setUsername("postgres");
        config.setPassword("postgres");
        config.setReadOnly(false);
        return new HikariDataSource(config);
    }

    private DataSource replicaDS(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/myrep");
        config.setUsername("postgres");
        config.setPassword("postgres");
        config.setReadOnly(true);
        config.setAutoCommit(true);
        return new HikariDataSource(config);
    }
}
