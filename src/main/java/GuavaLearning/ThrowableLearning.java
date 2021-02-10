package GuavaLearning;

import com.google.common.base.Throwables;

/**
 * @author limengtong
 * @date 2021/2/9 12:50 下午
 */
public class ThrowableLearning {
    public static void main(String args[]) throws Exception {
        try{
            throw new Exception("my exception");
        }catch (Throwable throwable){
            System.out.println(Throwables.getStackTraceAsString(throwable));
            Throwables.propagateIfPossible(throwable,Error.class);
        }
    }
}
