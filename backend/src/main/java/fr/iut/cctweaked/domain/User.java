package fr.iut.cctweaked.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "users")
public class User {
    private ObjectId _id;
    private String inGameId;

    public User(String inGameId) {
        this.inGameId = inGameId;
    }

    public User update(User user) {
        this.inGameId = user.inGameId;
        return this;
    }
}
