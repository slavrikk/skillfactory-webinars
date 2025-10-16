package skillfactory.patterns.strategy;

public class Route {

    private String routeInfo;

    public Route(String routeInfo) {
        this.routeInfo = routeInfo;
    }

    public void printInfo() {
        System.out.println("Маршрут: " + routeInfo);
    }
}
