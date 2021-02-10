package GuavaLearning;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;

/**
 * @author limengtong
 * @date 2021/2/10 4:03 下午
 */
public class LoadingCacheStudy {
    public static void main(String args[]) throws ExecutionException {
        CacheLoader<String, String> loader = new CacheLoader<String, String>() {
            public String load(String key) throws Exception {
                Thread.sleep(1000); //休眠1s，模拟加载数据
                System.out.println(key + " is loaded from a cacheLoader!");
                return key + "'s value";
            }
        };

        LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .build(loader);//在构建时指定自动加载器

        System.out.println("value1 :"+loadingCache.get("key1"));
        System.out.println("value2 :"+loadingCache.get("key2"));
        System.out.println("value3 :"+loadingCache.get("key3"));
    }
}
