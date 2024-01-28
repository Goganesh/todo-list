package com.goganesh.todolist.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String type, String id) {
        super(String.format("Object type %s with id %s not found", type, id));
    }
}
