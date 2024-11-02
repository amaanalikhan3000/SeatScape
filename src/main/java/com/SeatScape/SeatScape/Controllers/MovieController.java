package com.SeatScape.SeatScape.Controllers;


import com.SeatScape.SeatScape.Entities.Movie;
import com.SeatScape.SeatScape.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Movie> all = movieService.getAll();
        if (all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(all, HttpStatus.NOT_FOUND);

    }

    @GetMapping("movieId/{movieId}")
    public ResponseEntity<?> getEntryById(@PathVariable Long movieId) {
        Optional<Movie> f = movieService.findById(movieId);

        if (f.isPresent()) {
            return new ResponseEntity<>(f, HttpStatus.OK);
        }
        return new ResponseEntity<>(f, HttpStatus.NOT_FOUND);

    }


    @PostMapping
    public ResponseEntity<?> createEntry(@RequestBody Movie movie) {

        try {
            movieService.saveEntry(movie);
            return new ResponseEntity<>(movie, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }


    @DeleteMapping("movieId/{movieId}")
    public ResponseEntity<?> DeleteById(@PathVariable Long movieId) {
        movieService.deleteById(movieId);
        return new ResponseEntity<>(movieService, HttpStatus.NO_CONTENT);
    }


    @PutMapping("movieId/{movieId}")
    public ResponseEntity<?> updateById(@PathVariable Long movieId,@RequestBody Movie newEntry) {
        Movie old = movieService.findById(movieId).orElse(null);
        if(old!=null){
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            old.setGenre(newEntry.getGenre() != null && !newEntry.getGenre().equals("") ? newEntry.getGenre() : old.getGenre());

            Optional<Integer> optionalInt = Optional.of(newEntry.getDuration());
            old.setDuration(optionalInt.isPresent()  ? newEntry.getDuration() : old.getDuration());

            old.setReleaseDate(newEntry.getReleaseDate()!=null && newEntry.getReleaseDate().equals("")? newEntry.getReleaseDate(): old.getReleaseDate());

            movieService.saveEntry(old);
            return new ResponseEntity<>(old, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

