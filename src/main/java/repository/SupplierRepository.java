package repository;

import exceptions.ConstraintKeyException;
import model.Product;
import model.Supplier;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.TransactionalException;
import java.util.List;

public class SupplierRepository {

    public void save(Supplier supplier) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(supplier);
        em.getTransaction().commit();
        em.close();
    }

    public List<Supplier> listAll() {
        EntityManager em = JPAUtil.getEntityManager();
        return em
                .createQuery("from Supplier", Supplier.class)
                .getResultList();
    }

    public void remove(String name) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.createQuery("DELETE FROM Supplier s WHERE s.name = :name")
                    .setParameter("name", name)
                    .executeUpdate();
            et.commit();
        } catch (RuntimeException e) {
            if (et.isActive()) {
                et.rollback();
            }
            throw new ConstraintKeyException(
                    "Erro na exclusão, Certifique-se de que o fornecedor não possui produtos cadastrados!!!"
            );
        } finally {
            em.close();
        }
    }

    public void update(String name, String futureName) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.createQuery("UPDATE Supplier " +
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

    public Supplier findByName(String name) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                            "SELECT s FROM Supplier s WHERE s.name = :name", Supplier.class)
                    .setParameter("name", name)
                    .getResultStream()
                    .findFirst()
                    .orElse(null);
        } finally {
            em.close();
        }
    }
}
