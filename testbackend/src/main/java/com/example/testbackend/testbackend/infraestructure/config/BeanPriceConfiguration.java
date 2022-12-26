package com.example.testbackend.testbackend.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.testbackend.testbackend.application.services.implementations.DomainPriceService;
import com.example.testbackend.testbackend.application.services.interfaces.IPriceService;
import com.example.testbackend.testbackend.domain.port.IPriceRepository;

@Configuration
public class BeanPriceConfiguration {
    
    @Bean
    IPriceService priceBeanService(final IPriceRepository priceRepository){
        return new DomainPriceService(priceRepository);
    }
}
