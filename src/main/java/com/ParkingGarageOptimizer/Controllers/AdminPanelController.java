/*
    Written By: Oakley Cardwell
    Reviewed By: Gene Holt, Nicole Brandenburg
*/

package com.ParkingGarageOptimizer.Controllers;

import com.ParkingGarageOptimizer.Service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminPanelController {
    @Autowired
    CustomUserService customUserService;
    @PostMapping("/addSpaces")
    public ResponseEntity<?> addSpaces(@RequestBody Integer amount){
        customUserService.increaseGarageSize(2L, amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/removeSpaces")
    public ResponseEntity<?> removeSpaces(@RequestBody Integer amount){
        customUserService.decreaseGarageSize(2L, amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/getSpaces")
    public ResponseEntity<Integer> getSpaces() {
        Integer garageSize = customUserService.getGarageSize(2L);
        return new ResponseEntity<>(garageSize, HttpStatus.OK);
    }

    @RequestMapping("/getOccupants")
    public ResponseEntity<Integer> getOccupants() {
        Integer occupants = customUserService.getOccupancy(2L);
        return new ResponseEntity<>(occupants, HttpStatus.OK);
    }
}
