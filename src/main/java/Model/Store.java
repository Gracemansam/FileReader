package Model;

import java.util.List;

public class Store {
    private User user;

    private List<Product> productList;


    public Store(List<Product> productList, User user) {
        this.productList = productList;
        this.user = user;

    }

    public Store() {
    }

    public List<Product> getProductList() {
        return productList;
    }




}
