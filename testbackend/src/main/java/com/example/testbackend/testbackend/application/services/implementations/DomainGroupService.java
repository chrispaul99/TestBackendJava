package com.example.testbackend.testbackend.application.services.implementations;


import com.example.testbackend.testbackend.application.services.interfaces.IGroupService;
import com.example.testbackend.testbackend.domain.model.Group;
import com.example.testbackend.testbackend.domain.port.IGroupRepository;


public class DomainGroupService implements IGroupService{

    private final IGroupRepository groupRepository;

    public DomainGroupService(IGroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Iterable<Group> getGroups() {
        return this.groupRepository.getGroups();
    }

    @Override
    public Group getGroupById(Integer id) {
        return this.groupRepository.getGroup(id).get();
    }

    @Override
    public Group saveGroup(Group group) {
        return this.groupRepository.saveGroup(group);
    }

    @Override
    public void deleteGroup(Integer id) {
        this.groupRepository.deleteGroupById(id);
        
    }
    
}
