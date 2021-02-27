package com.turchyn.lab3.model.dto;

import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ScheduleDto {
    private int id;
    private Set<String> scheduleHours = new LinkedHashSet<>();
    private PublicTransportDto transport;
    private StopDto stop;
    //
    //    @ManyToOne(fetch = FetchType.LAZY)
    //    @JoinColumn(foreignKey = @ForeignKey(name = "stop_id"), name = "stop_id")
    //    @JsonIgnoreProperties(value = {"schedule_tb", "hibernateLazyInitializer"})
    //    private Stop stop;
}
