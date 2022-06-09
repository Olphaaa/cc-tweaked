package fr.iut.cctweaked.model;

import fr.iut.cctweaked.domain.Supplier;
import lombok.Getter;
import org.bson.types.ObjectId;

import java.util.List;

@Getter
public class Site {
    private ObjectId _id;
    private String name;
    private String owner;
    private List<Supplier> suppliers;
}
