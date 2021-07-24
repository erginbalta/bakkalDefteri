package com.bakkaldefteri.bakkalDefteri.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "stockCard")
@Data
@EqualsAndHashCode(callSuper = false)
public class StockCard extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stockCardId")
    private long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="productCardId")
    private ProductCard product;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="incomingInvoicesId")
    private IncomingInvoices incomingInvoicesNumber;

    @Column(name = "number")
    private double number;

    @Column(name = "unitPrice")
    private double unitPrice;
}

