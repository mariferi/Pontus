package sfm.pontus;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Stock {
    @Id
    private Integer id;

    private Set<Product> products;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    @OneToMany
    @JoinColumn(name="Stock_id")
    public  Set<Product> getProducts(){
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
