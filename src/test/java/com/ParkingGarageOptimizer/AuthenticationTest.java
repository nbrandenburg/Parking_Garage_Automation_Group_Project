/*
    Written By: Oakley Cardwell
    Reviewed By: Gene Holt, Nicole Brandenburg
*/

package com.ParkingGarageOptimizer;

import com.ParkingGarageOptimizer.Controllers.AuthenticationController;
import com.ParkingGarageOptimizer.Models.LoginRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AuthenticationTest {

    @Autowired
    private AuthenticationController authenticationController;

    @Test
    public void testValidUserLogin() {
        LoginRequest request = new LoginRequest();
        request.setUsername("user");
        request.setPassword("password");
        String result = authenticationController.authenticateUser(request);
        assertThat(result).isEqualTo("user-panel");
    }

    @Test
    public void testInvalidUserLogin() {
        LoginRequest request = new LoginRequest();
        request.setUsername("invalidUser");
        request.setPassword("invalidPassword");
        String result = authenticationController.authenticateUser(request);
        assertThat(result).isEqualTo("failed");
    }

    @Test
    public void testValidAdminLogin() {
        LoginRequest request = new LoginRequest();
        request.setUsername("admin");
        request.setPassword("password");
        String result = authenticationController.authenticateUser(request);
        assertThat(result).isEqualTo("user-panel");
    }

    @Test
    public void testInvalidAdminLogin() {
        LoginRequest request = new LoginRequest();
        request.setUsername("invalidAdmin");
        request.setPassword("invalidPassword");
        String result = authenticationController.authenticateUser(request);
        assertThat(result).isEqualTo("failed");
    }
}
