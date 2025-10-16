package skillfactory.module2;

public class Calculator {

    // Метод add для целых чисел
    public int add(int a, int b) {
        System.out.println("Вызвана версия для int");
        return a + b;
    }

    // ТО ЖЕ ИМЯ, но другие параметры (double)
    public double add(double a, double b) {
        System.out.println("Вызвана версия для double");
        return a + b;
    }

    // ТО ЖЕ ИМЯ, но другой тип и количество параметров
    public int add(int a, int b, int c) {
        System.out.println("Вызвана версия для трех int");
        return a + b + c;
    }
}
