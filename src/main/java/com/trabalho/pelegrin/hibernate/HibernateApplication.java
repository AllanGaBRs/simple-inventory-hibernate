package com.trabalho.pelegrin.hibernate;

import db.functions.CreateDB;
import model.Product;
import repository.SupplierRepository;
import service.ProductService;
import service.SupplierService;

import java.util.Scanner;

public class HibernateApplication {

    public static void main(String[] args) {
        CreateDB.createDatabase();

        SupplierService supplierService = new SupplierService();
        ProductService productService = new ProductService();
        SupplierRepository supplierRepository = new SupplierRepository();

		/*
		Product p1 = new Product();
		p1.setName("geladeiraas");
		p1.setPrice(10.0);
		p1.setSupplier(supplierRepository.findByName("eduardo"));
		productService.save(p1);
		*/

        //productService.remove("tvv");
        //supplierService.remove("eduardo");

        supplierService.update("EDUARDO", "allan");
        productService.update("aaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaabbbbbbbbbbb");
    }
}
