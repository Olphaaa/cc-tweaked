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

    /**
     * Get all suppliers
     * @return List of suppliers
     */
    public List<Supplier> getSuppliers() {
        return supplierRepository.findAll();
    }

    /**
     * Add a supplier
     * @param supplier Supplier to add
     * @return Added Supplier
     */
    public Supplier addSupplier(Supplier supplier) {
        if (getSupplier(supplier.get_id()) == null) {
            return supplierRepository.save(supplier);
        }
        throw new SupplierException("The supplier is already existing", HttpStatus.NOT_FOUND);
    }

    /**
     * Edit a supplier
     * @param supplier Supplier to edit
     * @return Edited Supplier
     */
    public Supplier editSupplier(Supplier supplier) {
        Supplier supplierToEdit = getSupplier(supplier.get_id());
        return supplierRepository.save(supplierToEdit);
    }

    /**
     * Delete a supplier
     * @param _id Supplier id
     */
    public void deleteSupplier(ObjectId _id) {
        Supplier supplierToDelete = getSupplier(_id);
        if (supplierToDelete == null) {
            throw new SupplierException("The wanted supplier doesn't exist", HttpStatus.NOT_FOUND);
        }
        supplierRepository.delete(supplierToDelete);
    }

    /**
     * Get a supplier by id
     * @param _id Supplier id
     * @return Supplier
     */
    public Supplier getSupplier(ObjectId _id) {
        return supplierRepository.findBy_id(_id);
    }
}
