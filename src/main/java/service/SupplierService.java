package service;

import model.Supplier;
import repository.SupplierRepository;
import validator.SupplierValidator;

import java.util.List;

public class SupplierService {

    private final SupplierRepository supplierRepository;
    private final SupplierValidator supplierValidator;

    public SupplierService() {
        this.supplierRepository = new SupplierRepository();
        this.supplierValidator = new SupplierValidator();
    }

    public void save(Supplier supplier) {
        supplierValidator.validate(supplier);
        supplierRepository.save(supplier);
    }

    public Supplier findByName(String name) {
        return supplierRepository.findByName(name);
    }
    
    public List<Supplier> listAll(){
        return supplierRepository.listAll();
    }

    public void remove(String name){
        supplierRepository.remove(name);
    }

    public void update(String name, String futureName){
        supplierRepository.update(name, futureName);
    }

}
