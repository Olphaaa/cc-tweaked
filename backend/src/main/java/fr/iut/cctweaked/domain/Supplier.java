package fr.iut.cctweaked.domain;

import fr.iut.cctweaked.domain.Location;
import fr.iut.cctweaked.domain.enums.SupplierType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
    @Id
    private ObjectId _id;
    private SupplierType supplierType;
    private Location location;
    private Long output;
    private boolean status;

    public Supplier(SupplierType supplierType, Location location, Long output, boolean status) {
        this.supplierType = supplierType;
        this.location = location;
        this.output = output;
        this.status = status;
    }
}
