package com.bakkaldefteri.bakkalDefteri.domain;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "categories")
@Data
@EqualsAndHashCode(callSuper = false)
public class Categories extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categoryId")
    private long id;

    @Column(name = "categoryName", length = 400)
    private String categoryName;
}

