/*
    Written By: Oakley Cardwell
    Reviewed By: Gene Holt, Nicole Brandenburg
*/

package com.ParkingGarageOptimizer;

import com.ParkingGarageOptimizer.Bootstrap.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SecurityConfigTest {

    @Autowired
    private SecurityConfig securityConfig;

    @Test
    public void testSecurityEndpoints() {
        // Test the security configurations for various endpoints
    }
}
