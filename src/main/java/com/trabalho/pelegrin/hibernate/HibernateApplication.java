package com.trabalho.pelegrin.hibernate;

import db.CreateDB;
import model.Product;
import model.Supplier;
import repository.ProductRepository;
import repository.SupplierRepository;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class HibernateApplication {

	public static void main(String[] args) {
		CreateDB.createDatabase();

		SupplierRepository supplierRepository = new SupplierRepository();
		ProductRepository productRepository = new ProductRepository();

		List<Product> products = productRepository.listAll();
		List<Supplier> suppliers = supplierRepository.listAll();
		suppliers.forEach(System.out::println);
		products.forEach(System.out::println);

	}
}
