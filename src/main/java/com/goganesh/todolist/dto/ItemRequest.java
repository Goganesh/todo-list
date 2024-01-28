package com.goganesh.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class ItemRequest {

    @NotBlank
    private String title;

    private String description;
}
