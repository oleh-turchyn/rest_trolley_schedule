package com.turchyn.lab3.model;

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
@EqualsAndHashCode(exclude = {"publicTransport","stops"})
@Table(name = "route_tb")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int number; // продумати чи треба окремо номер чи зійде айдішка + в репо метод по цьому  треба
    private String name;
    private String days;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publicTransport_id", referencedColumnName = "id")
    private PublicTransport publicTransport;
//    @ManyToMany(mappedBy = "routes")
//    private Set<Stop> stops = new HashSet<>();


    @ManyToMany
    @JoinTable(name = "stop_route", joinColumns = {@JoinColumn(name = "route_id")}, inverseJoinColumns = {@JoinColumn(name = "stop_id")})
    private Set<Stop> stops = new HashSet<>();
//


//    @ElementCollection
//    @CollectionTable(name = "route_days",joinColumns = @JoinColumn(name = "route_id"))
//    @JsonIgnore
//    private Set<String> routeDays = new LinkedHashSet<>();

//    @ElementCollection(fetch = FetchType.LAZY)
//    @CollectionTable(name = "route_stops",joinColumns = @JoinColumn("route_id"))
//    private Set<Stop> stops = new HashSet<>();

//    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL,
//            orphanRemoval = true)
//    @JsonIgnore
//    private Set<Stop> stops = new HashSet<>();


}
