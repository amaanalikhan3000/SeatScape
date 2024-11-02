package com.SeatScape.SeatScape.Entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "theatres")
public class TheatreEntity {

    @Id
    private String id;
    private String theatreName;
    private String location;
    private SeatsLayout seatsLayout;
    private List<Showtime> showtimes;


    public static class SeatsLayout {
        private int rows;
        private int columns;
        private List<Integer> aislePositions;

    }

    public static class Showtime {
        private String showtimeId;
        private String movieId;
        private Date startTime;
        private Date endTime;

    }
}
