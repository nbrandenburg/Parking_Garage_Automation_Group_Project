/*
    Written By: Oakley Cardwell
    Reviewed By: Gene Holt, Nicole Brandenburg
*/

package com.ParkingGarageOptimizer;

import com.ParkingGarageOptimizer.Service.ParkingTransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ParkingTransactionTest {

    @Autowired
    private ParkingTransactionService transactionService;

    @Test
    public void testFindByParkingSpot() {
        // Mock the required methods and test
    }

    // ... Additional tests for other methods
}
