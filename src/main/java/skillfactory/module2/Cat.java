package skillfactory.module2;

public class Cat extends Animal{


    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Мяу");
    }

    @Override
    public void fly() {

    }

    @Override
    public void land() {

    }
}
