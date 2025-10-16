package skillfactory.patterns.decorator;

public class PizzaBase implements Pizza {
    public double getPrice() {
        return 200;
    } // Цена за основу

    public String getDescription() {
        return "Основа для пиццы";
    }
}
