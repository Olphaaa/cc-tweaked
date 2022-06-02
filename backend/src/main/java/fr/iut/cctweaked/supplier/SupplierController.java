package fr.iut.cctweaked.supplier;

import fr.iut.cctweaked.supplier.model.Supplier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("supplier")
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
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Supplier> getSupplier(@PathVariable String uuid) {
        try {
            return new ResponseEntity<>(supplierService.getSupplier(uuid), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping
    public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier) {
        try {
            return new ResponseEntity<>(supplierService.addSupplier(supplier), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping
    public ResponseEntity<Supplier> editSupplier() {
        try {
            return new ResponseEntity<>(supplierService.editSupplier(), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping
    public ResponseEntity<Supplier> deleteSupplier() {
        try {
            return new ResponseEntity<>(supplierService.deleteSupplier(), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
