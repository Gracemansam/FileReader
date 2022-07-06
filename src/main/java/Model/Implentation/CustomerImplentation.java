package Model.Implentation;

import Model.Product;
import Model.Roles;
import Model.User;
import Model.Wallet;

import java.util.List;

public class CustomerImplentation extends User {
    static List<Product> AllStoreProduct = StoreImplementation.getProductList();

    public CustomerImplentation(String name, Roles role, List<Product> allStoreProduct) {
        super(name, role);
        AllStoreProduct = allStoreProduct;
    }

    static String successfulMessage = "";
    static String unsuccessfulMessage = "";
    static String notACustomer = " ";
    public static String customerBuyingProduct(User user, String category, String productName, int quantity, Wallet wallet){
        if(user.getRole() == Roles.CUSTOMER){
            for (Product p : StoreImplementation.getProductList()){

                if ( p.getCategory().equalsIgnoreCase(category) && p.getName().equalsIgnoreCase(productName) &&
                        wallet.getAmount() >= (p.getPrice() * quantity) && p.getQuantity() >= quantity){
                    int newQuantity = p.getQuantity() - quantity;
                    p.setQuantity(newQuantity);
                    double newWallet = wallet.getAmount()- p.getPrice()* quantity;
                    wallet.setAmount(newWallet);
                    return successfulMessage =  "Dear, "+ user.getName() + " Your sales is successful";

                }

            }

            return unsuccessfulMessage = "Dear "+ user.getName() + ", "  + "We do not sell that product at the moment or your fund is Insufficient or Maybe Product out of Stock";

        }
        return  notACustomer =" You are not a Customer,Switch to our customer role to use this feature";

    }


}


