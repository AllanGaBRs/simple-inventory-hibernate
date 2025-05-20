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

		Supplier s1 = new Supplier();
		s1.setName("eduardo");

		Product p1 = new Product();
		p1.setName("Tvvsddasdjjja");
		p1.setPrice(10.0);
		p1.setSupplier(s1);
		productService.save(p1);

	}
}
