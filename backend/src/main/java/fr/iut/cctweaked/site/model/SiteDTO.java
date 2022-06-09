package fr.iut.cctweaked.site.model;

import fr.iut.cctweaked.supplier.model.Supplier;
import org.bson.types.ObjectId;

import java.util.List;

public class SiteDTO {
    private ObjectId _id;
    private String name;
    private String owner;
    private List<Supplier> suppliers;

    public SiteDTO() {
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }
}
