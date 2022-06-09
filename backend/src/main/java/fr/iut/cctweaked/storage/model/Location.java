package fr.iut.cctweaked.storage.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id
    private ObjectId _id;
    private Double x;
    private Double y;
    private Double z;
    private String world;
}
