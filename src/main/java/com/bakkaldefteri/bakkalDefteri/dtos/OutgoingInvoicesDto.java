package com.bakkaldefteri.bakkalDefteri.dtos;

import com.bakkaldefteri.bakkalDefteri.domain.Customers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutgoingInvoicesDto {
    private long id;

    private String invoiceNo;

    private String invoiceType;

    private String scenario;

    private Customers customer;

    private Date invoiceDate;

    private Date orderDate;

    private long orderNo;

    private Date createdTime;

    private double totalAmountOfService;

    private double KDvBase;

    private double excludesTax;

    private double realKdvAmount;

    private double totalAmountWithKdv;
}

