package skillfactory.module2;

public class Fish extends Animal {
    public Fish(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Бульк");
    }

    @Override
    public void fly() {

    }

    @Override
    public void land() {

    }

    void defaultMethod() {
        System.out.println("Default");
    }

}
