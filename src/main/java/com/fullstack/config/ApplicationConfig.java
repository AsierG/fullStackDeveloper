package com.fullstack.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.fullstack.backend.persistence.repositories")
@EntityScan("com.fullstack.backend.persistence.domain.backend")
@EnableTransactionManagement
public class ApplicationConfig {
}
