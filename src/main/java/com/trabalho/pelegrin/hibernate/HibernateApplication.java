package com.trabalho.pelegrin.hibernate;

import db.CreateDB;
import model.Product;
import model.Supplier;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateApplication {

	public static void main(String[] args) {
		CreateDB.createDatabase();

		Supplier s = new Supplier();
		s.setName("allan");

		Product p = new Product();
		p.setName("Maça");
		p.setPrice(10.0);
		p.setSupplier(s);
		s.addProduct(p);

		System.out.println(s.getProducts());

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TRABALHO_HIBERNATE");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(s);
		em.persist(p);
		em.getTransaction().commit();
		System.out.println("commitado");

	}
}
