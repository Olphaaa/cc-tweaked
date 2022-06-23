package fr.iut.cctweaked.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class SiteDetailsDTO {
    private String _id;
    private String name;
    private List<StorageDTO> storageDTOs;
    private List<SupplierDTO> supplierDTOs;
}
