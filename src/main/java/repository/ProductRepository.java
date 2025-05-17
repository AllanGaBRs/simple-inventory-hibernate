package repository;

import model.Product;
import model.Supplier;
import util.JPAUtil;

import javax.persistence.EntityManager;
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

}
