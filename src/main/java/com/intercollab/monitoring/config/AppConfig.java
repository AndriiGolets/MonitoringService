package com.intercollab.monitoring.config;

import org.postgresql.ds.PGPoolingDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


import javax.sql.DataSource;

/**
 * Created by andrii on 12/19/17.
 */

@Configuration
@PropertySource(value = {"classpath:db.properties"})
public class AppConfig {

    private final Environment environment;

    @Autowired
    public AppConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource dataSource() {
        PGPoolingDataSource dataSource = new PGPoolingDataSource();
        dataSource.setDataSourceName(environment.getRequiredProperty("jdbc.dataSourceMain"));
        dataSource.setServerName(environment.getRequiredProperty("jdbc.ServerName"));
        dataSource.setDatabaseName(environment.getRequiredProperty("jdbc.dataBaseName"));
        dataSource.setUser(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        dataSource.setMaxConnections(Integer.parseInt(environment.getRequiredProperty("jdbc.MaxConnections")));

        return dataSource;
    }
}
