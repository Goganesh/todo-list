package com.goganesh.todolist.service;

import com.goganesh.todolist.dto.ItemRequest;
import com.goganesh.todolist.dto.ItemResponse;
import com.goganesh.todolist.mapper.ItemMapper;
import com.goganesh.todolist.mapper.ItemMapperImpl;
import com.goganesh.todolist.model.Item;
import com.goganesh.todolist.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class ItemRestServiceImplTest {

    @Autowired
    private ItemRestService itemRestService;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    void post() {
        ItemRequest request = new ItemRequest("title", "description");

        Mockito.when(itemRepository.save(Mockito.any())).thenReturn(new Item(UUID.randomUUID(), request.getTitle(), request.getDescription()));

        ItemResponse actual = itemRestService.post(request);

        assertNotNull(actual.getId());
        assertEquals(request.getTitle(), actual.getTitle());
        assertEquals(request.getDescription(), actual.getDescription());
    }

    @Test
    void put() {
        ItemRequest request = new ItemRequest("title", "description");
        UUID uuid = UUID.randomUUID();
        Item item = new Item(UUID.randomUUID(), "title1", "description1");

        Mockito.when(itemRepository.findById(uuid)).thenReturn(Optional.ofNullable(item));
        Mockito.when(itemRepository.save(Mockito.any())).thenReturn(new Item(UUID.randomUUID(), request.getTitle(), request.getDescription()));

        ItemResponse actual = itemRestService.put(uuid, request);

        assertNotNull(actual.getId());
        assertEquals(request.getTitle(), actual.getTitle());
        assertEquals(request.getDescription(), actual.getDescription());
    }

    @TestConfiguration
    static class ItemRestServiceImplTestConfiguration {
        @Bean
        public ItemMapper itemMapper() {
            return new ItemMapperImpl();
        }

        @MockBean
        private ItemRepository itemRepository;

        @Bean
        public ItemRestService itemRestService(ItemMapper itemMapper,
                                               ItemRepository itemRepository) {
            return new ItemRestServiceImpl(itemRepository, itemMapper);
        }

    }
}