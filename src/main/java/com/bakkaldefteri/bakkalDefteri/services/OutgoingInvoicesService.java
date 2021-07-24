package com.bakkaldefteri.bakkalDefteri.services;

import com.bakkaldefteri.bakkalDefteri.dtos.OutgoingInvoicesDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OutgoingInvoicesService {
    OutgoingInvoicesDto save(OutgoingInvoicesDto outgoingInvoicesDto);
    OutgoingInvoicesDto getById(Long id);
    //TPage<OutgoingInvoicesDto> getAll(Pageable pageable);
    List<OutgoingInvoicesDto> getAll();
    Boolean delete(Long id);
    OutgoingInvoicesDto update(Long id, OutgoingInvoicesDto outgoingInvoicesDto);
}
