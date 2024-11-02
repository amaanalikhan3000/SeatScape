package com.SeatScape.SeatScape.Entities;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import java.util.Date;

@Document(collection = "movie")
@Data
public class MovieEntity {
    @Id
    private String id;
    private String title;
    private List<String> genre;
    private int duration;
    private Date releaseDate;
    private String summary;
    private List<Cast> cast;

    public static class Cast {
        private String actorName;
        private String role;

    }
}