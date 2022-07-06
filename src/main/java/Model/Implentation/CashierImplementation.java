package Model.Implentation;

import Model.Product;
import Model.Roles;
import Model.User;
import Model.Wallet;

import java.util.List;

public class CashierImplementation extends User {
    static List<Product> AllStoreProduct = StoreImplementation.getProductList();

    public CashierImplementation(String name, Roles role) {
        super(name, role);
    }

    static String successfulMessage = "";
    static String unsuccessfulMessage = "";
    static String notACashier = " ";
    public static String cashierCanSellProduct(User user, String category,String productName,int quantity, Wallet wallet){
        if(user.getRole() == Roles.CASHIER){
            for (Product p : AllStoreProduct){
                if ( p.getCategory().equalsIgnoreCase(category) && p.getName().equalsIgnoreCase(productName) &&
                        wallet.getAmount() >= (p.getPrice() * quantity) && p.getQuantity() >= quantity){
                    int newQuantity = p.getQuantity() - quantity;
                    p.setQuantity(newQuantity);

                    return successfulMessage = "Dear "+ user.getName() + " Thank you for your patronage, We will like to see you again";

                }

            }

            return unsuccessfulMessage = "Dear "+ user.getName() + ", "  + "We are sorry, Your sale is unsuccessful at the moment due to Insufficient fund or Product out of Stock";

        }
        return  notACashier =" Unauthorized";

    }
}
