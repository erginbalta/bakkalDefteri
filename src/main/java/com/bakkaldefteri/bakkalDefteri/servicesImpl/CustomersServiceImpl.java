package com.bakkaldefteri.bakkalDefteri.servicesImpl;

import com.bakkaldefteri.bakkalDefteri.domain.Customers;
import com.bakkaldefteri.bakkalDefteri.dtos.CustomersDto;
import com.bakkaldefteri.bakkalDefteri.repositories.CustomersRepository;
import com.bakkaldefteri.bakkalDefteri.services.CustomersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomersServiceImpl implements CustomersService {
    private final CustomersRepository customersRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public CustomersServiceImpl(ModelMapper modelMapper, CustomersRepository customersRepository){
        this.customersRepository = customersRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CustomersDto save(CustomersDto customersDto){
        Customers customers = modelMapper.map(customersDto, Customers.class);
        customers = customersRepository.save(customers);

        return modelMapper.map(customers, CustomersDto.class);
    }

    @Override
    public CustomersDto getById(Long id){
        Customers customers = customersRepository.getById(id);

        return modelMapper.map(customers,CustomersDto.class);
    }

    @Override
    public List<CustomersDto> getAll(){
        List<Customers> customersList = customersRepository.findAll();
        List<CustomersDto> customersDtoList = Arrays.asList(modelMapper.map(customersList,CustomersDto[].class));
        return customersDtoList;
    }

    @Override
    public Boolean delete(Long id){
        Customers customer = customersRepository.getById(id);
        if(customer==null){
            throw new IllegalArgumentException("Customer Does Not Exist");
        }
        customersRepository.delete(customer);
        if(customersRepository.getById(customer.getId()) == null){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public CustomersDto update(Long id, CustomersDto customersDto) {
        Customers customer = customersRepository.getById(id);
        if(customer == null){
            throw new IllegalArgumentException("Customer Does Not Exist -- ID : " +id);
        }
        customer.setCustomerName(customersDto.getCustomerName());
        customer.setAddress(customersDto.getAddress());
        customer.setEmail(customersDto.getEmail());
        customer.setPhone(customersDto.getPhone());
        customer.setTaxNumber(customersDto.getTaxNumber());
        customer.setTaxAdministration(customersDto.getTaxAdministration());

        customersRepository.save(customer);
        return modelMapper.map(customer,CustomersDto.class);
    }
}
