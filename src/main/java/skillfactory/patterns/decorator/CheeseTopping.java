package skillfactory.patterns.decorator;

public class CheeseTopping extends ToppingDecorator {
    public CheeseTopping(Pizza pizza) { super(pizza); }
    public double getPrice() { return super.getPrice() + 80; } // + своя цена
    public String getDescription() { return super.getDescription() + ", сыр"; }
}
