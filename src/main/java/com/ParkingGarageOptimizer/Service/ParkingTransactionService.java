/*
    Written By: Oakley Cardwell
    Reviewed By: Gene Holt, Nicole Brandenburg
*/

package com.ParkingGarageOptimizer.Service;

import com.ParkingGarageOptimizer.Models.ParkingTransaction;
import com.ParkingGarageOptimizer.Repositories.ParkingTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingTransactionService {
    @Autowired
    private ParkingTransactionRepository parkingTransactionRepository;

    private double hourlyRate = 15;

    public boolean createTransaction(ParkingTransaction parkingTransaction){
        parkingTransactionRepository.save(parkingTransaction);
        return true;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
}
