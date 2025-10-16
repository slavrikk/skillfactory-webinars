package skillfactory.patterns.decorator;

public class ToppingDecorator implements Pizza {
    protected Pizza decoratedPizza;
    public ToppingDecorator(Pizza pizza) { this.decoratedPizza = pizza; }
    public double getPrice() { return decoratedPizza.getPrice(); } // Делегируем
    public String getDescription() { return decoratedPizza.getDescription(); }
}
