package fr.iut.cctweaked.controller;

import fr.iut.cctweaked.config.SpringFoxConfig;
import fr.iut.cctweaked.dto.SupplierDTO;
import fr.iut.cctweaked.domain.Supplier;
import fr.iut.cctweaked.service.SupplierService;
import fr.iut.cctweaked.utils.mapper.SupplierMapper;
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

    /**
     * Get all suppliers
     * @return List of suppliers
     */
    @GetMapping
    public ResponseEntity<List<SupplierDTO>> getSuppliers() {
        return new ResponseEntity<>(SupplierMapper.supplierListToSupplierDTOList(supplierService.getAll()), HttpStatus.OK);
    }

    /**
     * Get supplier by id
     * @param id Supplier id
     * @return Supplier
     */
    @GetMapping("/{id}")
    public ResponseEntity<SupplierDTO> getSupplier(@PathVariable String id) {
        return new ResponseEntity<>(SupplierMapper.supplierToSupplierDTO(supplierService.getSupplier(new ObjectId(id))), HttpStatus.OK);
    }

    /**
     * Add a supplier
     * @param supplier Supplier to add
     * @return Added Supplier
     */
    @PostMapping
    public ResponseEntity<SupplierDTO> addSupplier(@RequestBody SupplierDTO supplier) {
        return new ResponseEntity<>(SupplierMapper.supplierToSupplierDTO(supplierService.addSupplier(SupplierMapper.supplierDTOToSupplier(supplier))), HttpStatus.OK);
    }

    /**
     * Update a supplier
     * @param supplier Supplier to update
     * @return Edited supplier
     */
    @PutMapping
    public ResponseEntity<SupplierDTO> editSupplier(@RequestBody Supplier supplier) {
        return new ResponseEntity<>(SupplierMapper.supplierToSupplierDTO(supplierService.editSupplier(supplier)), HttpStatus.OK);
    }

    /**
     * Delete a supplier
     * @param id Supplier id
     * @return HttpStatus code
     */
    @DeleteMapping("/{id}")
    public HttpStatus deleteSupplier(@PathVariable String id) {
        supplierService.deleteSupplier(new ObjectId(id));
        return HttpStatus.OK;
    }
}
