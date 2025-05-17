package com.trabalho.pelegrin.hibernate;

import db.CreateDB;
import model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateApplication {

	public static void main(String[] args) {
		CreateDB.createDatabase();
		Person p = new Person();
		p.setName("allanfdb");
		p.setEmail("allan@gmail");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TRABALHO_HIBERNATE");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		System.out.println("commitado");

	}
}
