package com.example.testbackend.testbackend.application.services.interfaces;

import com.example.testbackend.testbackend.domain.model.Group;

public interface IGroupService {
    Iterable<Group> getGroups();
    Group getGroupById (Integer id);
    Group saveGroup (Group group);
    void deleteGroup(Integer id);
}
