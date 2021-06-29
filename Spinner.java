import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Represents a simple terminal Spinner that prints at the given speed until 
 * stop() is called.
 */
public class Spinner {

    /**
     * The characters used in the spin animation.
     */
    private final String[] symbols = {"-", "\\", "|", "/"};

    /**
     * The boolean used to track whether to continue running.
     */
    private AtomicBoolean condition;

    /**
     * The time between symbol updates (in milliseconds).
     */
    private int waitTime;

    /**
     * The current index for the spin animation.
     */
    private int index;

    /**
     * Creates a new Spinner object that uses the provided time between frames.
     * 
     * @param waitTime The time between frames in the spin cycle.
     */
    public Spinner(int waitTime) {
        this.condition = new AtomicBoolean(true);
        this.waitTime = waitTime;
        this.index = 0;
    }

    /**
     * Creates a new Spinner object with 100milliseconds between frames.
     */
    public Spinner() {
        this(100);
    }

    /**
     * Begins the animation in a new thread.
     */
    public void run() {
        Thread thread = new Thread(() -> {
            while (this.condition.get()) {
                try {
                    System.out.print(" " + symbols[index] + "\r");
                    index = (index + 1) % symbols.length;
                    Thread.sleep(this.waitTime);
                } catch (InterruptedException e) {
                    ;
                }
            }
        });

        thread.start();
    }

    /**
     * Ends the animation thread.
     */
    public void stop() {
        this.condition.set(false);
    }

}