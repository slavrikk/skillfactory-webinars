package skillfactory.patterns.strategy;

public class Main {

    public static void main(String[] args) {

        Navigator navigator = new Navigator();
        Point home = new Point(0, 0);
        Point work = new Point(10, 5);

        // --- Сценарий 1: Едем на машине ---
        navigator.setRouteStrategy(new CarStrategy());
        Route carRoute = navigator.buildRoute(home, work);
        carRoute.printInfo();
        // Вывод:
        // Строим маршрут для автомобиля...
        // Маршрут: Дорога от (0, 0) до (10, 5) займет 20 минут.

        System.out.println("--------------------");

        // --- Сценарий 2: Идем пешком ---
        navigator.setRouteStrategy(new WalkingStrategy());
        Route walkingRoute = navigator.buildRoute(home, work);
        walkingRoute.printInfo();
        // Вывод:
        // Прокладываем пеший маршрут...
        // Маршрут: Прогулка от (0, 0) до (10, 5) займет 1 час.
    }
}
