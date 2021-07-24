package com.bakkaldefteri.bakkalDefteri.repositories;

import com.bakkaldefteri.bakkalDefteri.domain.Customers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

@Qualifier("customers")
public interface CustomersRepository extends JpaRepository<Customers, Long> {
}
