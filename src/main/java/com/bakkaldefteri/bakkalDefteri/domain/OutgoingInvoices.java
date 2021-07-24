package com.bakkaldefteri.bakkalDefteri.domain;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "outgoingInvoices")
@Data
@EqualsAndHashCode(callSuper = false)
public class OutgoingInvoices extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "outgoingInvoicesId")
    private long id;

    @Column(name = "invoiceNo", length = 400)
    private String invoiceNo;

    @Column(name = "invoiceType", length = 400)
    private String invoiceType;

    @Column(name = "scenario", length = 400)
    private String scenario;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="customerId")
    private Customers customer;

    @Column(name = "invoiceDate", length = 400)
    private Date invoiceDate;

    @Column(name = "orderDate", length = 400)
    private Date orderDate;

    @Column(name = "orderNo", length = 400)
    private long orderNo;

    @Column(name = "createdTime", length = 400)
    private Date createdTime;

    @Column(name = "totalAmountOfService", length = 400)
    private double totalAmountOfService;

    @Column(name = "KDvBase", length = 400)
    private double KDvBase;

    @Column(name = "excludesTax", length = 400)
    private double excludesTax;

    @Column(name = "realKdvAmount", length = 400)
    private double realKdvAmount;

    @Column(name = "totalAmountWithKdv", length = 400)
    private double totalAmountWithKdv;
}

