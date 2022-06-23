package fr.iut.cctweaked.repository;

import fr.iut.cctweaked.domain.Site;
import fr.iut.cctweaked.domain.User;
import fr.iut.cctweaked.dto.UsersSuppliersAndStorages;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {




}

