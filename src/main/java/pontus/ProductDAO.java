package pontus;

import java.util.List;

public interface ProductDAO extends AutoCloseable{
    public void saveProduct (Product product);
    public void deleteProduct (Product product);
    public void updateProduct (Product product);
    public List<Product> getProductsAll();
    public List<Product> getProductsbyName(String name);
    public List<Product> getProductsbyCategory(String category);
    public Product getProductbyID(int id);
}
