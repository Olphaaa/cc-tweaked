package fr.iut.cctweaked.model;

import lombok.Getter;
import org.bson.types.ObjectId;

@Getter
public class User {
    private ObjectId _id;
    private String uuid;
}
