package com.bakkaldefteri.bakkalDefteri.servicesImpl;

import com.bakkaldefteri.bakkalDefteri.domain.StockCard;
import com.bakkaldefteri.bakkalDefteri.dtos.StockCardDto;
import com.bakkaldefteri.bakkalDefteri.repositories.StockCardRepository;
import com.bakkaldefteri.bakkalDefteri.services.StockCardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StockCardServiceImpl implements StockCardService {

    private final StockCardRepository stockCardRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public StockCardServiceImpl(StockCardRepository stockCardRepository,ModelMapper modelMapper){
        this.modelMapper = modelMapper;
        this.stockCardRepository = stockCardRepository;
    }

    @Override
    public StockCardDto save(StockCardDto stockCardDto) {
        StockCard stockCard = modelMapper.map(stockCardDto,StockCard.class);
        stockCard = stockCardRepository.save(stockCard);
        return modelMapper.map(stockCard,StockCardDto.class);
    }

    @Override
    public StockCardDto getById(Long id) {
        StockCard stockCard = stockCardRepository.getById(id);
        return modelMapper.map(stockCard,StockCardDto.class);
    }

    @Override
    public List<StockCardDto> getAll() {
        List<StockCard> stockCardList = stockCardRepository.findAll();
        List<StockCardDto> stockCardDtoList = Arrays.asList(modelMapper.map(stockCardList,StockCardDto[].class));
        return stockCardDtoList;
    }

    @Override
    public Boolean delete(Long id) {
        StockCard stockCard = stockCardRepository.getById(id);
        stockCardRepository.delete(stockCard);
        return stockCardRepository.getById(stockCard.getId()) == null;
    }

    @Override
    public StockCardDto update(Long id, StockCardDto stockCardDto) {
        StockCard stockCard = stockCardRepository.getById(id);
        if(stockCard == null){
            throw new IllegalArgumentException("Stock Card Does Not Exist -> ID: " +id);
        }

        stockCard.setNumber(stockCardDto.getNumber());
        stockCard.setProduct(stockCardDto.getProduct());
        stockCard.setUnitPrice(stockCardDto.getUnitPrice());
        stockCard.setIncomingInvoicesNumber(stockCardDto.getIncomingInvoicesNumber());
        stockCardRepository.save(stockCard);

        return modelMapper.map(stockCard, StockCardDto.class);
    }
}
