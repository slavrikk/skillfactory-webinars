package skillfactory.patterns.factory;

public class Cappuccino implements Coffee{
    @Override
    public void brew() {
        System.out.println("Brew Cappuccino coffee");

    }

    @Override
    public String toString() {
        return "Cappuccino coffee";
    }
}
