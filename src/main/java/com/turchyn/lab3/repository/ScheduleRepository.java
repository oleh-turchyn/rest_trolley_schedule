package com.turchyn.lab3.repository;

import com.turchyn.lab3.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {
}
