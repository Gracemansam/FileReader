package Model;

public class Wallet {

    private Double amount;


    public Wallet(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
        System.out.println("Wallet balance:$" + amount);
    }
}
