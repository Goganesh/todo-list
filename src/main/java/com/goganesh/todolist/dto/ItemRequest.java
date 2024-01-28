package com.goganesh.todolist.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ItemRequest {

    @NotBlank
    private String title;

    private String description;
}
