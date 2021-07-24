package com.bakkaldefteri.bakkalDefteri.servicesImpl;

import com.bakkaldefteri.bakkalDefteri.domain.Suppliers;
import com.bakkaldefteri.bakkalDefteri.dtos.SuppliersDto;
import com.bakkaldefteri.bakkalDefteri.repositories.SuppliersRepository;
import com.bakkaldefteri.bakkalDefteri.services.SuppliersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SuppliersServiceImpl implements SuppliersService {

    private final SuppliersRepository suppliersRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public SuppliersServiceImpl(SuppliersRepository suppliersRepository,ModelMapper modelMapper){
        this.suppliersRepository = suppliersRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SuppliersDto save(SuppliersDto suppliersDto) {
        Suppliers supCheck = suppliersRepository.findSuppliersByTaxNumber(suppliersDto.getTaxNumber());
        if(supCheck != null){
            throw new IllegalArgumentException("Supplier Allready Exists");
        }
        Suppliers supplierDb = modelMapper.map(suppliersDto, Suppliers.class);
        supplierDb = suppliersRepository.save(supplierDb);

        suppliersDto.setId(supplierDb.getId());

        return suppliersDto;
    }

    @Override
    public SuppliersDto getById(Long id) {
        Suppliers suppliersDb = suppliersRepository.getById(id);
        return modelMapper.map(suppliersDb,SuppliersDto.class);
    }

    @Override
    public List<SuppliersDto> getAll() {
        List<Suppliers> suppliersList = suppliersRepository.findAll();
        List<SuppliersDto> suppliersDtosList = Arrays.asList(modelMapper.map(suppliersList,SuppliersDto[].class));
        return suppliersDtosList;
    }

    @Override
    public Boolean delete(Long id) {
        Suppliers suppliers = suppliersRepository.getById(id);
        if(suppliers==null){
            throw new IllegalArgumentException("Suppliers Does Not Exist");
        }
        suppliersRepository.delete(suppliers);
        return suppliersRepository.getById(suppliers.getId()) == null;
    }

    @Override
    public SuppliersDto update(Long id, SuppliersDto suppliersDto) {
        Suppliers suppliers = suppliersRepository.getById(id);
        if(suppliers == null){
            throw new IllegalArgumentException("Suppliers Does Not Exist -- ID : " +id);
        }

        //update
        suppliers.setSupplierName(suppliersDto.getSupplierName());
        suppliers.setEmail(suppliersDto.getEmail());
        suppliers.setAddress(suppliersDto.getAddress());
        suppliers.setPhone(suppliersDto.getPhone());
        suppliers.setTaxAdministration(suppliersDto.getTaxAdministration());
        suppliers.setTaxNumber(suppliersDto.getTaxNumber());

        suppliersRepository.save(suppliers);

        return modelMapper.map(suppliers,SuppliersDto.class);
    }
}
