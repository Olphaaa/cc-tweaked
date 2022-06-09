package fr.iut.cctweaked.storage;

import fr.iut.cctweaked.storage.model.Storage;
import fr.iut.cctweaked.supplier.model.Supplier;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StorageRepository extends MongoRepository<Storage, String> {
    Storage findBy_id(ObjectId _id);
}
