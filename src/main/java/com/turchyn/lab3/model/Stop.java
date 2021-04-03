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
@EqualsAndHashCode(exclude={"routes"})
@Table(name = "stop_tb")
public class Stop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
//    private String transport; // test for dto

    @OneToMany(mappedBy = "stop", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Schedule> schedules = new HashSet<>();

//    @ManyToMany
//    @JoinTable(name = "stop_route", joinColumns = {@JoinColumn(name = "stop_id")}, inverseJoinColumns = {@JoinColumn(name = "route_id")})
//    private Set<Route> routes = new HashSet<>();




    @ManyToMany(mappedBy = "stops")
    private Set<Route> routes = new HashSet<>();



//    @ElementCollection
//    @JsonIgnore
//    @CollectionTable(name = "available_transport",joinColumns = @JoinColumn(name = "stop_id"))
//    private Set<String> availableTransport = new LinkedHashSet<>();
//

    //
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(foreignKey = @ForeignKey(name = "route_id"), name = "route_id")
//    @JsonIgnoreProperties(value = {"stop_tb", "hibernateLazyInitializer"})
//    private Route route;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(foreignKey = @ForeignKey(name = "public_transport_id"), name = "public_transport_id")
//    @JsonIgnoreProperties(value = {"stop_tb", "hibernateLazyInitializer"})
//    private PublicTransport publicTransport;

}
