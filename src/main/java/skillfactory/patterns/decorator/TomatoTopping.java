package skillfactory.patterns.decorator;

public class TomatoTopping extends ToppingDecorator {
    public TomatoTopping(Pizza pizza) { super(pizza); }
    public double getPrice() { return super.getPrice() + 50; } // + своя цена
    public String getDescription() { return super.getDescription() + ", томаты"; }
}
