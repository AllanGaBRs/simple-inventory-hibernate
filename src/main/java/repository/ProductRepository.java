package repository;

import exceptions.ConstraintKeyException;
import model.Product;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.TransactionalException;
import java.util.List;

public class ProductRepository {

    public void save(Product product) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
        em.close();
    }

    public List<Product> listAll() {
        EntityManager em = JPAUtil.getEntityManager();
        return em
                .createQuery("from Product", Product.class)
                .getResultList();
    }

    public void removeByName(String name) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.createQuery("DELETE FROM Product p WHERE p.name = :name")
                    .setParameter("name", name)
                    .executeUpdate();
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            throw new TransactionalException("Erro na exclusão", e.getCause());
        } finally {
            em.close();
        }
    }

    public void update(String name, String futureName) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.createQuery("UPDATE Product " +
                            "SET name = :futureName " +
                            "WHERE name = :name")
                    .setParameter("futureName", futureName)
                    .setParameter("name", name)
                    .executeUpdate();
            et.commit();
        } catch (RuntimeException e) {
            if (et.isActive()) {
                et.rollback();
            }
            throw new ConstraintKeyException(
                    "Erro na atualização!!!"
            );
        } finally {
            em.close();
        }
    }

    public Product findByName(String name) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                            "SELECT p FROM Product p WHERE p.name = :name", Product.class)
                    .setParameter("name", name)
                    .getResultStream()
                    .findFirst()
                    .orElse(null);
        } finally {
            em.close();
        }
    }
}
