package Model.Implentation;

import Model.Implentation.*;
import Model.Product;
import Model.Roles;
import Model.User;
import Model.Wallet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CustomerImplentationTest {
    private static StoreImplementation storeImplementation = new StoreImplementation();


    Product carrot;
    static Wallet wallet;
    Wallet wallet2;

    User customer1;
    User customer2;

    static String successfulMessage = "";

    String  unsuccessfulMessage;




    @BeforeEach
    void setUp() {
      storeImplementation.getProductList();

          carrot = new Product("carrot", 5, 1.33, "Bars");
          wallet =new Wallet(20000.0);
          wallet2 =new Wallet(2.0);
          customer1 = new User(" sam", Roles.CUSTOMER);
          customer2 = new User(" sam", Roles.CUSTOMER);
          successfulMessage = "Dear, "+ customer1.getName() + " Your sales is successful";
       unsuccessfulMessage = "Dear "+ customer1.getName() + ", "  + "We do not sell that product at the moment or your fund is Insufficient or Maybe Product out of Stock";






    }


    @Test
    void TestForBadCustomerBuyingProduct() {
        assertEquals(unsuccessfulMessage,CustomerImplentation.customerBuyingProduct(customer1,"Cookies","Chocolate chip",1,wallet2));
    }

    @Test
    void TestForGoodCustomerBuyingProduct(){
        assertNotEquals(successfulMessage,CustomerImplentation.customerBuyingProduct(customer1,"Cookies","Chocolate chip",1,wallet));

    }
}