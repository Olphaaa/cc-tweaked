package fr.iut.cctweaked.dto;

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
    private List<SupplierDTO> suppliers;
    private List<StorageDTO> storages;
}
