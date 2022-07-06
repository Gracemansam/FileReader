package Model;

import Model.Implentation.CustomerImplentation;
import Model.Implentation.StoreImplementation;

import java.io.IOException;

public class Main {

    StoreImplementation storeImplementation = new StoreImplementation();
    public static void main(String[] args) throws IOException {



        Product product = new Product();
        StoreImplementation store = new StoreImplementation();
        String path = "/Users/admin/IdeaProjects/GracemanWeek2/FoodData/ FoodSales.csv";
        try {
            store.stockProduct(path);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        showproduct();

        System.out.println("----------------------------------------------------------------");
//
        // System.out.println(store.productCategories("Cookies"));
        // System.out.println(store.findProduct("whole wheat"));
        Product carrot = new Product("carrot", 123, 1.33, "Bars");
        Wallet wallet =new Wallet(20000.0);
        User customer1 = new User(" sam",Roles.CUSTOMER);
        System.out.println(CustomerImplentation.customerBuyingProduct(customer1,"Cookies","Chocolate chip",9,wallet));
       // System.out.println(StoreImplementation.getProductList());




    }



    public static void showproduct() throws IOException {
        System.out.printf("%-20s%-20s%-20s","PRODUCT CATEGORY", "PRODUCT NAME","PRODUCT QUANTITY");
        System.out.println();
        System.out.println("----------------------------------------------------------------");
        for(Product p:StoreImplementation.getProductList()){
            System.out.printf("%-20s%-20s%-20d",p.getCategory() , p.getName(),p.getQuantity());
            System.out.println();
        }
    }
    }
