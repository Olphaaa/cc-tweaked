package fr.iut.cctweaked.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
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
