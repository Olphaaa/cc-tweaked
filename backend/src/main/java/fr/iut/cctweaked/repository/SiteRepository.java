package fr.iut.cctweaked.repository;

import fr.iut.cctweaked.domain.Site;
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
    AggregationResults<Object> findUsersSites(String id);

    @Aggregation(
            {
                    "{$lookup: {from: 'users',let: { userId: '$owner.$id' },pipeline: [{ $match: { $expr: { $eq: ['$_id', '$$userId'] } } },],as: 'owner'}}",
                    "{ $unwind: { path: '$owner' }}",
                    "{$match: {'owner._id': { $eq: ?0 }}}",
                    "{$lookup: {from: 'storages',let: { siteId: '$_id' },pipeline: [{ $match: { $expr: { $eq: ['$site.$id', '$$siteId'] } } },{$unset : ['site']}],as: 'storages'}}",
                    "{$lookup: {from: 'suppliers',let: { siteId: '$_id' },pipeline: [{ $match: { $expr: { $eq: ['$site.$id', '$$siteId'] } } },{$unset : ['site']}],as: 'suppliers'}}",
                    "{$group: {_id: '$owner._id',owner: { $first: '$owner' },sites: { $push: '$$ROOT' }}}",
                    "{$unset : ['sites.owner', '_id']}",
            }
    )
    AggregationResults<Object> findSuppliersAndStorages(String id);

}
