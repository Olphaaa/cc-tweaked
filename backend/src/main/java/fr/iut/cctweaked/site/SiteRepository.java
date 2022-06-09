package fr.iut.cctweaked.site;

import fr.iut.cctweaked.site.model.Site;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository extends MongoRepository<Site, ObjectId> {
}
