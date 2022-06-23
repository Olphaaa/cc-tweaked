package fr.iut.cctweaked.service;

import fr.iut.cctweaked.exception.AlreadyExistingException;
import fr.iut.cctweaked.exception.NotFoundException;
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
    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    /**
     * Add a supplier
     * @param supplier Supplier to add
     * @return Added Supplier
     */
    public Supplier addSupplier(Supplier supplier) {
       return supplierRepository.save(supplier);
    }

    /**
     * Edit a supplier
     * @param supplier Supplier to edit
     * @return Edited Supplier
     */
    public Supplier editSupplier(Supplier supplier) {
        return supplierRepository.save(getSupplier(supplier.get_id()));
    }

    /**
     * Delete a supplier
     * @param _id Supplier id
     */
    public void deleteSupplier(ObjectId _id) {
        Supplier supplierToDelete = supplierRepository.findById(_id).orElseThrow(() -> new NotFoundException("The supplier is not existing"));
        supplierRepository.delete(supplierToDelete);
    }

    /**
     * Get a supplier by id
     * @param _id Supplier id
     * @return Supplier
     */
    public Supplier getSupplier(ObjectId _id) {
        return supplierRepository.findById(_id).orElseThrow(() -> new NotFoundException("The supplier is not existing"));
    }
}
