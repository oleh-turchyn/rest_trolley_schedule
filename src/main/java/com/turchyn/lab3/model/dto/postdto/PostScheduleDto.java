package com.turchyn.lab3.model.dto.postdto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PostScheduleDto {
    private int id;
    private String hours;
    private PostTransportDto publicTransport;
}
