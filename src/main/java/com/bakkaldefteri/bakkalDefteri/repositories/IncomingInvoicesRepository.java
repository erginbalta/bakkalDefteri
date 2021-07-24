package com.bakkaldefteri.bakkalDefteri.repositories;

import com.bakkaldefteri.bakkalDefteri.domain.IncomingInvoices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

@Qualifier("incomingInvoices")
public interface IncomingInvoicesRepository extends JpaRepository<IncomingInvoices, Long> {
}
