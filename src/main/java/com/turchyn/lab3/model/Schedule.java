package com.turchyn.lab3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "schedule_tb")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String hours;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "stop_id"), name = "stop_id")
    @JsonIgnoreProperties(value = {"schedule_tb", "hibernateLazyInitializer"})
    private Stop stop; // а якщо що то мож простим полем зробити

    //може зробити звязок із транспортом щоб спростити методи

//    private String hours;
//    @ElementCollection
//    @JsonIgnore
//    @CollectionTable(name = "schedule_hours",joinColumns = @JoinColumn(name = "schedule_id"))
//    private Set<String> scheduleHours = new LinkedHashSet<>();
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(foreignKey = @ForeignKey(name = "public_transport_id"), name = "public_transport_id")
//    @JsonIgnoreProperties(value = {"schedule_tb", "hibernateLazyInitializer"})
//    private PublicTransport publicTransport;





}
