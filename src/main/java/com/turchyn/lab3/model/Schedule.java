package com.turchyn.lab3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "schedule_tb")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ElementCollection
    @CollectionTable(name = "schedule_hours",joinColumns = @JoinColumn(name = "schedule_id"))
    private Set<String> scheduleHours = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "transport_id"), name = "transport_id")
    @JsonIgnoreProperties(value = {"schedule_tb", "hibernateLazyInitializer"})
    private PublicTransport transport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "stop_id"), name = "stop_id")
    @JsonIgnoreProperties(value = {"schedule_tb", "hibernateLazyInitializer"})
    private Stop stop;



}
