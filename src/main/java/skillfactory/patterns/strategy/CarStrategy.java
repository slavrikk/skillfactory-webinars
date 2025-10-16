package skillfactory.patterns.strategy;

public class CarStrategy implements RouteStrategy {
    @Override
    public Route buildRoute(Point a, Point b) {
        // Сложная логика расчета по дорогам...
        System.out.println("Строим маршрут для автомобиля...");
        return new Route("Дорога от " + a + " до " + b + " займет 20 минут.");
    }
}
