package com.SeatScape.SeatScape.Entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "bookings")
public class BookingEntity {
    @Id
    private String id;
    private String userId;
    private String movieId;
    private String showtimeId;
    private List<String> seatsBooked;
    private String paymentStatus;

}