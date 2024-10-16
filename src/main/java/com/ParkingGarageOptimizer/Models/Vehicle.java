/*
    Written By: Oakley Cardwell
    Reviewed By: Gene Holt, Nicole Brandenburg
*/

package com.ParkingGarageOptimizer.Models;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String color;
    private String make;
    private String model;
    private String licensePlate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private CustomUser user;
}
