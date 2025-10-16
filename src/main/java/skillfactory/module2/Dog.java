package skillfactory.module2;

public class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Гаф!");
    }

    @Override
    public void fly() {
        System.out.println(name + " is flying");
    }

    @Override
    public void land() {

    }

}
