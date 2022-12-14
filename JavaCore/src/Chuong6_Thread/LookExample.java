package Chuong6_Thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LookExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool(4);
        CallableSample sample = new CallableSample();
        List<CallableSample> callables = Arrays.asList(sample, sample, sample, sample);

        executor.invokeAll(callables);
    }
}
