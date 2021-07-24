package com.bakkaldefteri.bakkalDefteri.repositories;

import com.bakkaldefteri.bakkalDefteri.domain.OutgoingInvoices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

@Qualifier("outgoingInvoices")
public interface OutgoingInvoicesRepository extends JpaRepository<OutgoingInvoices, Long> {
}
