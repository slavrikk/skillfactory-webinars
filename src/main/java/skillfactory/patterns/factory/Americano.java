package skillfactory.patterns.factory;

public class Americano implements Coffee{
    @Override
    public void brew() {
        System.out.println("Brew Americano coffee");
    }

    @Override
    public String toString() {
        return "Americano coffee";
    }
}
