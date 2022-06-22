package fr.iut.cctweaked.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@Document(collection = "users")
public class User {
    private String _id;
    private String username;
}
