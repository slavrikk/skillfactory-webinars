package skillfactory.module4;

public class Main {

    public static void main(String[] args) {
        TVset tVset = new TVset();
        TVset.Remote myRemote = tVset.new Remote();
        myRemote.turnOn();
    }
}
