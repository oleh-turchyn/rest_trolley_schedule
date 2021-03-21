package com.turchyn.lab3.repository;

import com.turchyn.lab3.model.PublicTransport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicTransportRepository extends JpaRepository<PublicTransport, Integer> {
}
