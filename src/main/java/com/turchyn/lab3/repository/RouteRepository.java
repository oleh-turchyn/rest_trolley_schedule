package com.turchyn.lab3.repository;

import com.turchyn.lab3.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route,Integer> {
    List<Route> findAllByNumber(int number);
    List<Route> findAllByTitle(String title);


}
