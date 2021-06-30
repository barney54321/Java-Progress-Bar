import java.util.concurrent.atomic.*;

public class Test {
    public static void main(String[] args) {

        Spinner s = new Spinner();

        s.run();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            ;
        }

        s.stop();

        AtomicInteger progress = new AtomicInteger(0);

        ProgressBar bar = new ProgressBar(progress);

        bar.run();

        try {
            for (int i = 0; i < 100; i++) {
                progress.getAndSet(i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            ;
        }

        bar.stop();
    }
}