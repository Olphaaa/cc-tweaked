package fr.iut.cctweaked.utils.mapper;

import fr.iut.cctweaked.domain.Storage;
import fr.iut.cctweaked.dto.StorageDTO;
import org.bson.types.ObjectId;

import java.util.List;

public class StorageMapper {

    /**
     * Convert a storage to a storageDTO
     * @param storageDTO Storage to convert
     * @return StorageDTO
     */
    public static Storage storageDTOtoStorage(StorageDTO storageDTO) {
        Storage storage = new Storage();
        if (storageDTO.get_id() != null) {
            storage.set_id(new ObjectId(storageDTO.get_id()));
        }
        storage.setCapacity(storageDTO.getCapacity())
                .setInput(storageDTO.getInput())
                .setOutput(storageDTO.getOutput())
                .setLocation(storageDTO.getLocation());
        return storage;
    }

    /**
     * Convert a storage to a storageDTO
     * @param storage Storage to convert
     * @return StorageDTO
     */
    public static StorageDTO storageToStorageDTO(Storage storage) {
        StorageDTO storageDTO = new StorageDTO();
        storageDTO.set_id(storage.get_id().toString())
                .setCapacity(storage.getCapacity())
                .setInput(storage.getInput())
                .setOutput(storage.getOutput())
                .setLocation(storage.getLocation());
        return storageDTO;
    }

    /**
     * Convert a list of storages to a list of storageDTO
     * @param storageList List of storages to convert
     * @return List of storageDTO
     */
    public static List<StorageDTO> storageListToStorageDTOList(List<Storage> storageList) {
        List<StorageDTO> storageDTOList = new java.util.ArrayList<>();
        for (Storage storage : storageList) {
            storageDTOList.add(storageToStorageDTO(storage));
        }
        return storageDTOList;
    }

    public static List<Storage> storageDTOListToStorageList(List<StorageDTO> storageDTOList) {
        List<Storage> storageList = new java.util.ArrayList<>();
        for (StorageDTO storageDTO : storageDTOList) {
            storageList.add(storageDTOtoStorage(storageDTO));
        }
        return storageList;
    }
}
