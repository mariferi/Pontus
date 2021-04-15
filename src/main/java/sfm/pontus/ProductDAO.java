package sfm.pontus;

import java.util.List;

public interface ProductDAO extends AutoCloseable{
    public void saveProduct (Product product);
    public void saveStock(Stock stock);
    public void deleteProduct (Product product);
    public void updateProduct (Product product);
    public List<Product> getProducts();
}
