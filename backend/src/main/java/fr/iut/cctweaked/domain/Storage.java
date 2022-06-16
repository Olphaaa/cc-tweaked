package fr.iut.cctweaked.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Storage {
    @Id
    private ObjectId _id;
    private Integer capacity;
    private IOPort input;
    private IOPort output;
    private Location location;
}
