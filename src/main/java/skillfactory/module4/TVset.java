package skillfactory.module4;

public class TVset {
    private boolean isOn;

    private int channel;

    // Внутренний класс! Он "видит" все поля TVset.
    public class Remote {

        public void turnOn() {
            // Прямой доступ к private-полям!
            isOn = true;
        }
        public void setChannel(int channel) {
            // Если имена совпадают, используем Outer.this
            TVset.this.channel = channel;
        }
    }
}
