package fr.iut.cctweaked.service;


import fr.iut.cctweaked.domain.Storage;
import fr.iut.cctweaked.repository.StorageRepository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Document(collection = "storages")
public class StorageService {
    private final StorageRepository storageRepository;

    /**
     * Constructor
     * @param storageRepository StorageRepository
     */
    public StorageService(final StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    /**
     * Get all storages
     * @return List of storages
     */
    public List<Storage> getStorages() {
        return storageRepository.findAll();
    }

    /**
     * Add a storage
     * @param storage Storage to add
     * @return Added storage
     */
    public Storage addStorage(Storage storage) {
        return storageRepository.save(storage);
    }

    /**
     * Edit a storage
     * @param storage Storage to edit
     * @return Edited storage
     */
    public Storage editStorage(Storage storage) {
        Storage storageToEdit = getStorage(storage.get_id());
        return storageRepository.save(storageToEdit);
    }

    /**
     * Delete a storage
     * @param _id Storage id
     */
    public void deleteStorage(ObjectId _id) {
        Storage storageToDelete = storageRepository.findById(_id).orElseThrow();

        storageRepository.delete(storageToDelete);
    }

    /**
     * Get storage by id
     * TODO: Quelle CustomException utiliser pour la cas ou il y a eu une erreur lors du get ?
     * @param _id Storage id
     * @return Storage
     */
    public Storage getStorage(ObjectId _id) {
        return storageRepository.findById(_id).orElseThrow();
    }

}
