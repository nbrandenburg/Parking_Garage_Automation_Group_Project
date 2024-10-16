/*
    Written By: Oakley Cardwell
    Reviewed By: Gene Holt, Nicole Brandenburg
*/

package com.ParkingGarageOptimizer.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class ParkingTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;


    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isPaid;
    private Double amountCharged;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private CustomUser user;
}
