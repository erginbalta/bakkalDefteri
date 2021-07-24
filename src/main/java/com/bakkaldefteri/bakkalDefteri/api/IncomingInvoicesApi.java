package com.bakkaldefteri.bakkalDefteri.api;

import com.bakkaldefteri.bakkalDefteri.dtos.IncomingInvoicesDto;
import com.bakkaldefteri.bakkalDefteri.servicesImpl.IncomingInvoiceServiceImpl;
import com.bakkaldefteri.bakkalDefteri.util.ApiPath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiPath.IncomingInvoiceCTRL.CTRL)
@Slf4j
public class IncomingInvoicesApi {
    private final IncomingInvoiceServiceImpl incomingInvoiceServiceImpl;

    @Autowired
    public IncomingInvoicesApi(IncomingInvoiceServiceImpl incomingInvoiceServiceImpl){
        this.incomingInvoiceServiceImpl = incomingInvoiceServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<IncomingInvoicesDto>> getAllIncomingInvoices(){
        log.info("Getting All Incoming Invoices");
        log.debug("Getting All Incoming Invoices ...");
        return ResponseEntity.ok(incomingInvoiceServiceImpl.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<IncomingInvoicesDto> getOneIncomingInvoice(@PathVariable(value = "id",required = true)  Long id){
        IncomingInvoicesDto incomingInvoicesDto = incomingInvoiceServiceImpl.getById(id);
        log.info("Getting One Incoming Invoice By Id ...");
        log.debug("Getting One Incoming Invoice By Id ... -> ID -> " +id);
        return ResponseEntity.ok(incomingInvoicesDto);
    }

    @PostMapping
    public ResponseEntity<IncomingInvoicesDto> addIncomingInvoice(@Valid @RequestBody IncomingInvoicesDto incomingInvoicesDto){
        log.info("New Incoming Invoice Added ...");
        log.debug("New Incoming Invoice Added ... ID -> " +incomingInvoicesDto.getId());
        return ResponseEntity.ok(incomingInvoiceServiceImpl.save(incomingInvoicesDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<IncomingInvoicesDto> updateIncomingInvoice(@PathVariable(value = "id",required = true) Long id, @Valid @RequestBody IncomingInvoicesDto incomingInvoicesDto){
        log.info("Incoming Invoice Updated ...");
        log.debug("Incoming Invoice Updated ... ID -> " +incomingInvoicesDto.getId());
        return ResponseEntity.ok(incomingInvoiceServiceImpl.update(id,incomingInvoicesDto));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteIncomingInvoice(@PathVariable(value = "id",required = true) Long id){
        log.info("Incoming Invoice Deleted ...");
        log.debug("Incoming Invoice Deleted ... ID -> " +id);
        return ResponseEntity.ok(incomingInvoiceServiceImpl.delete(id));
    }

}
