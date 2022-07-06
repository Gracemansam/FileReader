package Model;

public class User {

    private String name;
    private Roles role;
    private Wallet wallet;


    // to create manager, cashier
    public User(String name, Roles role) {
        this.name = name;
        this.role = role;

    }



    // methods
    public String getName() {
        return name;
    }


    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
        //return role;
    }


    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(double amount) {
        wallet.setAmount(amount) ;
    }
}


