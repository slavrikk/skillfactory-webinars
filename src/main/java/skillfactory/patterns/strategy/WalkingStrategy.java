package skillfactory.patterns.strategy;

public class WalkingStrategy implements RouteStrategy {
    @Override
    public Route buildRoute(Point a, Point b) {
        // Сложная логика расчета по тропинкам...
        System.out.println("Прокладываем пеший маршрут...");
        return new Route("Прогулка от " + a + " до " + b + " займет 1 час.");
    }
}
