package fr.iut.cctweaked.dto;

import fr.iut.cctweaked.domain.IOPort;
import fr.iut.cctweaked.domain.Location;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@Accessors(chain = true)
public class StorageDTO implements Serializable {
    private String _id;
    private Integer capacity;
    private IOPort input;
    private IOPort output;
    private Location location;
    public StorageDTO() {
    }
}
