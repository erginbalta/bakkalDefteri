package com.bakkaldefteri.bakkalDefteri.servicesImpl;

import com.bakkaldefteri.bakkalDefteri.domain.ProductCard;
import com.bakkaldefteri.bakkalDefteri.dtos.ProductCardDto;
import com.bakkaldefteri.bakkalDefteri.repositories.ProductCardRepository;
import com.bakkaldefteri.bakkalDefteri.services.ProductCardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductCardServiceImpl implements ProductCardService {

    private final ProductCardRepository productCardRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public ProductCardServiceImpl(ProductCardRepository productCardRepository, ModelMapper modelMapper){
        this.modelMapper = modelMapper;
        this.productCardRepository = productCardRepository;
    }

    @Override
    public ProductCardDto save(ProductCardDto productCardDto) {
        ProductCard productCard = modelMapper.map(productCardDto,ProductCard.class);
        productCard = productCardRepository.save(productCard);
        return modelMapper.map(productCard,ProductCardDto.class);
    }

    @Override
    public ProductCardDto getById(Long id) {
        ProductCard productCard = productCardRepository.getById(id);
        return modelMapper.map(productCard,ProductCardDto.class);
    }

    @Override
    public List<ProductCardDto> getAll() {
        List<ProductCard> productCardList = productCardRepository.findAll();
        List<ProductCardDto> productCardDtos = Arrays.asList(modelMapper.map(productCardList,ProductCardDto[].class));
        return productCardDtos;
    }

    @Override
    public Boolean delete(Long id) {
        ProductCard productCard = productCardRepository.getById(id);
        if(productCard == null){
            throw new IllegalArgumentException("Product Card Des Not Exist");
        }
        productCardRepository.delete(productCard);
        return productCardRepository.getById(productCard.getId()) == null;
    }

    @Override
    public ProductCardDto update(Long id, ProductCardDto productCardDto) {
        ProductCard productCard = productCardRepository.getById(id);
        if(productCard == null){
            throw new IllegalArgumentException("Product Card Does Not Exists -> ID: " +id);
        }

        productCard.setCategory(productCardDto.getCategory());
        productCard.setColor(productCardDto.getColor());
        productCard.setGender(productCardDto.getGender());
        productCard.setSize(productCardDto.getSize());

        productCardRepository.save(productCard);
        return modelMapper.map(productCard,ProductCardDto.class);
    }
}
