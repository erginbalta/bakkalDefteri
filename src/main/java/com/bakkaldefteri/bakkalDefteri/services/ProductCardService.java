package com.bakkaldefteri.bakkalDefteri.services;

import com.bakkaldefteri.bakkalDefteri.dtos.ProductCardDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductCardService {
    ProductCardDto save(ProductCardDto productCardDto);
    ProductCardDto getById(Long id);
    List<ProductCardDto> getAll();
    Boolean delete(Long id);
    ProductCardDto update(Long id, ProductCardDto productCardDto);
}
