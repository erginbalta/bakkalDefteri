package com.bakkaldefteri.bakkalDefteri.repositories;

import com.bakkaldefteri.bakkalDefteri.domain.Suppliers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

@Qualifier("suppliers")
public interface SuppliersRepository extends JpaRepository<Suppliers, Long> {
    @Query("SELECT sup FROM Suppliers sup WHERE sup.taxNumber = ?1")
    Suppliers findSuppliersByTaxNumber(String taxNumber);
}
