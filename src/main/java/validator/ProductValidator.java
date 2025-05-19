package validator;

import exceptions.DuplicateException;
import model.Product;
import repository.ProductRepository;

import java.util.Optional;

public class ProductValidator {

    private final ProductRepository productRepository;

    public ProductValidator() {
        this.productRepository = new ProductRepository();
    }

    public void validate(Product product){
        if(existsProduct(product)){
            throw new DuplicateException("Produto já cadastrado");
        }
    }

    private boolean existsProduct(Product product){
       Optional<Product> optionalProduct = Optional.ofNullable(productRepository.findByName(product.getName()));
       if(product.getId() == null){
           return optionalProduct.isPresent();
       }
       return !product.getId().equals(optionalProduct.get().getId()) && optionalProduct.isPresent();
    }

}
