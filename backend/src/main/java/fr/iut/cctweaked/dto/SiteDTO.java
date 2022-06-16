package fr.iut.cctweaked.dto;

import fr.iut.cctweaked.domain.Storage;
import fr.iut.cctweaked.domain.Supplier;
import fr.iut.cctweaked.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class SiteDTO {
    private String _id;
    private String name;
    private User owner;
    private List<SupplierDTO> supplierDTOs;
    private List<StorageDTO> storageDTOs;
}
