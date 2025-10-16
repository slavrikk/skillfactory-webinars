package skillfactory.module2.polymorphism;

public class Main {

    public static void main(String[] args) {
        Order order = new Order(10);

        OrderProcessor orderProcessor = new OrderProcessor();
        PaymentMethod creditCardPayment = new CreditCardPayment();

        orderProcessor.processOrder(order, creditCardPayment);

        PaymentMethod payPalPayment = new PayPalPayment();
        orderProcessor.processOrder(order, payPalPayment);

    }
}
