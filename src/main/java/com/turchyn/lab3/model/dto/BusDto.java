package com.turchyn.lab3.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BusDto {
    private int id;
    private String type;
    private double price;
    private int amountOfSeats;
}
