package fr.iut.cctweaked.dto;

import fr.iut.cctweaked.domain.IOPort;
import fr.iut.cctweaked.domain.Location;
import fr.iut.cctweaked.domain.enums.SupplierState;
import fr.iut.cctweaked.domain.enums.SupplierType;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class SupplierDTO {
    private String _id;
    private SupplierType supplierType;
    private Location location;
    private IOPort output;
    private SupplierState status;
    public SupplierDTO() {
    }
}
