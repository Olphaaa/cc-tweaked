package fr.iut.cctweaked.model;

import fr.iut.cctweaked.model.enums.IOPortState;
import lombok.Getter;
import org.bson.types.ObjectId;

@Getter
public class IOPort {
    private ObjectId _id;
    private IOPortState state;
    private Long transferRate;
    private Long maxTransferRate;
}
