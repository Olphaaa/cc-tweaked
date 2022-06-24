package fr.iut.cctweaked.utils.mapper;

import fr.iut.cctweaked.domain.Storage;
import fr.iut.cctweaked.domain.Supplier;
import fr.iut.cctweaked.dto.StorageDTO;
import fr.iut.cctweaked.dto.SupplierDTO;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class SupplierMapper {

    /**
     * Convert a supplier to a supplierDTO
     * @param supplierDTO SupplierDTO to convert
     * @return SupplierDTO
     */
    public static Supplier supplierDTOToSupplier(SupplierDTO supplierDTO) {
        Supplier supplier = new Supplier();
        if (supplierDTO.get_id() != null) {
            supplier.set_id(new ObjectId(supplierDTO.get_id()));
        }
        supplier.setSupplierType(supplierDTO.getSupplierType())
                .setLocation(supplierDTO.getLocation())
                .setOutput(supplierDTO.getOutput())
                .setStatus(supplierDTO.getStatus());
        return supplier;
    }

    /**
     * Convert a supplier to a supplierDTO
     * @param supplier Supplier to convert
     * @return SupplierDTO
     */
    public static SupplierDTO supplierToSupplierDTO(Supplier supplier) {
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.set_id(supplier.get_id().toString())
                .setSupplierType(supplier.getSupplierType())
                .setLocation(supplier.getLocation())
                .setOutput(supplier.getOutput())
                .setStatus(supplier.getStatus());
        return supplierDTO;
    }

    /**
     * Convert a list of suppliers to a list of supplierDTO
     * @param supplierList List of suppliers to convert
     * @return List of supplierDTO
     */
    public static List<SupplierDTO> supplierListToSupplierDTOList(List<Supplier> supplierList) {
        List<SupplierDTO> supplierDTOList = new ArrayList<>();
        for (Supplier supplier : supplierList) {
            supplierDTOList.add(supplierToSupplierDTO(supplier));
        }
        return supplierDTOList;
    }

    public static List<Supplier> supplierDTOListToSupplierList(List<SupplierDTO> supplierDTOList) {
        List<Supplier> supplierList = new ArrayList<>();
        for (SupplierDTO supplierDTO : supplierDTOList) {
            supplierList.add(supplierDTOToSupplier(supplierDTO));
        }
        return supplierList;
    }

}
