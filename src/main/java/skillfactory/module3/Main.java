package skillfactory.module3;

public class Main {

    public static void main(String[] args) {
        Bird bird1 = new Bird("name1", 20);
        Bird bird2 = new Bird("name1", 20);

        Bird bird3 = bird1;


        System.out.println(bird1.equals(bird2));

        System.out.println("Bird1 hash: " + bird1.hashCode()+" Bird2 hash "+ bird2.hashCode());

        System.out.println(bird1 == bird3);

        System.out.println(bird1);
    }
}
