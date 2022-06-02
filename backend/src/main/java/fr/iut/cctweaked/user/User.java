package fr.iut.cctweaked.user;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "Emp")
public class User {
    private ObjectId _id;
    private String uuid;

    public User(String uuid) {
        this.uuid = uuid;
    }
}
