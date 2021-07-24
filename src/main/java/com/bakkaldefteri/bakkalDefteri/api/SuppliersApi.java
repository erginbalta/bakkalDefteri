package com.bakkaldefteri.bakkalDefteri.api;

import com.bakkaldefteri.bakkalDefteri.dtos.SuppliersDto;
import com.bakkaldefteri.bakkalDefteri.servicesImpl.SuppliersServiceImpl;
import com.bakkaldefteri.bakkalDefteri.util.ApiPath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiPath.SuppliersCTRL.CTRL)
@Slf4j
public class SuppliersApi {
    private final SuppliersServiceImpl suppliersServiceImpl;

    @Autowired
    public SuppliersApi(SuppliersServiceImpl suppliersServiceImpl){
        this.suppliersServiceImpl = suppliersServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<SuppliersDto>> getAllSuppliers(){
        log.info("Getting All Suppliers ... ");
        log.debug("Getting All Suppliers ... ");
        return ResponseEntity.ok(suppliersServiceImpl.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<SuppliersDto> getById(@PathVariable(value = "id",required = true) Long id){
        log.info("Getting One Supplier By Id ... ");
        log.debug("Getting One Supplier By Id ... ID -> " +id);
        SuppliersDto suppliersDto = suppliersServiceImpl.getById(id);
        return ResponseEntity.ok(suppliersDto);
    }

    @PostMapping
    public ResponseEntity<SuppliersDto> createSupplier(@Valid @RequestBody SuppliersDto suppliersDto){
        log.info("New Supplier Added ...");
        log.debug("New Supplier Added ... ID -> " +suppliersDto.getId());
        return ResponseEntity.ok(suppliersServiceImpl.save(suppliersDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<SuppliersDto> updateSuppliers(@PathVariable(value = "id",required = true) Long id, @Valid @RequestBody SuppliersDto suppliersDto){
        log.info("Supplier Updated ...");
        log.debug("Supplier Updated ... ID -> " +suppliersDto.getId());
        return ResponseEntity.ok(suppliersServiceImpl.update(id,suppliersDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteSuppliers(@PathVariable(value = "id",required = true) Long id){
        log.info("Supplier Deleted ...");
        log.debug("Supplier Deleted ... ID -> " +id);
        return ResponseEntity.ok(suppliersServiceImpl.delete(id));
    }
}
