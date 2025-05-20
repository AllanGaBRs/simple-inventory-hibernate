package repository;

import model.Product;
import model.Supplier;
import util.JPAUtil;

import javax.persistence.EntityManager;
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
