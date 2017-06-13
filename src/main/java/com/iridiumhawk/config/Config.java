package com.iridiumhawk.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
@ComponentScan( {"com.iridiumhawk.dao", "com.iridiumhawk.service" })
public class Config {
    private static final Logger log = Logger.getLogger("Config.class");
}
