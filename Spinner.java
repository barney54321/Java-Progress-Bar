import java.util.concurrent.atomic.AtomicBoolean;

public class Spinner {

    private static String[] symbols = {"-", "\\", "|", "/"};

    private AtomicBoolean condition;

    private int speed;

    private int index;

    public Spinner(int speed) {
        this.condition = new AtomicBoolean(true);
        this.speed = speed;
        this.index = 0;
    }

    public Spinner() {
        this(100);
    }

    public void run() {
        Thread thread = new Thread(() -> {
            while (this.condition.get()) {
                try {
                    System.out.print(" " + symbols[index] + "\r");
                    index++;
                    index = index % symbols.length;
                    Thread.sleep(this.speed);
                } catch (InterruptedException e) {
                    ;
                }
            }

            System.out.println("");
        });

        thread.start();
    }

    public void stop() {
        this.condition.set(false);
    }

}