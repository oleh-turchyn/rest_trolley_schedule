package com.turchyn.lab3.repository;

import com.turchyn.lab3.model.Stop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StopRepository extends JpaRepository<Stop,Integer> {
    Stop findByName(String name);
}
