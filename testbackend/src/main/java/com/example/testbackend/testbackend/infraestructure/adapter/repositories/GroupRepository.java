package com.example.testbackend.testbackend.infraestructure.adapter.repositories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.testbackend.testbackend.domain.model.Group;
import com.example.testbackend.testbackend.domain.port.IGroupRepository;
import com.example.testbackend.testbackend.infraestructure.adapter.dao.IGroupCrudRepository;
import com.example.testbackend.testbackend.infraestructure.entity.GroupEntity;
import com.example.testbackend.testbackend.infraestructure.exceptions.ResourceNotFoundException;
import com.example.testbackend.testbackend.infraestructure.rest.mapper.GroupMapper;


@Repository
public class GroupRepository implements IGroupRepository {
    
    private final IGroupCrudRepository groupCrudRepository;
    
    @Autowired
    private GroupMapper groupMapper;

    public GroupRepository(IGroupCrudRepository groupCrudRepository) {
        this.groupCrudRepository = groupCrudRepository;
    }

    @Override
    public Iterable<Group> getGroups() {
        return this.groupMapper.toGroups(this.groupCrudRepository.findAll());
    }

    @Override
    public Optional<Group> getGroup(Integer id) {
        GroupEntity group = this.groupCrudRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Recurso no encontrado")
        );
        return Optional.of(this.groupMapper.toGroup(group));
    }

    @Override
    public Group saveGroup(Group group) {
        GroupEntity groupEntity = this.groupMapper.toGroupEntity(group);
        return this.groupMapper.toGroup(this.groupCrudRepository.save(groupEntity));
    }

    @Override
    public void deleteGroupById(Integer id) {
        GroupEntity groupEntity = this.groupCrudRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Recurso no encontrado")
        );
        this.groupCrudRepository.deleteById(groupEntity.getId());
        
    }

    

}