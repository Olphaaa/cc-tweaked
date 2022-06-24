package fr.iut.cctweaked.repository;

import fr.iut.cctweaked.domain.Site;
import fr.iut.cctweaked.dto.UserSitesDTO;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository extends MongoRepository<Site, ObjectId> {
    @Aggregation({
            "{ $match: { 'owner.$id': ?0 }}",
            "{ $lookup: { from: 'users', let: { userId: '$owner.$id' }, pipeline: [ { $match: { $expr: { $eq: [ '$_id', '$$userId' ] } } } ], as: 'owner' }}",
            "{ $unwind: { path: '$owner' }}"
    })
    AggregationResults<UserSitesDTO> findUsersSites(String id);

    /* Fonctionne sur MongoDB compass, mais pas avec Spring Boot 😉 (ON PLEURE)*/
//    @Aggregation({
//            {
//                    $match: {
//            "_id": "f4411437-c65d-45d0-bca6-5a9c7565115d"
//            }
//            },
//            {
//                    $lookup: {
//            from: "sites",
//            let: { userId: "$_id" },
//            pipeline: [
//            { $match: { $expr: { $eq: ["$owner.$id", "$$userId"] } } },
//            { $project: { _id: 0, suppliers: 1, storages: 1 } },
//            ],
//            as: "sites"
//            }
//            },
//            {
//                    $unwind: {
//            path: "$sites",
//            preserveNullAndEmptyArrays: true
//            }
//            },
//            {
//                    $project: {
//            _id: 1,
//            username: 1,
//            suppliers:  "$sites.suppliers",
//            storages: "$sites.storages",
//            }
//            },
//            {
//                    $group: {
//            _id: "$_id",
//            username: { $first: "$username" },
//            suppliers: { $push: "$suppliers" },
//            storages: {$push : "$storages"},
//            }
//            },
//            {
//                    $unwind: {
//            path: "$suppliers",
//            }
//            },
//            {
//                    $unwind: {
//            path: "$suppliers",
//            }
//            },
//            {
//                    $group: {
//            _id: "$_id",
//            username: { $first: "$username" },
//            suppliers: { $push: "$suppliers" },
//            storages: { $first : "$storages" },
//            }
//            },
//            {
//                    $unwind: {
//            path: "$storages",
//            }
//            },
//            {
//                    $unwind: {
//            path: "$storages",
//            }
//            },
//            {
//                    $group: {
//            _id: "$_id",
//            username: { $first: "$username" },
//            suppliers: { $first: "$suppliers" },
//            storages: {$push : "$storages"},
//            }
//            }
//    })
//    AggregationResults<UserSitesExpandedDTO> findSuppliersAndStorages(String id);
}
