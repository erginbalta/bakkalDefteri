package com.bakkaldefteri.bakkalDefteri.services;

import com.bakkaldefteri.bakkalDefteri.dtos.CategoriesDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoriesService {
    CategoriesDto save(CategoriesDto categoriesDto);
    CategoriesDto getCategoryById(Long id);
    List<CategoriesDto> getAll();
    Boolean delete(Long id);
    CategoriesDto update(Long id, CategoriesDto categoriesDto);
}
