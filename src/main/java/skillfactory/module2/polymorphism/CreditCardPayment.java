package skillfactory.module2.polymorphism;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public boolean pay(double amount) {
        System.out.println("Проводим транзакцию на " + amount + " через банковский шлюз...");
        return true; // Логика успешной оплаты
    }
}