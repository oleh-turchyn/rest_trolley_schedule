package com.turchyn.lab3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "publicTransport_tb")
public class PublicTransport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private double price;
    private int amountOfSeats;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    private Route route;

    @OneToMany(mappedBy = "publicTransport", cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnore
    private Set<Stop> stops = new HashSet<>();

    @OneToMany(mappedBy = "publicTransport", cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnore
    private Set<Schedule> schedules = new HashSet<>();
}
