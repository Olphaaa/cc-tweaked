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
        return new ResponseEntity<>(StorageMapper.storageListToStorageDTOList(storageService.getStorages()), HttpStatus.OK);
    }

    /**
     * Get storage by id
     * @param id Storage id
     * @return Storage
     */
    @GetMapping("/{id}")
    private ResponseEntity<StorageDTO> getOne(@PathVariable String id) {
        return new ResponseEntity<>(StorageMapper.storageToStorageDTO(storageService.getStorage(new ObjectId(id))), HttpStatus.OK);
    }

    /**
     * Add a storage
     * @param storage Storage
     * @return Storage
     */
    @PostMapping
    private ResponseEntity<StorageDTO> addStorage(@RequestBody Storage storage) {
        return new ResponseEntity<>(StorageMapper.storageToStorageDTO(storageService.addStorage(storage)), HttpStatus.OK);
    }

    /**
     * Edit a storage
     * @param storage Storage to edit
     * @return Edited storage
     */
    @PutMapping
    private ResponseEntity<StorageDTO> editStorage(@RequestBody StorageDTO storage) {
            return new ResponseEntity<>(StorageMapper.storageToStorageDTO(storageService.editStorage(StorageMapper.storageDTOtoStorage(storage))), HttpStatus.OK);
    }

    /**
     * Delete a storage
     * @param id Storage id
     * @return Deleted storage
     */
    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteStorage(@PathVariable String id) {
        storageService.deleteStorage(new ObjectId(id));
        return new ResponseEntity<>("Storage deleted", HttpStatus.OK);
    }

}
