package com.goganesh.todolist.controller;

import com.goganesh.todolist.dto.ItemRequest;
import com.goganesh.todolist.dto.ItemResponse;
import com.goganesh.todolist.service.ItemRestService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/v1/items")
@AllArgsConstructor
public class ItemController {

    private final ItemRestService itemRestService;

    @GetMapping("/{id}")
    public ItemResponse getItemById(@PathVariable UUID id) {
        return itemRestService.getById(id);
    }

    @GetMapping
    public Page<ItemResponse> getPage(@RequestParam(defaultValue = "0") int pageNumber,
                                      @RequestParam(defaultValue = "20") int pageSize) {
        return itemRestService.getPage(pageNumber, pageSize);
    }

    @PostMapping
    public ItemResponse post(@Valid @RequestBody ItemRequest itemDto) {
        return itemRestService.post(itemDto);
    }

    @DeleteMapping("/{id}")
    public ItemResponse delete(@PathVariable UUID id) {
        return itemRestService.delete(id);
    }

    @PutMapping("/{id}")
    public ItemResponse put(@PathVariable UUID id,
                            @Valid @RequestBody ItemRequest itemDto) {
        return itemRestService.put(id, itemDto);
    }
}
