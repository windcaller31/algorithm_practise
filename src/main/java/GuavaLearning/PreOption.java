package GuavaLearning;

import com.google.common.base.Preconditions;

import java.util.Optional;

/**
 * @author limengtong
 * @date 2021/2/9 11:58 上午
 */
public class PreOption {
    public static void main(String args[]){
        int i = 100;
        Preconditions.checkArgument(i==100);
        Integer j = null;
        System.out.println(Preconditions.checkNotNull(i));
        //exception : 500
//        System.out.println(Preconditions.checkNotNull(j,500));
        //exception: index out of bounds
//        System.out.println(Preconditions.checkElementIndex(i,100));
        System.out.println(Preconditions.checkPositionIndex(i,100));
    }
}
