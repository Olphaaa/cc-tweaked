package fr.iut.cctweaked.domain;

import fr.iut.cctweaked.domain.enums.IOPortState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IOPort {
    @Id
    private ObjectId _id;
    private IOPortState state;
    private Long transferRate;
    private Long maxTransferRate;
}
