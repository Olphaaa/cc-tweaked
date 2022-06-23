package fr.iut.cctweaked.utils.mapper;

import fr.iut.cctweaked.domain.Storage;
import fr.iut.cctweaked.dto.StorageDTO;
import org.bson.types.ObjectId;

import java.util.List;

public class StorageMapper {
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

    public static StorageDTO storageToStorageDTO(Storage storage) {
        StorageDTO storageDTO = new StorageDTO();
        storageDTO.set_id(storage.get_id().toString())
                .setCapacity(storage.getCapacity())
                .setInput(storage.getInput())
                .setOutput(storage.getOutput())
                .setLocation(storage.getLocation());
        return storageDTO;
    }

    public static List<StorageDTO> storageListToStorageDTOList(List<Storage> storageList) {
        List<StorageDTO> storageDTOList = new java.util.ArrayList<>();
        for (Storage storage : storageList) {
            storageDTOList.add(storageToStorageDTO(storage));
        }
        return storageDTOList;
    }
}
