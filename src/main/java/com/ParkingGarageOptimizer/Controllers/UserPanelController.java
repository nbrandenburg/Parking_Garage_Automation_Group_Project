/*
    Written By: Oakley Cardwell
    Reviewed By: Gene Holt, Nicole Brandenburg
*/

package com.ParkingGarageOptimizer.Controllers;

import com.ParkingGarageOptimizer.Models.CustomUser;
import com.ParkingGarageOptimizer.Models.ParkingTransaction;
import com.ParkingGarageOptimizer.Models.ParkingTransactionDTO;
import com.ParkingGarageOptimizer.Service.CustomUserService;
import com.ParkingGarageOptimizer.Service.ParkingTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class UserPanelController {

    @Autowired
    ParkingTransactionService parkingTransactionService;
    @Autowired
    CustomUserService customUserService;

    @RequestMapping("/userpanel")
    public String getUserProfile(Model model){
        return "user-panel";
    }

    @PostMapping("/createTransaction")
    public String postCreateTransaction(@ModelAttribute("parkingTransaction") ParkingTransaction parkingTransaction) {
        if(parkingTransactionService.createTransaction(parkingTransaction)){
            System.out.println("Parking Transaction succeeded");
            return "success";
        }
        else {
            // If creation fails, return a bad request response
            System.out.println("Parking Transaction failed");
            return "failed";
        }
    }

    @RequestMapping("/createTransaction")
    public String getCreateTransaction(Model model){
        model.addAttribute("parkingTransaction", new ParkingTransaction());
        return "create-transaction";
    }

    @RequestMapping("/reservation")
    public String getReservation(Model model){
        model.addAttribute("parkingTransaction", new ParkingTransaction());
        return "reservation";
    }

    @PostMapping("/createReservation")
    public ResponseEntity<?> createParkingTransaction(@RequestBody ParkingTransactionDTO transactionDTO) throws UnsupportedEncodingException, URISyntaxException {
        ParkingTransaction transaction = convertToEntity(transactionDTO);
        parkingTransactionService.createTransaction(transaction);

        // Assuming the amountPaid is a field of the ParkingTransaction entity
        String amountPaid = transaction.getAmountCharged().toString();

        // Construct the redirection URL with the amountPaid query parameter
        URI location = new URI("/payment?amount=" + URLEncoder.encode(amountPaid, "UTF-8"));

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);

        customUserService.incrementParking(2L);

        return new ResponseEntity<>(headers, HttpStatus.SEE_OTHER);
    }

    private ParkingTransaction convertToEntity(ParkingTransactionDTO transactionDTO) {
        ParkingTransaction transaction = new ParkingTransaction();

        // Get and set the start and end time
        LocalDateTime startDateTime = LocalDateTime.of(transactionDTO.getStartDate(), transactionDTO.getStartTime());
        LocalDateTime endDateTime = LocalDateTime.of(transactionDTO.getEndDate(), transactionDTO.getEndTime());

        transaction.setStartTime(startDateTime);
        transaction.setEndTime(endDateTime);


        // Get, calculate, and set the amount charged
        Duration duration = Duration.between(startDateTime, endDateTime);

        long hours = duration.toHours();

        Double amountCharged = parkingTransactionService.getHourlyRate() * hours;

        transaction.setAmountCharged(amountCharged);


        // Get and set the user
        CustomUser user = customUserService.getUserByID(2L);

        transaction.setUser(user);

        return transaction;
    }

    @RequestMapping("/payment")
    public String getPayment(){
        return "paymentportal";
    }

    @RequestMapping("/payment-success")
    public String getPaymentSuccess(){
        return "payment-success";
    }

    @RequestMapping("/createuser")
    public String createNewUser(){
        return "createuser";
    }

    @PostMapping("/createuser")
    public CustomUser createUser(@RequestBody CustomUser customUser) {
        customUser.getVehicles().forEach(vehicle -> vehicle.setUser(customUser));

        customUserService.createUser(customUser);
        System.out.println("User created");
        return customUser;
    }

    @GetMapping("/parkingHistory")
    public ResponseEntity<List<ParkingTransaction>> getParkingHistory() {
        List<ParkingTransaction> parkingHistory = customUserService.getParkingHistory(2L);
        return ResponseEntity.ok(parkingHistory);
    }
}
