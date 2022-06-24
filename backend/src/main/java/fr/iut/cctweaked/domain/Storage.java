package fr.iut.cctweaked.domain;

import lombok.*;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@NoArgsConstructor
@Data
@Accessors(chain = true)
@Document(collection = "storages")
public class Storage {
    @Id
    private ObjectId _id;
    private Integer capacity;

    private IOPort input;
    private IOPort output;
    private Location location;
}
