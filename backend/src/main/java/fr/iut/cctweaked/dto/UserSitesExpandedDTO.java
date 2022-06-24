package fr.iut.cctweaked.dto;

import fr.iut.cctweaked.domain.Storage;
import fr.iut.cctweaked.domain.Supplier;
import fr.iut.cctweaked.domain.User;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@ToString
public class UserSitesExpandedDTO {
    private User owner;
    private Supplier[] suppliers;
    private Storage[] storages;
}
