package GuavaLearning;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @author limengtong
 * @date 2021/2/10 3:19 下午
 */
//callable 动态加载
// 如果key不存在可以保证多个线程启动只有一个call运行，缓存加载一次
public class CallabeCacheLearning {
    private static Cache<String, String> cache = CacheBuilder.newBuilder()
            .maximumSize(3)
            .build();

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            public void run() {
                System.out.println("thread1");
                try {
                    //如果没有key 则进行加载
                    String value = cache.get("key", new Callable<String>() {
                        public String call() throws Exception {
                            System.out.println("load1"); //加载数据线程执行标志
                            Thread.sleep(1000); //模拟加载时间
                            return "reloaded Value1:auto load by Callable";
                        }
                    });
                    System.out.println("thread1 " + value);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                System.out.println("thread2");
                try {
                    String value = cache.get("key", new Callable<String>() {
                        public String call() throws Exception {
                            System.out.println("load2"); //加载数据线程执行标志
                            Thread.sleep(1000); //模拟加载时间
                            return "reloaded Value2:auto load by Callable";
                        }
                    });
                    System.out.println("thread2 " + value);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
