package skillfactory.patterns.strategy;

public class Navigator {
    private RouteStrategy routeStrategy;

    public void setRouteStrategy(RouteStrategy strategy) {
        this.routeStrategy = strategy;
    }

    public Route buildRoute(Point a, Point b) {
        // Просто делегируем работу текущей стратегии
        if (routeStrategy == null) {
            System.out.println("Стратегия не выбрана!");
            return null;
        }
        return routeStrategy.buildRoute(a, b);
    }
}
