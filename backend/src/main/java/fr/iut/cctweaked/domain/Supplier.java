package fr.iut.cctweaked.domain;

import fr.iut.cctweaked.domain.Location;
import fr.iut.cctweaked.domain.enums.SupplierState;
import fr.iut.cctweaked.domain.enums.SupplierType;
import lombok.*;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Data
@Accessors(chain = true)
@Document(collection = "suppliers")
public class Supplier {
    @Id
    private ObjectId _id;
    private SupplierType supplierType;
    private Location location;
    private IOPort output;
    private SupplierState status;


    public Supplier(SupplierType supplierType, Location location, IOPort output, SupplierState status) {
        this.supplierType = supplierType;
        this.location = location;
        this.output = output;
        this.status = status;
    }
}
