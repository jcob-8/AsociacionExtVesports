package com.AsociacionExtVesports.AsociacionExtVesports.infrastructure.config;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.AsociacionExtVesports.AsociacionExtVesports.application.repository.SocioRepository;
import com.AsociacionExtVesports.AsociacionExtVesports.domain.Socio;

@Configuration
@EnableMongoRepositories(basePackages = "com.AsociacionExtVesports.AsociacionExtVesports.application.repository")
public class MongoConfig {
    // Configuración adicional
}