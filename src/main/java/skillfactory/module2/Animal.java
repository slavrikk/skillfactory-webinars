package skillfactory.module2;

public abstract class Animal implements Flyable{
    protected String name;
    protected int age;

    public Animal(String name) {
        this.name = name;
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Обычный метод с реализацией. Он будет одинаков для всех.
    public void sleep() {
        System.out.println("Zzz...");
    }

    public void print() {
        System.out.println("Name: " + name + " age: " + age);
    }

    // Абстрактный метод. БЕЗ ТЕЛА.
    // Мы говорим: "Каждое животное издает звук, но как именно -
    // пусть решает каждый конкретный наследник".
    public abstract void makeSound();

}
