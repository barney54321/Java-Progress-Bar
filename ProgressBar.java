import java.util.concurrent.atomic.*;

/**
 * Represents a simple terminal progress bar.
 */
public class ProgressBar {

    /**
     * The boolean used to track whether to continue running.
     */
    private AtomicBoolean condition;

    /**
     * Integer representation of the percentage progress.
     */
    private AtomicInteger progress;

    /**
     * Creates a new ProgressBar object that tracks the given percentage.
     * 
     * @param progress The progress of whatever is being observed (between 0 and 100).
     */
    public ProgressBar(AtomicInteger progress) {
        this.condition = new AtomicBoolean(true);
        this.progress = progress;
    }

    /**
     * Begins the animation in a new thread.
     */
    public void run() {
        Thread thread = new Thread(() -> {

            while (this.condition.get()) {

                String output = "|";

                int prog = this.progress.get();

                for (int i = 0; i < prog / 4; i++) {
                    output += "=";
                }

                for (int i = 0; i < 25 - prog / 4; i++) {
                    output += " ";
                }

                output += "|\r";

                System.out.print(output);

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    ;
                }
            }

            System.out.print("|=========================|");
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