import java.util.concurrent.atomic.AtomicBoolean;

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
    }
}