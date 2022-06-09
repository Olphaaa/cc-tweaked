package fr.iut.cctweaked.site.model;

import fr.iut.cctweaked.supplier.model.Supplier;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "sites")
public class Site {
    private ObjectId _id;
    private String name;
    private String owner;
    private List<Supplier> suppliers;
}
