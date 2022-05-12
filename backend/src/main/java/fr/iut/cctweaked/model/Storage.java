package fr.iut.cctweaked.model;

import lombok.Getter;
import org.bson.types.ObjectId;

@Getter
public class Storage {
    private ObjectId _id;
    private Long capacity;
}
