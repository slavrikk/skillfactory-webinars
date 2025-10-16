package skillfactory.module2.polymorphism;

public class OrderProcessor {

    public void processOrder(Order order, PaymentMethod paymentMethod) {
        double total = order.getTotalAmount();

        if (paymentMethod.pay(total)) {
            System.out.println("Заказ успешно оплачен!");
        }
    }
}
