/*
    Written By: Oakley Cardwell
    Reviewed By: Gene Holt, Nicole Brandenburg
*/

package com.ParkingGarageOptimizer.Repositories;

import com.ParkingGarageOptimizer.Models.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomUserRepository extends JpaRepository<CustomUser, Long> {
    CustomUser findByUsername(String username);
}
