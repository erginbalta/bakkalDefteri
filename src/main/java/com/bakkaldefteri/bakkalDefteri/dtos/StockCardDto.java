package com.bakkaldefteri.bakkalDefteri.dtos;

import com.bakkaldefteri.bakkalDefteri.domain.IncomingInvoices;
import com.bakkaldefteri.bakkalDefteri.domain.ProductCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockCardDto {
    private long id;

    private ProductCard product;

    private IncomingInvoices incomingInvoicesNumber;

    private double number;

    private double unitPrice;
}
