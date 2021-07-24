package com.bakkaldefteri.bakkalDefteri.services;

import com.bakkaldefteri.bakkalDefteri.dtos.IncomingInvoicesDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IncomingInvoicesService {
    IncomingInvoicesDto save(IncomingInvoicesDto incomingInvoicesDto);
    IncomingInvoicesDto getById(Long id);
    List<IncomingInvoicesDto> getAll();
    Boolean delete(Long id);
    IncomingInvoicesDto update(Long id, IncomingInvoicesDto incomingInvoicesDto);
}
