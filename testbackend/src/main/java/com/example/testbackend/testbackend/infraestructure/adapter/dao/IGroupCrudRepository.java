package com.example.testbackend.testbackend.infraestructure.adapter.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.testbackend.testbackend.infraestructure.entity.GroupEntity;

public interface IGroupCrudRepository extends CrudRepository<GroupEntity, Integer> {
    
}
