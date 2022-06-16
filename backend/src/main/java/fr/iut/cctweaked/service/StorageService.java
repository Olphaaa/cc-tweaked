package fr.iut.cctweaked.service;

import fr.iut.cctweaked.domain.Storage;

import fr.iut.cctweaked.exception.StorageException;
import fr.iut.cctweaked.repository.StorageRepository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Document(collection = "storages")
public class StorageService {
    private final StorageRepository storageRepository;

    public StorageService(final StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    public List<Storage> getStorages() {
        return storageRepository.findAll();
    }

    public Storage addStorage(Storage storage) {
        return storageRepository.save(storage);
    }

    public Storage editStorage(Storage storage) {
        Storage storageToEdit = getStorage(storage.get_id());
        return storageRepository.save(storageToEdit);
    }

    public void deleteStorage(ObjectId _id) {
        Storage storageToDelete = storageRepository.findById(_id).orElseThrow();

        storageRepository.delete(storageToDelete);
    }

    public Storage getStorage(ObjectId _id) {
        return storageRepository.findById(_id).orElseThrow();
    }
}
