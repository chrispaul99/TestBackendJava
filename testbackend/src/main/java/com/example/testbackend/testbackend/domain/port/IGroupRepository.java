package com.example.testbackend.testbackend.domain.port;

import java.util.Optional;

import com.example.testbackend.testbackend.domain.model.Group;

public interface IGroupRepository {
    Iterable<Group> getGroups();
    Optional <Group> getGroup (Integer id);
    Group saveGroup (Group group);
    void deleteGroupById(Integer id);
}
