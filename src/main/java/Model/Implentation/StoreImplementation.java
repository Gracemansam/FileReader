package Model.Implentation;

import Model.Product;
import Model.Store;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StoreImplementation {
    private static ArrayList<Product> productList;

    private Store store= new Store();




    public StoreImplementation(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public StoreImplementation() {
        this.productList = new ArrayList<>();
    }


    public static  ArrayList<Product> getProductList() {
        return productList;
    }

    public void stockProduct(String path){
        try{
            BufferedReader fileLine = new BufferedReader(new FileReader(path));
            String fileData = "";
            fileLine.readLine();

            while ((fileData = fileLine.readLine()) != null){
                String [] productDataSplit = fileData.split(",");
                if (findProduct(productDataSplit[4]) < 0){
                    Product product = new Product();
                    product.setName(productDataSplit[4]);
                    product.setPrice(Double.parseDouble(productDataSplit[6]));
                    product.setQuantity(Integer.parseInt(productDataSplit[5]));
                    product.setCategory(productDataSplit[3]);
                    productList.add(product);
                }else {
                    int productIndex = findProduct(productDataSplit[4]);
                    Product product = this.productList.get(productIndex);
                    product.setQuantity(product.getQuantity() + Integer.parseInt(productDataSplit[5]));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int findProduct(String productName){
        for(Product product : this.getProductList()){
            if (productName.compareToIgnoreCase(product.getName()) == 0){
                return this.getProductList().indexOf(product);
            }
        }
        return -1;
    }



    public ArrayList productCategories(String category){
        /*
        productCategories return a list of productCategory.
        for each product in the productList, if the product category
        is equals to the category parameter, add the product into productCategory.
         */
        ArrayList<Product> productCategory = new ArrayList<>();
        for (Product eachProduct : this.getProductList()){
            if (eachProduct.getCategory().equalsIgnoreCase(category)){
                productCategory.add(eachProduct);
            }
        }
        return productCategory;
    }

    /*
    in searchProduct(), a string arrayList searchList was instantiated.
    for each product in productList, add eachProduct name to searchList.
    if searchList now contains product parameter, return true, else return false.
     */

    public void receipt(){
        System.out.println("Please, take your receipt");

    }

    @Override
    public String toString() {
        String content = "";
        for (Product product : productList){
            content = "Product : " + "\n" +
                    "category: " + product.getCategory() + "\n" +
                    "name: " + product.getName() + "\n" +
                    "quantity: " + product.getQuantity() + "\n" +
                    "price: " + product.getPrice() + "\n" ;

        }
        return content;
    }
}
