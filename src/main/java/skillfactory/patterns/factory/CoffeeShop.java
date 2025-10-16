package skillfactory.patterns.factory;

public class CoffeeShop {
    private final SimpleCoffeeFactory coffeeFactory;

    public CoffeeShop(SimpleCoffeeFactory factory) {
        this.coffeeFactory = factory;
    }

    public Coffee orderCoffee(String type) {
        Coffee coffee = coffeeFactory.createCoffee(type); // Делегируем создание!
        if (coffee != null) {
            coffee.brew();
        }
        return coffee;
    }
}
