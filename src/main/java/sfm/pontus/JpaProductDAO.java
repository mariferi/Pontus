package sfm.pontus;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class JpaProductDAO implements ProductDAO {

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void saveProduct(Product product) {
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }


    @Override
    public void deleteProduct(Product product) {
        entityManager.getTransaction().begin();
        entityManager.remove(product);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateProduct(Product product) {
    saveProduct(product);
    }

    @Override
    public List<Product> getProductsAll() {
        String sqlstr="SELECT product FROM Product product";
        TypedQuery<Product> query=entityManager.createQuery(sqlstr,Product.class);
        return query.getResultList();
    }

    @Override
    public List<Product> getProductsbyName(String name) {
        String sqlstr="SELECT product FROM Product product WHERE NAME="+"'"+name+"'";
        TypedQuery<Product> query=entityManager.createQuery(sqlstr,Product.class);
        return query.getResultList();
    }


    @Override
    public Product getProductbyID(int id){
        String sqlstr="SELECT product FROM Product product WHERE ID="+id;
        TypedQuery<Product> query=entityManager.createQuery(sqlstr,Product.class);
        return query.getSingleResult();
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
