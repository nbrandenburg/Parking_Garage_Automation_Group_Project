/*
    Written By: Oakley Cardwell
    Reviewed By: Gene Holt, Nicole Brandenburg
*/

package com.ParkingGarageOptimizer.Controllers;

import com.ParkingGarageOptimizer.Models.CustomUser;
import com.ParkingGarageOptimizer.Models.LoginRequest;
import com.ParkingGarageOptimizer.Service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthenticationController {

    @Autowired
    CustomUserService customUserService;

    @PostMapping("/adminlogin")
    public String authenticateAdminUser(@ModelAttribute("loginRequest") LoginRequest loginRequest) {
        if(customUserService.authenticateUserByLoginRequest(loginRequest)){
            System.out.println("Admin authenticated");
            return "admin-panel";
        }
        else {
            // If authentication fails, return a bad request response
            System.out.println("Admin not authenticated");
            return "failed";
        }
    }

    @RequestMapping("/adminlogin")
    public String getAdminLogin(Model model){
        model.addAttribute("loginRequest", new LoginRequest());
        return "admin-login";
    }

    @PostMapping("/userlogin")
    public String authenticateUser(@ModelAttribute("loginRequest") LoginRequest loginRequest) {
        if(customUserService.authenticateUserByLoginRequest(loginRequest)){
            System.out.println("User authenticated");
            return "user-panel";
        }
        else {
            // If authentication fails, return a bad request response
            System.out.println("User not authenticated");
            return "failed";
        }
    }

    @RequestMapping("/userlogin")
    public String getUserLogin(Model model){
        model.addAttribute("loginRequest", new LoginRequest());
        return "user-login";
    }

    @PostMapping("/createUser")
    public String authenticateUser(@ModelAttribute("customUser") CustomUser customUser) {
        if(customUserService.createUser(customUser)){
            System.out.println("User created");
            return "success";
        }
        else {
            // If creation fails, return a bad request response
            System.out.println("User not created");
            return "failed";
        }
    }

    @RequestMapping("/createUser")
    public String createUser(Model model){
        model.addAttribute("customUser", new CustomUser());
        return "create-user";
    }


}
