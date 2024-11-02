package com.SeatScape.SeatScape.Entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document(collection = "payments")
public class PaymentEntity {
    @Id
    private String id;
    private String bookingId;
    private String status;
    private BigDecimal amount;

}