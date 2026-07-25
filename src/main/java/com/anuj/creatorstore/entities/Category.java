package com.anuj.creatorstore.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @NotNull(message = "Category id cannot be null.")
    @Column(unique = true)
    private String categoryId;

    @ManyToOne
    private Category parentCategory;

    @NotNull
    private Integer level;

}
