package com.iridiumhawk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("prod")
@PropertySource(value = {"classpath:mysql.properties"})
public class MysqlDbProfile extends AbstractDataSource {

}
