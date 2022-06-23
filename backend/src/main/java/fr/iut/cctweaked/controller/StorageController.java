package fr.iut.cctweaked.controller;

import fr.iut.cctweaked.config.SpringFoxConfig;
import fr.iut.cctweaked.domain.Storage;
import fr.iut.cctweaked.dto.StorageDTO;
import fr.iut.cctweaked.errors.Error;
import fr.iut.cctweaked.service.StorageService;
import fr.iut.cctweaked.utils.mapper.StorageMapper;
import io.swagger.annotations.Api;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("storage")
@Api(tags = {SpringFoxConfig.STORAGE_TAG})
public class StorageController {
    private final StorageService storageService;

    public StorageController(final StorageService storageService) {
        this.storageService = storageService;
    }

    /**
     * Get all storages
     * @return List of storages
     */
    @GetMapping
    private ResponseEntity<List<StorageDTO>> getAll() {
        try {
            List<Storage> storages = storageService.getStorages();
            return new ResponseEntity<>(StorageMapper.storageListToStorageDTOList(storages), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: change Error to a custom error
            throw new Error("Error while getting all storages", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    /**
     * Get storage by id
     * @param id Storage id
     * @return Storage
     */
    @GetMapping("/{id}")
    private ResponseEntity<StorageDTO> getOne(@PathVariable String id) {
        try {
            Storage storage = storageService.getStorage(new ObjectId(id));
            return new ResponseEntity<>(StorageMapper.storageToStorageDTO(storage), HttpStatus.OK);
        } catch (Exception e) {
            throw new Error("Error while getting one storage", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    /**
     * Add a storage
     * @param storage Storage
     * @return Storage
     */
    @PostMapping
    private ResponseEntity<StorageDTO> addStorage(@RequestBody Storage storage) {
        try {
            Storage addedStorage = storageService.addStorage((storage));
            return new ResponseEntity<>(StorageMapper.storageToStorageDTO(addedStorage), HttpStatus.OK);
        } catch (Exception e) {
            throw new Error("Error while adding a new storage: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    /**
     * Edit a storage
     * @param storage Storage to edit
     * @return Edited storage
     */
    @PutMapping
    private ResponseEntity<StorageDTO> editStorage(@RequestBody StorageDTO storage) {
        try {
            Storage editedStorage = storageService.editStorage(StorageMapper.storageDTOtoStorage(storage));
            return new ResponseEntity<>(StorageMapper.storageToStorageDTO(editedStorage), HttpStatus.OK);
        } catch (Exception e) {
            throw new Error("Error while adding a new storage", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    /**
     * Delete a storage
     * @param id Storage id
     * @return Deleted storage
     */
    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteStorage(@PathVariable String id) {
        try {
            storageService.deleteStorage(new ObjectId(id));
            return new ResponseEntity<>("Storage deleted", HttpStatus.OK);
        } catch (Exception e) {
            throw new Error("Exception while deleting Storage", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

}
