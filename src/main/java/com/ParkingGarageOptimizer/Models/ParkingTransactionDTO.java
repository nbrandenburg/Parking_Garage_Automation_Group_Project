/*
    Written By: Oakley Cardwell
    Reviewed By: Gene Holt, Nicole Brandenburg
*/

package com.ParkingGarageOptimizer.Models;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

@Data
public class ParkingTransactionDTO {
    private LocalDate startDate;
    private LocalTime startTime;
    private LocalDate endDate;
    private LocalTime endTime;
    private Map<String, Boolean> recurring;
}

