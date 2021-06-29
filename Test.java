import java.util.concurrent.atomic.AtomicBoolean;

public class Test {
    public static void main(String[] args) {

        AtomicBoolean condition = new AtomicBoolean(true);

        Spinner s = new Spinner(condition);

        s.run();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            ;
        }

        condition.set(false);
    }
}