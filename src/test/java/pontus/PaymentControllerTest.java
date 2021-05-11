package pontus;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PaymentControllerTest {

    @Test
    public void cartSumTest() {
        List<Product> products = new ArrayList<>();
        Product test1=new Product("001","Alma","Közepes","Gyümi",new BigDecimal(10));
        products.add(test1);
        Product test2=new Product("002","Körte","Közepes","Gyümi",new BigDecimal(15));
        products.add(test2);

        Float expected=Float.parseFloat( 25+"");
        Float got=PaymentController.cartSum(products);
        Assert.assertEquals(got,expected);
    }
}