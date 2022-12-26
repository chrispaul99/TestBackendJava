package com.example.testbackend.testbackend.infraestructure.exceptions;


import java.util.ArrayList;
import java.util.List;

public class Response {
    private List<Error> errors = new ArrayList<>();

    public void addError(Error error) {
        this.errors.add(error);
    }

    ;
}
