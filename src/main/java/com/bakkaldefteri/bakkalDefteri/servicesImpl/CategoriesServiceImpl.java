package com.bakkaldefteri.bakkalDefteri.servicesImpl;

import com.bakkaldefteri.bakkalDefteri.domain.Categories;
import com.bakkaldefteri.bakkalDefteri.dtos.CategoriesDto;
import com.bakkaldefteri.bakkalDefteri.repositories.CategoriesRepository;
import com.bakkaldefteri.bakkalDefteri.services.CategoriesService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {
    @Autowired
    private final CategoriesRepository categoriesRepository;

    private final ModelMapper modelMapper;


    public CategoriesServiceImpl(CategoriesRepository categoriesRepository,ModelMapper modelMapper){
        this.categoriesRepository = categoriesRepository;
        this. modelMapper = modelMapper;
    }

    @Override
    public CategoriesDto save(CategoriesDto categoriesDto) {
        Categories categories = modelMapper.map(categoriesDto,Categories.class);
        categories = categoriesRepository.save(categories);

        return modelMapper.map(categories,CategoriesDto.class);
    }

    @Override
    public CategoriesDto getCategoryById(Long id) {
        Categories categories = categoriesRepository.getById(id);

        return modelMapper.map(categories,CategoriesDto.class);
    }

    @Override
    public List<CategoriesDto> getAll() {
        List<Categories> categoriesList = categoriesRepository.findAll();
        List<CategoriesDto> categoriesDtoList = Arrays.asList(modelMapper.map(categoriesList, CategoriesDto[].class));
        return categoriesDtoList;
    }

    @Override
    public Boolean delete(Long id) {
        Categories category = categoriesRepository.getById(id);
        if(category==null){
            throw new IllegalArgumentException("Category Does Not Exist");
        }
        categoriesRepository.delete(category);

        return categoriesRepository.getById(id) == null;
    }

    @Override
    public CategoriesDto update(Long id, CategoriesDto categoriesDto) {
        Categories category = categoriesRepository.getById(id);
        if(category == null){
            throw new IllegalArgumentException("Category Des Not Exist -> ID: " +id);
        }
        String catName = categoriesDto.getCategoryName();
        category.setCategoryName(catName);
        categoriesRepository.save(category);
        return modelMapper.map(category, CategoriesDto.class);
    }


}
