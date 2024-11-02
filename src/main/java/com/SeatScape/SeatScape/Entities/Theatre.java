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

    //@Column(columnDefinition = "json")
    //private Map<String, Object> seatsLayout;

  //  private TheatreEntity.SeatsLayout seatsLayout;

    @Embedded
    private seatsLayout seatsLayout;
}
    @Embeddable
    @Data
    class seatsLayout{
        private int NoOfrows;
        private int NoOfcolumns;
        private List<Integer> aislePositions;
    }


