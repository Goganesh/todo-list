package com.goganesh.todolist.mapper;

import com.goganesh.todolist.dto.ItemRequest;
import com.goganesh.todolist.dto.ItemResponse;
import com.goganesh.todolist.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class ItemMapperTest {

    ItemMapper itemMapper = new ItemMapperImpl();

    @Test
    void toDto() {
        Item item = new Item(UUID.randomUUID(), "Title", "Description");
        ItemResponse actual = itemMapper.toDto(item);

        assertEquals(item.getId(), actual.getId());
        assertEquals(item.getTitle(), actual.getTitle());
        assertEquals(item.getDescription(), actual.getDescription());
    }

    @Test
    void toEntity() {
        ItemRequest dto = new ItemRequest("Title", "Description");
        Item actual = itemMapper.toEntity(dto);
        
        assertEquals(dto.getTitle(), actual.getTitle());
        assertEquals(dto.getDescription(), actual.getDescription());
    }
}