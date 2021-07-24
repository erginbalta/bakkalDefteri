package com.bakkaldefteri.bakkalDefteri.api;

import com.bakkaldefteri.bakkalDefteri.dtos.StockCardDto;
import com.bakkaldefteri.bakkalDefteri.servicesImpl.StockCardServiceImpl;
import com.bakkaldefteri.bakkalDefteri.util.ApiPath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiPath.StockCardCTRL.CTRL)
@Slf4j
public class StockCardApi {
    private final StockCardServiceImpl stockCardServiceImpl;

    @Autowired
    public StockCardApi(StockCardServiceImpl stockCardServiceImpl){
        this.stockCardServiceImpl = stockCardServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<StockCardDto>> getAllStocks(){
        log.info("Getting All Stock Cards ...");
        log.debug("Getting All Stock Cards ...");
        return ResponseEntity.ok(stockCardServiceImpl.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<StockCardDto> getById(@PathVariable(value = "id",required = true) Long id){
        log.info("Getting One Stock Card By Id ...");
        log.debug("Getting One Stock Card By Id ... ID -> " +id);
        StockCardDto stockCardDto = stockCardServiceImpl.getById(id);
        return ResponseEntity.ok(stockCardDto);
    }

    @PostMapping
    public ResponseEntity<StockCardDto> addStock(@Valid @RequestBody StockCardDto stockCardDto){
        log.info("New Stock Card Added ...");
        log.debug("New Stock Card Added ... ID -> " +stockCardDto.getId());
        return ResponseEntity.ok(stockCardServiceImpl.save(stockCardDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<StockCardDto> updateStock(@PathVariable(value = "id",required = true) Long id, @Valid @RequestBody StockCardDto stockCardDto){
        log.info("Stock Card Updated ...");
        log.debug("Stock Card Updated ... ID -> " +stockCardDto.getId());
        return ResponseEntity.ok(stockCardServiceImpl.update(id,stockCardDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteStock(@PathVariable(value = "id",required = true) Long id){
        log.info("Stock Card Deleted ...");
        log.debug("Stock Card Deleted ... ID -> " +id);
        return ResponseEntity.ok(stockCardServiceImpl.delete(id));
    }
}
