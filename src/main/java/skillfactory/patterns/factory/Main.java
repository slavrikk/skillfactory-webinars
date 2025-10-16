package skillfactory.patterns.factory;

public class Main {

    public static void main(String[] args) {
        CoffeeShop coffeeShop = new CoffeeShop(new SimpleCoffeeFactory());

        Coffee coffee = coffeeShop.orderCoffee("cappuccino");

        System.out.println(coffee);
    }
}
