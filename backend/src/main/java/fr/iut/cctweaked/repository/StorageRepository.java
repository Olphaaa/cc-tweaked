package fr.iut.cctweaked.repository;

import fr.iut.cctweaked.domain.Storage;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StorageRepository extends MongoRepository<Storage, String> {
    Storage findBy_id(ObjectId _id);
}
