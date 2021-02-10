package GuavaLearning;


import com.google.common.util.concurrent.*;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author limengtong
 * @date 2021/2/10 4:09 下午
 */
public class ThreadStudy {
    public static void main(String args[]){
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
        final ListenableFuture<Integer> listenableFuture = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("call execute..");
                TimeUnit.SECONDS.sleep(1);
                return 7;
            }
        });
        Futures.addCallback(listenableFuture, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(Integer result) {
                System.out.println("get listenable future's result with callback " + result);
                executorService.shutdown();
                return;
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
                return;
            }
        },executorService);
    }
}
