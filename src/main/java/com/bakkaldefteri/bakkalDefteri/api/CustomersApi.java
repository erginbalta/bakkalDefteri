package com.bakkaldefteri.bakkalDefteri.api;

import com.bakkaldefteri.bakkalDefteri.dtos.CustomersDto;
import com.bakkaldefteri.bakkalDefteri.servicesImpl.CustomersServiceImpl;
import com.bakkaldefteri.bakkalDefteri.util.ApiPath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiPath.CustomersCTRL.CTRL)
@Slf4j
public class CustomersApi {
    private final CustomersServiceImpl customersServiceImpl;
    @Autowired
    public CustomersApi(CustomersServiceImpl customersServiceImpl){
        this.customersServiceImpl = customersServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<CustomersDto>> getAllCustomers(){
        log.info("Getting All Customers...");
        log.debug("Getting All Customers...");
        return ResponseEntity.ok(customersServiceImpl.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomersDto> getById(@PathVariable(value = "id",required = true) Long id){
        CustomersDto customersDto = customersServiceImpl.getById(id);
        log.info("Getting One Customer By Id ...");
        log.debug("Getting One Customer By Id ... ID -> " +id);
        return ResponseEntity.ok(customersDto);
    }

    @PostMapping
    public ResponseEntity<CustomersDto> createCustomer(@Valid @RequestBody CustomersDto customersDto){
        log.info("New Customer Created ...");
        log.debug("New Customer Created ... ID -> " +customersDto.getId());
        return ResponseEntity.ok(customersServiceImpl.save(customersDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<CustomersDto> updateCustomer(@PathVariable(value = "id",required = true) Long id, @Valid @RequestBody CustomersDto customersDto){
        log.info("Customer Updated ...");
        log.debug("Customer Updated ... ID -> " +id);
        return ResponseEntity.ok(customersServiceImpl.update(id,customersDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable(value = "id",required = true) Long id){
        log.info("Customer Deleted ...");
        log.debug("Customer Deleted ... ID -> " +id);
        return ResponseEntity.ok(customersServiceImpl.delete(id));
    }
}