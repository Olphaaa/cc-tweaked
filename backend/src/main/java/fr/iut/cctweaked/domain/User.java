package fr.iut.cctweaked.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@Document(collection = "users")
public class User {
    private String _id;
    private String username;
}
