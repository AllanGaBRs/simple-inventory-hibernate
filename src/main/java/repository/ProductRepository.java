package repository;

import model.Product;
import model.Supplier;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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

    public Product findByName(String name){
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                            "SELECT p FROM Product p WHERE p.name = :name", Product.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}
