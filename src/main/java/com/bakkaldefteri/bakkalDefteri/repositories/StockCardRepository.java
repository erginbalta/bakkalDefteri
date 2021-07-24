package com.bakkaldefteri.bakkalDefteri.repositories;

import com.bakkaldefteri.bakkalDefteri.domain.StockCard;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

@Qualifier("stockCard")
public interface StockCardRepository extends JpaRepository<StockCard, Long> {
}
