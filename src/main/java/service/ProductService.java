package service;

import model.Product;
import repository.ProductRepository;
import validator.ProductValidator;

import java.util.List;

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

    public Product findByName(String name){
        return productRepository.findByName(name);
    }

    public List<Product> listAll(){
        return productRepository.listAll();
    }

    public void remove(String name){
        productRepository.removeByName(name);
    }

    public void update(String name, String futureName){
        productRepository.update(name.toUpperCase(), futureName.toUpperCase());
    }
}
