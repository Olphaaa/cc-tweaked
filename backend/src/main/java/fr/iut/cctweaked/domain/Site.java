package fr.iut.cctweaked.domain;

import fr.iut.cctweaked.domain.Supplier;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@Document(collection = "sites")
public class Site {
    private ObjectId _id;
    private String name;
    
    @DBRef
    private User owner;

    @DBRef
    private List<Supplier> suppliers;

    @DBRef
    private List<Storage> storages;
}
