package fr.iut.cctweaked.supplier;

import fr.iut.cctweaked.supplier.model.Supplier;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SupplierRepository extends MongoRepository<Supplier, String> {
    Supplier findBy_id(ObjectId _id);
}
