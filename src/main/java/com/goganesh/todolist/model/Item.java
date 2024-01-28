package com.goganesh.todolist.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    private UUID id;
    @Column
    private String title;
    @Column
    private String description;
}
