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
public class PublicTransportDto {
    private int id;
    private String type;
    private double price;
    private int amountOfSeats;
//    private RouteDto routeNumber;
//    private Set<StopDto> stops= new HashSet<>();
//    private Set<ScheduleDto> schedules = new HashSet<>();

    //    @OneToOne(cascade = CascadeType.ALL)
    //    @JoinColumn(name = "route_id", referencedColumnName = "id")
    //    private Route route;     //подумати

}
