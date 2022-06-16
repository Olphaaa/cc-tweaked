package fr.iut.cctweaked.domain;

import fr.iut.cctweaked.domain.Supplier;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@Document(collection = "sites")
public class Site {
    private ObjectId _id;
    private String name;
    private User owner;
    private List<Supplier> suppliers;
    private List<Storage> storages;
}
