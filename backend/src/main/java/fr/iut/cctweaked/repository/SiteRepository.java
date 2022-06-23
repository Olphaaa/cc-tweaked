package fr.iut.cctweaked.repository;

import fr.iut.cctweaked.domain.Site;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository extends MongoRepository<Site, ObjectId> {

}
