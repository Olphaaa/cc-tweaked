package fr.iut.cctweaked.model;

import fr.iut.cctweaked.model.enums.SupplierType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Getter
@NoArgsConstructor
public class Supplier {
    private ObjectId _id;
    private SupplierType supplierType;
    private Location location;
    private Long output;
    private boolean Status;

}
