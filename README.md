# Java Progress Bar

Simple to use Progress Bar and Spinner classes for Java that print progress to the terminal.

## Usage

Simply copy the code for the relevant class into your directory and use as follows:

### Spinner

```java
Spinner s = new Spinner();

s.run();

// Time intensive work here

s.stop();
```

### Progress Bar

```java
// Create integer to store progress (as a percentage)
AtomicInteger progress = new AtomicInteger(0);

ProgressBar bar = new ProgressBar(progress);

bar.run();

try {
    for (int i = 0; i < 100; i++) {
        // Update the progress as necessary
        progress.getAndSet(i);
        Thread.sleep(100);
    }
} catch (InterruptedException e) {
    ;
}

bar.stop();
```