package com.bakkaldefteri.bakkalDefteri.services;

import com.bakkaldefteri.bakkalDefteri.dtos.SuppliersDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SuppliersService {
    SuppliersDto save(SuppliersDto suppliersDto);
    SuppliersDto getById(Long id);
    List<SuppliersDto> getAll();
    Boolean delete(Long id);
    SuppliersDto update(Long id, SuppliersDto suppliersDto);
}
