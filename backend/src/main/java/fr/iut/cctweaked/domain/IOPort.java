package fr.iut.cctweaked.domain;

import fr.iut.cctweaked.domain.enums.IOPortState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class IOPort {
    @Id
    private ObjectId _id;

    private IOPortState state;
    private Long transferRate;
    private Long maxTransferRate;
}
