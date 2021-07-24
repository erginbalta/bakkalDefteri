package com.bakkaldefteri.bakkalDefteri.servicesImpl;
import com.bakkaldefteri.bakkalDefteri.domain.IncomingInvoices;
import com.bakkaldefteri.bakkalDefteri.dtos.IncomingInvoicesDto;
import com.bakkaldefteri.bakkalDefteri.repositories.IncomingInvoicesRepository;
import com.bakkaldefteri.bakkalDefteri.services.IncomingInvoicesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class IncomingInvoiceServiceImpl implements IncomingInvoicesService {

    private final IncomingInvoicesRepository incomingInvoicesRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public IncomingInvoiceServiceImpl(IncomingInvoicesRepository incomingInvoicesRepository, ModelMapper modelMapper){
        this.incomingInvoicesRepository = incomingInvoicesRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IncomingInvoicesDto save(IncomingInvoicesDto incomingInvoicesDto) {
        IncomingInvoices incomingInvoices = modelMapper.map(incomingInvoicesDto, IncomingInvoices.class);
        incomingInvoices = incomingInvoicesRepository.save(incomingInvoices);

        return modelMapper.map(incomingInvoices, IncomingInvoicesDto.class);
    }

    @Override
    public IncomingInvoicesDto getById(Long id) {
        IncomingInvoices incomingInvoices = incomingInvoicesRepository.getById(id);

        return modelMapper.map(incomingInvoices,IncomingInvoicesDto.class);
    }

    @Override
    public List<IncomingInvoicesDto> getAll() {
        List<IncomingInvoices> incomingInvoicesList = incomingInvoicesRepository.findAll();
        List<IncomingInvoicesDto> incomingInvoicesDtoList = Arrays.asList(modelMapper.map(incomingInvoicesList, IncomingInvoicesDto[].class));
        return incomingInvoicesDtoList;
    }

    @Override
    public Boolean delete(Long id) {
        IncomingInvoices incomingInvoices = incomingInvoicesRepository.getById(id);
        if(incomingInvoices == null){
            throw new IllegalArgumentException("Product Card Des Not Exist");
        }
        incomingInvoicesRepository.delete(incomingInvoices);
        return incomingInvoicesRepository.getById(incomingInvoices.getId()) == null;
    }

    @Override
    public IncomingInvoicesDto update(Long id, IncomingInvoicesDto incomingInvoicesDto) {
        IncomingInvoices incomingInvoice = incomingInvoicesRepository.getById(id);
        if(incomingInvoice == null){
            throw new IllegalArgumentException("Incoming Invoice Does Not Exist -> ID : " +id);
        }
        incomingInvoice.setInvoiceNo(incomingInvoicesDto.getInvoiceNo());
        incomingInvoice.setInvoiceType(incomingInvoicesDto.getInvoiceType());
        incomingInvoice.setScenario(incomingInvoicesDto.getScenario());
        incomingInvoice.setSupplier(incomingInvoicesDto.getSupplier());
        incomingInvoice.setInvoiceDate(incomingInvoicesDto.getInvoiceDate());
        incomingInvoice.setOrderDate(incomingInvoicesDto.getOrderDate());
        incomingInvoice.setOrderNo(incomingInvoicesDto.getOrderNo());
        incomingInvoice.setCreatedTime(incomingInvoicesDto.getCreatedTime());
        incomingInvoice.setTotalAmountOfService(incomingInvoicesDto.getTotalAmountOfService());
        incomingInvoice.setKDvBase(incomingInvoicesDto.getKDvBase());
        incomingInvoice.setExcludesTax(incomingInvoicesDto.getExcludesTax());
        incomingInvoice.setRealKdvAmount(incomingInvoicesDto.getRealKdvAmount());
        incomingInvoice.setTotalAmountWithKdv(incomingInvoicesDto.getTotalAmountWithKdv());

        incomingInvoicesRepository.save(incomingInvoice);

        return modelMapper.map(incomingInvoice, IncomingInvoicesDto.class);
    }
}
