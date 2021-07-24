package com.bakkaldefteri.bakkalDefteri.services;

import com.bakkaldefteri.bakkalDefteri.dtos.StockCardDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StockCardService {
    StockCardDto save(StockCardDto stockCardDto);
    StockCardDto getById(Long id);
    List<StockCardDto> getAll();
    Boolean delete(Long id);
    StockCardDto update(Long id, StockCardDto stockCardDto);
}
