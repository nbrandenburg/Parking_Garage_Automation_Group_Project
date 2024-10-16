/*
    Written By: Oakley Cardwell
    Reviewed By: Gene Holt, Nicole Brandenburg
*/

package com.ParkingGarageOptimizer;

import com.ParkingGarageOptimizer.Controllers.UserPanelController;
import com.ParkingGarageOptimizer.Models.ParkingTransaction;
import com.ParkingGarageOptimizer.Service.ParkingTransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserPanelControllerTest {
    @InjectMocks
    private UserPanelController userPanelController;

    @Mock
    private ParkingTransactionService parkingTransactionService;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPostCreateTransaction_Success() {
        ParkingTransaction parkingTransaction = new ParkingTransaction();
        when(parkingTransactionService.createTransaction(any(ParkingTransaction.class))).thenReturn(true);

        String result = userPanelController.postCreateTransaction(parkingTransaction);

        assertEquals("success", result);
    }

    @Test
    public void testPostCreateTransaction_Failure() {
        ParkingTransaction parkingTransaction = new ParkingTransaction();
        when(parkingTransactionService.createTransaction(any(ParkingTransaction.class))).thenReturn(false);

        String result = userPanelController.postCreateTransaction(parkingTransaction);

        assertEquals("failed", result);
    }
}
