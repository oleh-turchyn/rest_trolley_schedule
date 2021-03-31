package com.turchyn.lab3.model.dto;

import com.turchyn.lab3.model.transport.TransportType;
import lombok.*;

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
    private RouteDto route;
    private TransportType transportType;

//private int id;
//    private String type;
//    private double price;
//    private int amountOfSeats;
//    @OneToOne(cascade = CascadeType.ALL,mappedBy = "transport")
//    private Route route;
//    private TransportType transportType;


//    private RouteDto routeNumber;
//    private Set<StopDto> stops= new HashSet<>();
//    private Set<ScheduleDto> schedules = new HashSet<>();

    //    @OneToOne(cascade = CascadeType.ALL)
    //    @JoinColumn(name = "route_id", referencedColumnName = "id")
    //    private Route route;     //подумати

}
