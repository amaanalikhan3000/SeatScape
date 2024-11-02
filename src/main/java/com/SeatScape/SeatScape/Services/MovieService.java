package com.SeatScape.SeatScape.Services;


import com.SeatScape.SeatScape.Entities.Movie;
import com.SeatScape.SeatScape.Repositories.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepo movieRepo;


    // Create
    public void saveEntry(Movie movie){
        movieRepo.save(movie);
    }

    // Read
    public List<Movie> getAll(){
        return movieRepo.findAll();
    }

    // Read By id
    public Optional<Movie> findById(Long id){
        return movieRepo.findById(id);
    }
    // Update By id

    // Delete By id
    public void deleteById(Long id){
        movieRepo.deleteById(id);
    }



}
