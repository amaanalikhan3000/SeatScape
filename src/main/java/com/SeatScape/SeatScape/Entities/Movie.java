package com.SeatScape.SeatScape.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Date;

@Entity
@Table(name = "movies")
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    private String title;

    @ElementCollection
    @CollectionTable(name = "movie_genres", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "genre")
    private List<String> genre;

    private int duration;
    private Date releaseDate;

}