package com.example.testbackend.testbackend.infraestructure.rest.mapper;


import com.example.testbackend.testbackend.domain.model.Group;
import com.example.testbackend.testbackend.infraestructure.entity.GroupEntity;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "name", target = "name"),
    }
)
Group toGroup(GroupEntity group);
Iterable<Group> toGroups(Iterable<GroupEntity> groupEntity);

@InheritInverseConfiguration
GroupEntity toGroupEntity (Group group);

}
