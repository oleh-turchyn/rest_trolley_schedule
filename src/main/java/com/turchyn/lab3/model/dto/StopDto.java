package com.turchyn.lab3.model.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class StopDto {
    private int id;
    private String name;
    private Set<ScheduleDto> schedules = new HashSet<>();
    private Set<RouteDto> routes = new HashSet<>();
}
