package com.example.testbackend.testbackend.infraestructure.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.testbackend.testbackend.application.services.interfaces.IGroupService;
import com.example.testbackend.testbackend.domain.model.Group;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/groups")
public class GroupController {

    private final IGroupService groupService;

    public GroupController(IGroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Group>> getGroups(){
        return new ResponseEntity<>(this.groupService.getGroups(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Group> saveGroup(@RequestBody Group group){
        return new ResponseEntity<>(this.groupService.saveGroup(group), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Group> getGroup(@PathVariable Integer id){
        return new ResponseEntity<>(this.groupService.getGroupById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable Integer id){
        this.groupService.deleteGroup(id);
    }

}
