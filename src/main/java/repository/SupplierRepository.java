package repository;

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
}
