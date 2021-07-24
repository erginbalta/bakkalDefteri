package com.bakkaldefteri.bakkalDefteri.api;

import com.bakkaldefteri.bakkalDefteri.dtos.CategoriesDto;
import com.bakkaldefteri.bakkalDefteri.servicesImpl.CategoriesServiceImpl;
import com.bakkaldefteri.bakkalDefteri.util.ApiPath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiPath.CategoriesCTRL.CTRL)
@Slf4j
public class CategoriesApi {
    private final CategoriesServiceImpl categoriesServiceImpl;

    @Autowired
    public CategoriesApi(CategoriesServiceImpl categoriesServiceImpl){
        this.categoriesServiceImpl = categoriesServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<CategoriesDto>> getAllCategories(){
        log.info("Getting All Categories");
        log.debug("Getting All Categories");
        return ResponseEntity.ok(categoriesServiceImpl.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoriesDto> getById(@PathVariable(value = "id",required = true) Long id){
        log.info("Getting One Category By Id");
        log.debug("Getting One Category By Id -> " +id);
        CategoriesDto categoriesDto = categoriesServiceImpl.getCategoryById(id);
        return ResponseEntity.ok(categoriesDto);
    }

    @PostMapping
    public ResponseEntity<CategoriesDto> createCategory(@Valid @RequestBody CategoriesDto categoriesDto){
        log.info("New Category Created");
        log.debug("New Category Created --- ID -> " +categoriesDto.getId());
        return ResponseEntity.ok(categoriesServiceImpl.save(categoriesDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<CategoriesDto> updateCategory(@PathVariable(value = "id",required = true) Long id, @Valid @RequestBody CategoriesDto categoriesDto){
        log.info("Category Updated...");
        log.debug("Category Updated --- ID -> " +id);
        return ResponseEntity.ok(categoriesServiceImpl.update(id,categoriesDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable(value = "id",required = true) Long id){
        log.info("Category Deleted...");
        log.debug("Category Deleted ... ID -> " +id);
        return ResponseEntity.ok(categoriesServiceImpl.delete(id));
    }
}
