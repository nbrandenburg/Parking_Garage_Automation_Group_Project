/*
    Written By: Oakley Cardwell
    Reviewed By: Gene Holt, Nicole Brandenburg
*/

package com.ParkingGarageOptimizer;

import com.ParkingGarageOptimizer.Service.CustomUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserManagementTest {

    @Autowired
    private CustomUserService userService;

    @Test
    public void testLoadUserByUsername() {
        // Mock the required methods and test
    }

    @Test
    public void testAuthenticateUserByLoginRequest() {
        // Mock the required methods and test
    }
}
