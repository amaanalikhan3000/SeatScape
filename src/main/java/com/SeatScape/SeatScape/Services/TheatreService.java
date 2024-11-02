package com.SeatScape.SeatScape.Services;

import com.SeatScape.SeatScape.Entities.Theatre;
import com.SeatScape.SeatScape.Repositories.TheatreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepo theatreRepo;

    // Create
    public void saveEntry(Theatre theatre){
        theatreRepo.save(theatre);
    }

    // Read
    public List<Theatre> getAll(){
        return theatreRepo.findAll();
    }

    // Read By id
    public Optional<Theatre> findById(Long theatreId){
        return theatreRepo.findById(theatreId);
    }
    // Update By id

    // Delete By id
    public void deleteById(Long theatreId){
        theatreRepo.deleteById(theatreId);
    }


}
