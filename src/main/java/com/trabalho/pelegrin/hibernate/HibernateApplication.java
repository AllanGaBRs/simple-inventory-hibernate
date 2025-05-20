package com.trabalho.pelegrin.hibernate;

import db.functions.CreateDB;
import model.Product;
import model.Supplier;
import repository.ProductRepository;
import repository.SupplierRepository;
import service.ProductService;
import service.SupplierService;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class HibernateApplication {

	public static void main(String[] args) {
		CreateDB.createDatabase();

		SupplierService supplierService = new SupplierService();
		ProductService productService = new ProductService();
		SupplierRepository supplierRepository = new SupplierRepository();

		Product p1 = new Product();
		p1.setName("Tvvsddasdjjja");
		p1.setPrice(10.0);
		p1.setSupplier(supplierRepository.findByName("eduardo"));
		productService.save(p1);

	}
}
