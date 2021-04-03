package com.turchyn.lab3.model.dto.postdto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PostRouteDto {
    private int id;
    private int number;
    private String title;
    private String days;
    private PostTransportDto publicTransport;
//    private Set<PostStopDto> stops = new HashSet<>();
}
