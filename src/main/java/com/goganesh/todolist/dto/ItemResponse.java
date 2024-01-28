package com.goganesh.todolist.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ItemResponse {

    private UUID id;

    private String title;

    private String description;
}
