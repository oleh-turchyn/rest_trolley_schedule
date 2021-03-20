package com.turchyn.lab3.model.dto;

import lombok.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
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
    private String carrier;
    private Set<String> availableTransport = new LinkedHashSet<>();
    private Set<ScheduleDto> schedules = new HashSet<>();
    private RouteDto route;       // тут би назву маршруту




}
