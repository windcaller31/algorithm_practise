package GuavaLearning;

import com.google.common.cache.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author limengtong
 * @date 2021/2/9 6:16 下午
 */
public class CacheLearning {
    public static void main(String args[]) {
        Cache<String, String> cache = CacheBuilder.newBuilder().build();
        cache.put("word", "Hello Guava Cache");
        System.out.println(cache.getIfPresent("word"));

        LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder()
                .build(
                        new CacheLoader<String, String>() {
                            @Override
                            public String load(String s) throws Exception {
                                return null;
                            }
                        }
                );

        Cache<String, String> cache2 = CacheBuilder.newBuilder()
                .maximumSize(2)
                .build();
        cache2.put("key1", "value1");
        cache2.put("key2", "value2");
        cache2.put("key3", "value3");
        System.out.println("第一个值：" + cache2.getIfPresent("key1"));
        System.out.println("第二个值：" + cache2.getIfPresent("key2"));
        System.out.println("第三个值：" + cache2.getIfPresent("key3"));

        //弱引用
        Cache<String, Object> weakCache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .weakValues()
                .build();
        Object value = new Object();
        weakCache.put("key1", value);

        value = new Object();//原对象不再有强引用
        System.gc();
        System.out.println(weakCache.getIfPresent("key1"));

        // 批量清除
        Cache<String, String> removeCache = CacheBuilder.newBuilder().build();
        Object removeValue = new Object();
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");

        List<String> list = new ArrayList<String>();
        list.add("key1");
        list.add("key2");

        cache.invalidateAll(list);//批量清除list中全部key对应的记录
        System.out.println(cache.getIfPresent("key1"));
        System.out.println(cache.getIfPresent("key2"));
        System.out.println(cache.getIfPresent("key3"));

        //缓存删除监听
        RemovalListener<String, String> listener = new RemovalListener<String, String>() {
            public void onRemoval(RemovalNotification<String, String> notification) {
                System.out.println("[" + notification.getKey() + ":" + notification.getValue() + "] is removed!");
            }
        };
        Cache<String, String> listenCache = CacheBuilder.newBuilder()
                .maximumSize(1)
                .removalListener(listener)
                .build();
        Object listenValue = new Object();
        listenCache.put("key1", "value1");
        listenCache.put("key2", "value2");
        listenCache.put("key3", "value3");
        listenCache.put("key4", "value3");
        listenCache.put("key5", "value3");
        listenCache.put("key6", "value3");
        listenCache.put("key7", "value3");
        listenCache.put("key8", "value3");
    }
}
