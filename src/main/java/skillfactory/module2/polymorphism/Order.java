package skillfactory.module2.polymorphism;

public class Order {

    private double total;

    public Order(double total) {
        this.total = total;
    }

    public double getTotalAmount() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
