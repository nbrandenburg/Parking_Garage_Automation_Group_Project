/*
    Written By: Oakley Cardwell
    Reviewed By: Gene Holt, Nicole Brandenburg
*/

package com.ParkingGarageOptimizer.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "CUSTOMUSER")
public class CustomUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String role;
    private Integer garageSize;
    private Integer occupancy;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Vehicle> vehicles = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<ParkingTransaction> parkingHistory = new ArrayList<>();

    public void initGarage(){
        garageSize = 100;
        occupancy = 0;
    }

    public void increaseGarageSize(int increasedAmount){
        garageSize += increasedAmount;
    }
    public void decreaseGarageSize(int decreasedAmount){
        if (garageSize - decreasedAmount > 0)
            garageSize -= decreasedAmount;
        else
            System.out.println("Garage size cannot be less than 0, request rejected.");
    }

    public Integer getGarageSize(){
        if (garageSize == null || occupancy == null) {
            initGarage();
        }
        return garageSize;
    }

    public Integer getOccupancy(){
        if (garageSize == null || occupancy == null) {
            initGarage();
        }
        return occupancy;
    }
    public boolean requestParking(){
        if (garageSize == null || occupancy == null) {
            initGarage();
        }
        if (occupancy + 1 > garageSize)
            return false;
        return true;
    }
    public boolean incrementParking(){
        if (requestParking()) {
            occupancy++;
            System.out.println("Current occupancy: " + occupancy + "/" + garageSize);
            return true;
        }
        return false;
    }
    public boolean decrementParking(){
        occupancy--;
        System.out.println("Current occupancy: " + occupancy + "/" + garageSize);
        return true;
    }
}

