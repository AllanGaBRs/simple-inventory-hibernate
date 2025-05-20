package service;

import model.Supplier;
import repository.SupplierRepository;
import validator.SupplierValidator;

public class SupplierService {

    private final SupplierRepository supplierRepository;
    private final SupplierValidator supplierValidator;

    public SupplierService() {
        this.supplierRepository = new SupplierRepository();
        this.supplierValidator = new SupplierValidator();
    }

    public void save(Supplier supplier){
        supplierValidator.validate(supplier);
        supplierRepository.save(supplier);
    }

}
