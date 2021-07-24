package com.bakkaldefteri.bakkalDefteri.repositories;

import com.bakkaldefteri.bakkalDefteri.domain.ProductCard;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

@Qualifier("productCard")
public interface ProductCardRepository extends JpaRepository<ProductCard, Long> {
}
