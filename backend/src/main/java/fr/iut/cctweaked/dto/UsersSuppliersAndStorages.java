package fr.iut.cctweaked.dto;

import fr.iut.cctweaked.domain.Storage;
import fr.iut.cctweaked.domain.Supplier;
import fr.iut.cctweaked.domain.User;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;

import java.util.List;

@Accessors(chain = true)
@ToString
public class UsersSuppliersAndStorages {
    private String _id;
    private String name;
    private User owner;
    private Supplier[] suppliers;
    private Storage[] storages;
}
