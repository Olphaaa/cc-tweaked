package fr.iut.cctweaked.utils.mapper;

import fr.iut.cctweaked.domain.Storage;
import fr.iut.cctweaked.domain.Supplier;
import fr.iut.cctweaked.dto.StorageDTO;
import fr.iut.cctweaked.dto.SupplierDTO;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class SupplierMapper {

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

    public static SupplierDTO supplierToSupplierDTO(Supplier supplier) {
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.set_id(supplier.get_id().toString())
                .setSupplierType(supplier.getSupplierType())
                .setLocation(supplier.getLocation())
                .setOutput(supplier.getOutput())
                .setStatus(supplier.getStatus());
        return supplierDTO;
    }

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
