package com.example.testbackend.testbackend.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.testbackend.testbackend.application.services.implementations.DomainGroupService;
import com.example.testbackend.testbackend.application.services.interfaces.IGroupService;
import com.example.testbackend.testbackend.domain.port.IGroupRepository;

@Configuration
public class BeanGroupConfiguration {
    
    @Bean
    IGroupService groupBeanService(final IGroupRepository groupRepository){
        return new DomainGroupService(groupRepository);
    }
}
