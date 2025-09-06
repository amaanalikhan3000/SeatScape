package com.SeatScape.SeatScape.Controllers;

import com.SeatScape.SeatScape.Entities.Theatre;
import com.SeatScape.SeatScape.Services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;


    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Theatre> all = theatreService.getAll();
        if (all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(all, HttpStatus.NOT_FOUND);

    }

    @GetMapping("theatreId/{theatreId}")
    public ResponseEntity<?> getEntryById(@PathVariable Long theatreId) {
        Optional<Theatre> f = theatreService.findById(theatreId);

        if (f.isPresent()) {
            return new ResponseEntity<>(f, HttpStatus.OK);
        }
        return new ResponseEntity<>(f, HttpStatus.NOT_FOUND);

    }


    @PostMapping
    public ResponseEntity<?> createEntry(@RequestBody Theatre theatre) {

        try {
            theatreService.saveEntry(theatre);
            return new ResponseEntity<>(theatre, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }


    @DeleteMapping("theatreId/{theatreId}")
    public ResponseEntity<?> DeleteById(@PathVariable Long theatreId) {
        theatreService.deleteById(theatreId);
        return new ResponseEntity<>(theatreService, HttpStatus.NO_CONTENT);
    }


    @PutMapping("theatreId/{theatreId}")
    public ResponseEntity<?> updateById(@PathVariable Long theatreId, @RequestBody Theatre newEntry) {
        Theatre old = theatreService.findById(theatreId).orElse(null);
        if (old != null) {
            old.setTheatreName(newEntry.getTheatreName() != null && !newEntry.getTheatreName().equals("") ? newEntry.getTheatreName() : old.getTheatreName());
            old.setLocation(newEntry.getLocation() != null && !newEntry.getLocation().equals("") ? newEntry.getLocation() : old.getLocation());


            old.setSeatsLayout(newEntry.getSeatsLayout() != null ? newEntry.getSeatsLayout() : old.getSeatsLayout());

            theatreService.saveEntry(old);
            return new ResponseEntity<>(old, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
