package com.turchyn.lab3.model.dto;

import com.turchyn.lab3.model.dto.postdto.PostStopDto;
import com.turchyn.lab3.model.dto.postdto.PostTransportDto;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RouteDto {
    private int id;
    private int number;
    //    private PublicTransportDto transport; // отут подумати
//    private Set<String> routeDays = new LinkedHashSet<>();
    private String name;
    private String days;
    private PostTransportDto publicTransport;
    private Set<PostStopDto> stops = new HashSet<>();

//    private Set<StopDto> stops = new HashSet<>();

    //    @OneToOne(mappedBy = "route_tb")
    //    private PublicTransport transport;
    //

}
