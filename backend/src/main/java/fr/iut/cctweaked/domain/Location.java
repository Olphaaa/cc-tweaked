package fr.iut.cctweaked.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
@Accessors(chain = true)
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
