package sfm.pontus;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
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
    public void saveStock(Stock stock) {
        entityManager.getTransaction().begin();
        entityManager.persist(stock);
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
    public List<Product> getProducts() {
        TypedQuery<Product> query=entityManager.createQuery("SELECT product FROM Product product",Product.class);
        List<Product> products =query.getResultList();
        return products;
    }

    @Override
    public void saveProducts(List<Product> products) {
        for (Product product:getProducts()){
            deleteProduct(product);//régi törlése
        }
        for (Product product:products){
            saveProduct(product);//új mentése
        }
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
