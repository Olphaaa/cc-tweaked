package fr.iut.cctweaked.controller;

import fr.iut.cctweaked.domain.Storage;
import fr.iut.cctweaked.exception.StorageException;
import fr.iut.cctweaked.service.StorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StorageController {
    private final StorageService storageService;

    public StorageController(final StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping
    private ResponseEntity<List<Storage>> getAll() {
        try {
            List<Storage> storages = storageService.getAll();
            return new ResponseEntity<>(storages, HttpStatus.OK);
        } catch (Exception e) {
            throw new StorageException("Error while getting all storages", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @GetMapping("/{:uuid}")
    private ResponseEntity<Storage> getOne(@PathVariable String uuid) {
        try {
            Storage storage = storageService.getOne(uuid);
            return new ResponseEntity<>(storage, HttpStatus.OK);
        } catch (Exception e) {
            throw new StorageException("Error while getting one storage", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @PostMapping
    private ResponseEntity<Storage> addStorage(@RequestBody Storage storage) {
        try {
            Storage addedStorage = storageService.addStorage(storage);
            return new ResponseEntity<>(addedStorage, HttpStatus.OK);
        } catch (Exception e) {
            throw new StorageException("Error while adding a new storage", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @PutMapping
    private ResponseEntity<Storage> editStorage(@RequestBody Storage storage) {
        try {
            Storage editedStorage = storageService.editStorage(storage);
            return new ResponseEntity<>(editedStorage, HttpStatus.OK);
        } catch (Exception e) {
            throw new StorageException("Error while adding a new storage", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @DeleteMapping("/{:uuid}")
    private ResponseEntity<String> deleteStorage(@PathVariable String uuid) {
        try {
            storageService.deleteStorage(uuid);
            return new ResponseEntity<>("Storage deleted", HttpStatus.OK);
        } catch (Exception e) {
            throw new StorageException("Excepiton while deleting Storage", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }

    }

}
