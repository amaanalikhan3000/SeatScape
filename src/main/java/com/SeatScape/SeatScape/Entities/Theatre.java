package com.SeatScape.SeatScape.Entities;
import jakarta.persistence.*;

import java.util.List;

import lombok.Data;

@Data

@Entity
@Table(name = "theatres")
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theatreId;

    private String theatreName;
    private String location;

    @Embedded
    private SeatsLayout seatsLayout;
}
    @Embeddable
    @Data
    class SeatsLayout{
        private int noOfrows;
        private int noOfcolumns;
        private List<Integer> aislePositions;
    }


