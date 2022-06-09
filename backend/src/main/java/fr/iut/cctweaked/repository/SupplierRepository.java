package fr.iut.cctweaked.repository;

import fr.iut.cctweaked.domain.Supplier;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SupplierRepository extends MongoRepository<Supplier, String> {
    Supplier findBy_id(ObjectId _id);
}
