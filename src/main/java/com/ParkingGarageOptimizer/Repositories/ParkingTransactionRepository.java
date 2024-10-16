/*
    Written By: Oakley Cardwell
    Reviewed By: Gene Holt, Nicole Brandenburg
*/

package com.ParkingGarageOptimizer.Repositories;

import com.ParkingGarageOptimizer.Models.ParkingTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ParkingTransactionRepository extends JpaRepository<ParkingTransaction, Long> {

    List<ParkingTransaction> findByIsPaid(boolean isPaid);
    List<ParkingTransaction> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);
}
