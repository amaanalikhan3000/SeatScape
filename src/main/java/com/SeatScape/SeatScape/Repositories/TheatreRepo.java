package com.SeatScape.SeatScape.Repositories;

import com.SeatScape.SeatScape.Entities.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepo extends JpaRepository<Theatre,Long> {

}
