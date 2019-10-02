package reactive;

import java.util.concurrent.*;

public class ParallelDataLoader extends DataLoader {

    @Override
    protected void loadAll() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletionService<Object> completionService = new ExecutorCompletionService<>(executorService);
        try {
            completionService.submit(super::loadA, null).get();
            completionService.submit(super::loadB, null).get();
            completionService.submit(super::loadC, null).get();
            executorService.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
