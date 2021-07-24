package com.bakkaldefteri.bakkalDefteri.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomersDto {
    private long id;

    private String customerName;

    private String address;

    private String phone;

    private String email;

    private String taxAdministration;

    private String taxNumber;
}

