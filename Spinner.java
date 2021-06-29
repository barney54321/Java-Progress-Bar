import java.util.concurrent.atomic.AtomicBoolean;

public class Spinner {

    private static String[] symbols = {"-", "\\", "|", "/"};

    private AtomicBoolean condition;

    private int waitTime;

    private int index;

    public Spinner(AtomicBoolean condition, int waitTime) {
        this.condition = condition;
        this.waitTime = waitTime;
        this.index = 0;
    }

    public Spinner(AtomicBoolean condition) {
        this(condition, 50);
    }

    public void run() {
        Thread thread = new Thread(() -> {
            while (this.condition.get()) {
                try {
                    System.out.print(" " + symbols[index] + "\r");
                    index++;
                    index = index % symbols.length;
                    Thread.sleep(this.waitTime);
                } catch (InterruptedException e) {
                    ;
                }
            }

            System.out.println("");
        });

        thread.start();
    }

}