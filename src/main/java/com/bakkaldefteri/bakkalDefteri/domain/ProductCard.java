package com.bakkaldefteri.bakkalDefteri.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "productCard")
@Data
@EqualsAndHashCode(callSuper = false)
public class ProductCard extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productCardId")
    private long id;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="categoryId")
    private Categories category;

    @Column(name = "size")
    @Enumerated(EnumType.STRING)
    private Size size;

    @Column(name = "color")
    private String color;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
}

