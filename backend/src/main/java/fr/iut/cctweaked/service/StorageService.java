package fr.iut.cctweaked.service;


import fr.iut.cctweaked.domain.Storage;
import fr.iut.cctweaked.exception.StorageException;
import fr.iut.cctweaked.repository.StorageRepository;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StorageService {
    private final StorageRepository storageRepository;

    public StorageService(final StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    public List<Storage> getStorages() {
        return storageRepository.findAll();
    }

    public Storage addStorage(Storage storage) {
        if (getStorage(storage.get_id()) == null) {
            return storageRepository.save(storage);
        }
        throw new StorageException("The storage is already existing", HttpStatus.NOT_FOUND);
    }

    public Storage editStorage(Storage storage) {
        Storage storageToEdit = getStorage(storage.get_id());
        return storageRepository.save(storageToEdit);
    }
    
    public void deleteStorage(ObjectId _id) {
        Storage storageToDelete = storageRepository.findBy_id(_id);
        if (storageToDelete == null) {
            throw new StorageException("The wanted storage doesn't exist", HttpStatus.NOT_FOUND);
        }
        storageRepository.delete(storageToDelete);
    }

    public Storage getStorage(ObjectId _id) {
        return storageRepository.findBy_id(_id);
    }

    public Storage getOne(String uuid) {
        return null;
    }

    public List<Storage> getAll() {
        return null;
    }
}
