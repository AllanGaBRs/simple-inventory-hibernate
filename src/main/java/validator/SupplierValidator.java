package validator;

import exceptions.DuplicateException;
import model.Product;
import model.Supplier;
import repository.ProductRepository;
import repository.SupplierRepository;

import java.util.Optional;

public class SupplierValidator {

    private final SupplierRepository supplierRepository;

    public SupplierValidator() {
        this.supplierRepository = new SupplierRepository();
    }

    public void validate(Supplier supplier){
        if(existsSupplier(supplier)){
            throw new DuplicateException("Fornecedor " + supplier.getName() + " já cadastrado");
        }
    }

    private boolean existsSupplier(Supplier supplier){
        Optional<Supplier> optionalSupplier = Optional.ofNullable(supplierRepository.findByName(supplier.getName()));
        if(supplier.getId() == null){
            return optionalSupplier.isPresent();
        }
        return !supplier.getId().equals(optionalSupplier.get().getId()) && optionalSupplier.isPresent();
    }

}
