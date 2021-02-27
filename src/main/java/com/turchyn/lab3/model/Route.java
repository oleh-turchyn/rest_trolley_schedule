package com.turchyn.lab3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.LinkedHashSet;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "route_tb")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int number; // продумати чи треба окремо номер чи зійде айдішка
    private String title;

    @OneToOne(mappedBy = "route_tb")
    private PublicTransport transport;

    @ElementCollection
    @CollectionTable(name = "route_days",joinColumns = @JoinColumn(name = "route_id"))
    private Set<String> routeDays = new LinkedHashSet<>();

//    @ElementCollection(fetch = FetchType.LAZY)
//    @CollectionTable(name = "route_stops",joinColumns = @JoinColumn("route_id"))
//    private Set<Stop> stops = new HashSet<>();

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnore
    private Set<Stop> stops = new HashSet<>();


}
