package com.bakkaldefteri.bakkalDefteri.api;

import com.bakkaldefteri.bakkalDefteri.dtos.OutgoingInvoicesDto;
import com.bakkaldefteri.bakkalDefteri.servicesImpl.OutgoingInvoicesServiceImpl;
import com.bakkaldefteri.bakkalDefteri.util.ApiPath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiPath.OutgoingInvoiceCTRL.CTRL)
@Slf4j
public class OutgoingInvoicesApi {
    private final OutgoingInvoicesServiceImpl outgoingInvoicesServiceImpl;

    @Autowired
    public OutgoingInvoicesApi(OutgoingInvoicesServiceImpl outgoingInvoicesServiceImpl) {
        this.outgoingInvoicesServiceImpl = outgoingInvoicesServiceImpl;
    }
    @GetMapping
    public ResponseEntity<List<OutgoingInvoicesDto>> getAllOutgoingInvoices(){
        log.info("Getting All Outgoing Invoices");
        log.debug("Getting All Outgoing Invoices ...");
        return ResponseEntity.ok(outgoingInvoicesServiceImpl.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<OutgoingInvoicesDto> getOneOutgoingInvoice(@PathVariable(value = "id",required = true) Long id){
        log.info("Getting One Outgoing Invoice By Id ...");
        log.debug("Getting One Outgoing Invoice By Id ... -> ID -> " +id);
        return ResponseEntity.ok(outgoingInvoicesServiceImpl.getById(id));
    }

    @PostMapping
    public ResponseEntity<OutgoingInvoicesDto> addOutgoingInvoice(@Valid @RequestBody OutgoingInvoicesDto outgoingInvoicesDto){
        log.info("New Outgoing Invoice Added ...");
        log.debug("New Outgoing Invoice Added ... ID -> " +outgoingInvoicesDto.getId());
        return ResponseEntity.ok(outgoingInvoicesServiceImpl.save(outgoingInvoicesDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<OutgoingInvoicesDto> updateOutgoingInvoice(@PathVariable(value = "id",required = true) Long id, @Valid @RequestBody OutgoingInvoicesDto outgoingInvoicesDto){
        log.info("Outgoing Invoice Updated ...");
        log.debug("Outgoing Invoice Updated ... ID -> " +outgoingInvoicesDto.getId());
        return ResponseEntity.ok(outgoingInvoicesServiceImpl.update(id,outgoingInvoicesDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteOutgoingInvoice(@PathVariable(value = "id",required = true) Long id){
        log.info("Outgoing Invoice Deleted ...");
        log.debug("Outgoing Invoice Deleted ... ID -> " +id);
        return ResponseEntity.ok(outgoingInvoicesServiceImpl.delete(id));
    }
}
