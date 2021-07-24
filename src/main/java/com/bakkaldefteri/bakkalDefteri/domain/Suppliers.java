package com.bakkaldefteri.bakkalDefteri.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "suppliers")
@Data
@EqualsAndHashCode(callSuper = false)
public class Suppliers extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "suppliersId")
    private Long id;

    @Column(name = "supplierName", length = 400)
    private String supplierName;

    @Column(name = "address", length = 400)
    private String address;

    @Column(name = "phone", length = 400)
    private String phone;

    @Column(name = "email", length = 400)
    private String email;

    @Column(name="textAdministration", length = 400)
    private String taxAdministration;

    @Column(name="taxNumber", length = 20)
    private String taxNumber;
}

