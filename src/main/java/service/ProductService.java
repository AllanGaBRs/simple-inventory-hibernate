package service;

import model.Product;
import repository.ProductRepository;
import validator.ProductValidator;

public class ProductService {

    private final ProductRepository productRepository;
    private final ProductValidator productValidator;

    public ProductService() {
        this.productRepository = new ProductRepository();
        this.productValidator = new ProductValidator();
    }

    public void save(Product product){
        productValidator.validate(product);
        productRepository.save(product);
    }
}
