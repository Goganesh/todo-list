package com.goganesh.todolist.service;

import com.goganesh.todolist.dto.ItemRequest;
import com.goganesh.todolist.dto.ItemResponse;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface ItemRestService {

    ItemResponse getById(UUID id);

    Page<ItemResponse> getPage(int pageNumber, int pageSize);

    ItemResponse post(ItemRequest itemDto);

    ItemResponse delete(UUID id);

    ItemResponse put(UUID id, ItemRequest itemDto);
}
