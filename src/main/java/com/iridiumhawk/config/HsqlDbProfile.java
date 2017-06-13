package com.iridiumhawk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("dev")
@PropertySource(value = {"classpath:hsql.properties"})
public class HsqlDbProfile extends AbstractDataSource {
}
