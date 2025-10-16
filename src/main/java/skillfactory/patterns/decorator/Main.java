package skillfactory.patterns.decorator;

public class Main {

    public static void main(String[] args) {

        // Создаем базовую пиццу
        Pizza myPizza = new PizzaBase();
        System.out.println(myPizza.getDescription() + " - " + myPizza.getPrice() + " руб.");
        // > Основа для пиццы - 200.0 руб.

        // "Оборачиваем" ее в сыр (добавляем топпинг)
        myPizza = new CheeseTopping(myPizza);
        System.out.println(myPizza.getDescription() + " - " + myPizza.getPrice() + " руб.");
        // > Основа для пиццы, сыр - 280.0 руб.

        // "Оборачиваем" еще и в томаты!
        myPizza = new TomatoTopping(myPizza);
        System.out.println(myPizza.getDescription() + " - " + myPizza.getPrice() + " руб.");
        // > Основа для пиццы, сыр, томаты - 330.0 руб.
    }
}
