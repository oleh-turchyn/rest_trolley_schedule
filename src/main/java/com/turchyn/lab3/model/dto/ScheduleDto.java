package com.turchyn.lab3.model.dto;

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
public class ScheduleDto {
    private int id;
    private String hours;
    //    private StopDto stop;
    private Set<StopDto> stops = new HashSet<>();
    private PostTransportDto publicTransport;
}
