package com.goganesh.todolist.mapper;

import com.goganesh.todolist.dto.ItemRequest;
import com.goganesh.todolist.dto.ItemResponse;
import com.goganesh.todolist.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    @Mapping(target = "id", source = "item.id")
    @Mapping(target = "title", source = "item.title")
    @Mapping(target = "description", source = "item.description")
    ItemResponse toDto(Item item);

    @Mapping(target = "title", source = "dto.title")
    @Mapping(target = "description", source = "dto.description")
    Item toEntity(ItemRequest dto);
}
