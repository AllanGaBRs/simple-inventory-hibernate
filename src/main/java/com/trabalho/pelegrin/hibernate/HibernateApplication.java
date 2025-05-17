package com.trabalho.pelegrin.hibernate;

import db.CreateDB;
import model.Product;
import model.Supplier;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateApplication {

	public static void main(String[] args) {
		CreateDB.createDatabase();

		Supplier s = new Supplier();
		s.setName("allanss");

		Product p = new Product();
		p.setName("Banana");
		p.setPrice(10.0);
		p.setSupplier(s);
		s.addProduct(p);

		System.out.println(s.getProducts());

		EntityManager em = JPAUtil.getEntityManager();

		em.getTransaction().begin();
		em.persist(s);
		em.persist(p);
		em.getTransaction().commit();
		JPAUtil.close();
		System.out.println("commitado");

	}
}
