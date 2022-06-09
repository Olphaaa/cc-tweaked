package fr.iut.cctweaked.service;

import fr.iut.cctweaked.exception.SupplierException;
import fr.iut.cctweaked.domain.Supplier;
import fr.iut.cctweaked.repository.SupplierRepository;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(final SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> getSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier addSupplier(Supplier supplier) {
        if (getSupplier(supplier.get_id()) == null) {
            return supplierRepository.save(supplier);
        }
        throw new SupplierException("The supplier is already existing", HttpStatus.NOT_FOUND);
    }

    public Supplier editSupplier(ObjectId _id) {
        Supplier supplierToEdit = getSupplier(_id);
        return supplierRepository.save(supplierToEdit);
    }

    public void deleteSupplier(ObjectId _id) {
        Supplier supplierToDelete = getSupplier(_id);
        if (supplierToDelete == null) {
            throw new SupplierException("The wanted supplier doesn't exist", HttpStatus.NOT_FOUND);
        }
        supplierRepository.delete(supplierToDelete);
    }

    public Supplier getSupplier(ObjectId _id) {
        return supplierRepository.findBy_id(_id);
    }
}
