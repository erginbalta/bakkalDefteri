package com.bakkaldefteri.bakkalDefteri.servicesImpl;

import com.bakkaldefteri.bakkalDefteri.domain.OutgoingInvoices;
import com.bakkaldefteri.bakkalDefteri.dtos.OutgoingInvoicesDto;
import com.bakkaldefteri.bakkalDefteri.repositories.OutgoingInvoicesRepository;
import com.bakkaldefteri.bakkalDefteri.services.OutgoingInvoicesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OutgoingInvoicesServiceImpl implements OutgoingInvoicesService {

    private final OutgoingInvoicesRepository outgoingInvoicesRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public OutgoingInvoicesServiceImpl(OutgoingInvoicesRepository outgoingInvoicesRepository, ModelMapper modelMapper){
        this.outgoingInvoicesRepository = outgoingInvoicesRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OutgoingInvoicesDto save(OutgoingInvoicesDto outgoingInvoicesDto) {
        OutgoingInvoices outgoingInvoices = modelMapper.map(outgoingInvoicesDto, OutgoingInvoices.class);
        outgoingInvoices = outgoingInvoicesRepository.save(outgoingInvoices);

        return modelMapper.map(outgoingInvoices, OutgoingInvoicesDto.class);
    }

    @Override
    public OutgoingInvoicesDto getById(Long id) {
        OutgoingInvoices outgoingInvoices = outgoingInvoicesRepository.getById(id);
        return modelMapper.map(outgoingInvoices,OutgoingInvoicesDto.class);
    }

    @Override
    public List<OutgoingInvoicesDto> getAll() {
        List<OutgoingInvoices> outgoingInvoicesList = outgoingInvoicesRepository.findAll();
        return Arrays.asList(modelMapper.map(outgoingInvoicesList,OutgoingInvoicesDto[].class));
    }

    @Override
    public Boolean delete(Long id) {
        OutgoingInvoices outgoingInvoices = outgoingInvoicesRepository.getById(id);
        if(outgoingInvoices == null){
            throw new IllegalArgumentException("OutGoing Invoice Does Not Exist -> ID: " +id);
        }
        outgoingInvoicesRepository.delete(outgoingInvoices);
        return outgoingInvoicesRepository.getById(outgoingInvoices.getId()) == null;
    }

    @Override
    public OutgoingInvoicesDto update(Long id, OutgoingInvoicesDto outgoingInvoicesDto) {
        OutgoingInvoices outgoingInvoices = outgoingInvoicesRepository.getById(id);
        if(outgoingInvoices == null){
            throw new IllegalArgumentException("OutGoing Invoice Does Not Exist -> ID : " +id);
        }
        outgoingInvoices.setInvoiceNo(outgoingInvoicesDto.getInvoiceNo());
        outgoingInvoices.setInvoiceType(outgoingInvoicesDto.getInvoiceType());
        outgoingInvoices.setScenario(outgoingInvoicesDto.getScenario());
        outgoingInvoices.setCustomer(outgoingInvoicesDto.getCustomer());
        outgoingInvoices.setInvoiceDate(outgoingInvoicesDto.getInvoiceDate());
        outgoingInvoices.setOrderDate(outgoingInvoicesDto.getOrderDate());
        outgoingInvoices.setOrderNo(outgoingInvoicesDto.getOrderNo());
        outgoingInvoices.setCreatedTime(outgoingInvoicesDto.getCreatedTime());
        outgoingInvoices.setTotalAmountOfService(outgoingInvoicesDto.getTotalAmountOfService());
        outgoingInvoices.setKDvBase(outgoingInvoicesDto.getKDvBase());
        outgoingInvoices.setExcludesTax(outgoingInvoicesDto.getExcludesTax());
        outgoingInvoices.setRealKdvAmount(outgoingInvoicesDto.getRealKdvAmount());
        outgoingInvoices.setTotalAmountWithKdv(outgoingInvoicesDto.getTotalAmountWithKdv());

        outgoingInvoicesRepository.save(outgoingInvoices);

        return modelMapper.map(outgoingInvoices, OutgoingInvoicesDto.class);
    }
    /*
    @Override
    public TPage<OutgoingInvoicesDto> getAll(Pageable pageable) {
        TPage page = new TPage<OutgoingInvoicesDto>();
        Page<OutgoingInvoices> data = outgoingInvoicesRepository.findAll(pageable);
        OutgoingInvoicesDto[] dtos = modelMapper.map(data.getContent(),OutgoingInvoicesDto[].class);
        page.setStat(data, Arrays.asList(dtos));
        return page;
    }

 */
}
