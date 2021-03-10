package com.turchyn.lab3.repository;

import com.turchyn.lab3.model.transport.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {

}
