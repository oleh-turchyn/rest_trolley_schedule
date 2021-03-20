package com.turchyn.lab3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "stop_tb")
public class Stop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String carrier;

    @ElementCollection
    @CollectionTable(name = "available_transport",joinColumns = @JoinColumn(name = "stop_id"))
    private Set<String> availableTransport = new LinkedHashSet<>();

    @OneToMany(mappedBy = "stop", cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnore
    private Set<Schedule> schedules = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "route_id"), name = "route_id")
    @JsonIgnoreProperties(value = {"stop_tb", "hibernateLazyInitializer"})
    private Route route;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "public_transport_id"), name = "public_transport_id")
    @JsonIgnoreProperties(value = {"stop_tb", "hibernateLazyInitializer"})
    private PublicTransport publicTransport;

}
