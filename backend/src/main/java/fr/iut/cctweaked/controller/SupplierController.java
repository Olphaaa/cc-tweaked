package fr.iut.cctweaked.controller;

import fr.iut.cctweaked.config.SpringFoxConfig;
import fr.iut.cctweaked.exception.SupplierException;
import fr.iut.cctweaked.domain.Supplier;
import fr.iut.cctweaked.service.SupplierService;
import io.swagger.annotations.Api;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("supplier")
@Api(tags = {SpringFoxConfig.SUPPLIER_TAG})
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(final SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public ResponseEntity<List<Supplier>> getSuppliers() {
        try {
            return new ResponseEntity<>(supplierService.getSuppliers(), HttpStatus.OK);
        } catch (Exception e) {
            throw new SupplierException("Error while getting suppliers: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Supplier> getSupplier(@PathVariable String uuid) {
        try {
            return new ResponseEntity<>(supplierService.getSupplier(new ObjectId(uuid)), HttpStatus.OK);
        } catch (Exception e) {
            throw new SupplierException("Error while getting a supplier: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @PostMapping
    public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier) {
        try {
            return new ResponseEntity<>(supplierService.addSupplier(supplier), HttpStatus.OK);
        } catch (Exception e) {
            throw new SupplierException("Error while adding a supplier: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<Supplier> editSupplier(@PathVariable String uuid) {
        try {
            return new ResponseEntity<>(supplierService.editSupplier(new ObjectId(uuid)), HttpStatus.OK);
        } catch (Exception e) {
            throw new SupplierException("Error while editing a supplier: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @DeleteMapping("/{uuid}")
    public HttpStatus deleteSupplier(@PathVariable String uuid) {
        try {
            supplierService.deleteSupplier(new ObjectId(uuid));
            return HttpStatus.OK;
        } catch (Exception e) {
            throw new SupplierException("Error while deleting a supplier: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }
}
