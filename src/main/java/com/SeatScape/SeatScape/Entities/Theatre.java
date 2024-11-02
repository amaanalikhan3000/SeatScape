package com.SeatScape.SeatScape.Entities;
import jakarta.persistence.*;
import java.util.Map;
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

    @Column(columnDefinition = "json")
    private Map<String, Object> seatsLayout;

}
