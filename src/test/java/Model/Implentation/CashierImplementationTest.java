package Model.Implentation;

import Model.Product;
import Model.Roles;
import Model.User;
import Model.Wallet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashierImplementationTest {

    private static StoreImplementation storeImplementation = new StoreImplementation();


    Product carrot;
    static Wallet wallet;
    Wallet wallet2;

    User customer1;
    User customer2;

    static String successfulMessage = "";

    String  unsuccessfulMessage;





    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        storeImplementation.getProductList();

        carrot = new Product("carrot", 5, 1.33, "Bars");
        wallet =new Wallet(20000.0);
        wallet2 =new Wallet(2.0);
        customer1 = new User(" sam", Roles.CASHIER);
        customer2 = new User(" sam", Roles.CUSTOMER);
        successfulMessage = "Dear "+ customer1.getName() + " Thank you for your patronage, We will like to see you again";
        unsuccessfulMessage = "Dear "+ customer1.getName() + ", "  + "We are sorry, Your sale is unsuccessful at the moment due to Insufficient fund or Product out of Stock";



    }

    @org.junit.jupiter.api.Test
    void TestForGoodCashierCanSellProduct() {
        assertEquals(unsuccessfulMessage,CashierImplementation.cashierCanSellProduct(customer1,"Cookies","Chocolate chip",3,wallet2));


    }
    @Test
    void TestForGoodCustomerBuyingProduct(){
        assertNotEquals(successfulMessage,CustomerImplentation.customerBuyingProduct(customer1,"Cookies","Chocolate chip",1,wallet));

    }


}