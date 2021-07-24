package com.bakkaldefteri.bakkalDefteri.services;

import com.bakkaldefteri.bakkalDefteri.dtos.CustomersDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomersService {
    CustomersDto save(CustomersDto customersDto);
    CustomersDto getById(Long id);
    List<CustomersDto> getAll();
    Boolean delete(Long id);
    CustomersDto update(Long id,CustomersDto customersDto);
}
