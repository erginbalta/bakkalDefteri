package com.bakkaldefteri.bakkalDefteri.api;

import com.bakkaldefteri.bakkalDefteri.dtos.ProductCardDto;
import com.bakkaldefteri.bakkalDefteri.servicesImpl.ProductCardServiceImpl;
import com.bakkaldefteri.bakkalDefteri.util.ApiPath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiPath.ProductCardCTRL.CTRL)
@Slf4j
public class ProductCardApi {
    private final ProductCardServiceImpl productCardServiceImpl;

    @Autowired
    public ProductCardApi(ProductCardServiceImpl productCardServiceImpl){
        this.productCardServiceImpl = productCardServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<ProductCardDto>> getAllProductCards(){
        log.info("Getting All Product Cards ...");
        log.debug("Getting All Product Cards ...");
        return ResponseEntity.ok(productCardServiceImpl.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductCardDto> getById(@PathVariable(value = "id",required = true) Long id){
        log.info("Getting One Product Card ...");
        log.debug("Getting One Product Card ... ID -> " +id);
        ProductCardDto productCardDto = productCardServiceImpl.getById(id);
        return ResponseEntity.ok(productCardDto);
    }

    @PostMapping
    public ResponseEntity<ProductCardDto> createProductCard(@Valid @RequestBody ProductCardDto productCardDto){
        log.info("New Product Card Added ...");
        log.debug("New Product Card Added ... ID -> " +productCardDto.getId());
        return ResponseEntity.ok(productCardServiceImpl.save(productCardDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductCardDto> updateProductCard(@PathVariable(value = "id",required = true) Long id, @Valid @RequestBody ProductCardDto productCardDto){
        log.info("Product Card Updated ...");
        log.debug("Product Card Updated ... ID -> " +productCardDto.getId());
        return ResponseEntity.ok(productCardServiceImpl.update(id,productCardDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteProductCard(@PathVariable(value = "id",required = true) Long id){
        log.info("Product Card Deleted ...");
        log.debug("Product Card Deleted ... ID -> " +id);
        return ResponseEntity.ok(productCardServiceImpl.delete(id));
    }

}
