package com.iridiumhawk.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
@Profile("dev")
@PropertySource(value = {"classpath:hsql.properties"})
public class HsqlDbProfile extends AbstractDataSource {
  @Bean
  @Autowired
  public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
    ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
    resourceDatabasePopulator.setContinueOnError(true);
    resourceDatabasePopulator.setSqlScriptEncoding("UTF-8");

//    resourceDatabasePopulator.addScript(new ClassPathResource("/schema-hsql.sql"));
    resourceDatabasePopulator.addScript(new ClassPathResource("/populateHsql.sql"));


    DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
    dataSourceInitializer.setDataSource(dataSource);
    dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);

    System.out.println("Database Populated");
    return dataSourceInitializer;
  }
}
