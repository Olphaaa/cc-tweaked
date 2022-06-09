package fr.iut.cctweaked.supplier.model;

import fr.iut.cctweaked.model.Location;
import fr.iut.cctweaked.supplier.model.enums.SupplierType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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
