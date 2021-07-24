package com.bakkaldefteri.bakkalDefteri.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuppliersDto {
    private Long id;

    @NotNull
    private String supplierName;

    @NotNull
    private String address;

    @NotNull
    private String phone;

    @NotNull
    private String email;

    @NotNull
    private String taxAdministration;

    @NotNull
    private String taxNumber;
}

