package com.SeatScape.SeatScape.Repositories;

import com.SeatScape.SeatScape.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends JpaRepository<Movie,Long> {


}
