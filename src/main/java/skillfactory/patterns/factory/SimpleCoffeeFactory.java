package skillfactory.patterns.factory;

public class SimpleCoffeeFactory {
    public Coffee createCoffee(String type) {
        if ("americano".equals(type)) return new Americano();
        if ("cappuccino".equals(type)) return new Cappuccino();
        return null;
    }
}
