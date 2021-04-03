package com.turchyn.lab3.model;

import com.turchyn.lab3.model.transport.TransportType;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(exclude = {"route"})
@Table(name = "publicTransport_tb")
public class PublicTransport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private double price;
    private int amountOfSeats;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "publicTransport")
    private Route route;
    private TransportType transportType;


//    @OneToMany(mappedBy = "publicTransport", cascade = CascadeType.ALL,
//            orphanRemoval = true)
//    @JsonIgnore
//    private Set<Stop> stops = new HashSet<>();
//
//    @OneToMany(mappedBy = "publicTransport", cascade = CascadeType.ALL,
//            orphanRemoval = true)
//    @JsonIgnore
//    private Set<Schedule> schedules = new HashSet<>();
}
