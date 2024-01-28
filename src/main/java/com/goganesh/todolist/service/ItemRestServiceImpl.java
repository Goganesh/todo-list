package com.goganesh.todolist.service;

import com.goganesh.todolist.dto.ItemRequest;
import com.goganesh.todolist.dto.ItemResponse;
import com.goganesh.todolist.exception.ResourceNotFoundException;
import com.goganesh.todolist.mapper.ItemMapper;
import com.goganesh.todolist.model.Item;
import com.goganesh.todolist.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class ItemRestServiceImpl implements ItemRestService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Override
    public ItemResponse getById(UUID id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Item.class.getSimpleName(), id.toString()));
        return itemMapper.toDto(item);
    }

    @Override
    public Page<ItemResponse> getPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return itemRepository.findAll(pageable)
                .map(itemMapper::toDto);

    }

    @Override
    public ItemResponse post(ItemRequest itemDto) {
        Item item = itemMapper.toEntity(itemDto);
        Item created = itemRepository.save(item);
        return itemMapper.toDto(created);
    }

    @Override
    public ItemResponse delete(UUID id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Item.class.getSimpleName(), id.toString()));
        itemRepository.delete(item);
        return itemMapper.toDto(item);
    }

    @Override
    public ItemResponse put(UUID id, ItemRequest itemDto) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Item.class.getSimpleName(), id.toString()));
        item.setTitle(itemDto.getTitle());
        item.setDescription(itemDto.getDescription());

        Item updated = itemRepository.save(item);

        return itemMapper.toDto(updated);
    }

}
