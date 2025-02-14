package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Job job() {
        return new Job();
    }
    @Bean
    public Person person() {
        return new Person();
    }
}
