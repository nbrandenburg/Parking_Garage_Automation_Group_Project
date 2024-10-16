/*
    Written By: Oakley Cardwell
    Reviewed By: Gene Holt, Nicole Brandenburg
*/

package com.ParkingGarageOptimizer.Service;

import com.ParkingGarageOptimizer.Models.CustomUser;
import com.ParkingGarageOptimizer.Models.LoginRequest;
import com.ParkingGarageOptimizer.Models.ParkingTransaction;
import com.ParkingGarageOptimizer.Repositories.CustomUserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserService{

    @Autowired
    private CustomUserRepository userRepository;

    public boolean authenticateUserByLoginRequest(LoginRequest loginRequest){
        CustomUser user = userRepository.findByUsername(loginRequest.getUsername());
        if (user == null)
            return false;
        if (user.getPassword().equals(loginRequest.getPassword()))
            return true;
        return false;
    }

    public boolean createUser(CustomUser customUser){
        userRepository.save(customUser);
        return true;
    }

    public CustomUser getUserByID(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + id));
    }

    public void increaseGarageSize(Long userId, int increasedAmount) {
        CustomUser user = getUserByID(userId);
        user.increaseGarageSize(increasedAmount);
        userRepository.save(user);
    }

    public void decreaseGarageSize(Long userId, int decreasedAmount) {
        CustomUser user = getUserByID(userId);
        user.decreaseGarageSize(decreasedAmount);
        userRepository.save(user);
    }

    public Integer getGarageSize(Long userId){
        CustomUser user = getUserByID(userId);
        Integer garageSize = user.getGarageSize();
        userRepository.save(user);
        return garageSize;
    }

    public Integer getOccupancy(Long userId){
        CustomUser user = getUserByID(userId);
        Integer occupancy = user.getOccupancy();
        userRepository.save(user);
        System.out.println(occupancy);
        return occupancy;
    }

    public boolean incrementParking(Long userId){
        CustomUser user = getUserByID(userId);
        boolean success = user.incrementParking();
        if (success) {
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public void decrementParking(Long userId){
        CustomUser user = getUserByID(userId);
        user.decrementParking();
        userRepository.save(user);
    }

    public List<ParkingTransaction> getParkingHistory(Long userId){
        CustomUser user = getUserByID(userId);
        return user.getParkingHistory();
    }
}

