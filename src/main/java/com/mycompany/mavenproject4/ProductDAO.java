package com.mycompany.mavenproject4;

import java.util.List;

public interface ProductDAO extends AutoCloseable{
    public void saveProduct (Product product);
    public void deleteProduct (Product product);
    public void updateProduct (Product product);
    public List<Product> getProductsAll();
    public List<Product> getProductsbyName(String name);
    public Product getProductbyID(int id);
}
