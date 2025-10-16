package skillfactory.module2.polymorphism;

public class PayPalPayment implements PaymentMethod {
    @Override
    public boolean pay(double amount) {
        System.out.println("Перенаправляем на PayPal для оплаты " + amount + "...");
        return true;
    }
}