package GuavaLearning;


import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import org.checkerframework.checker.nullness.Opt;

import java.util.ArrayList;
import java.util.List;

/**
 * @author limengtong
 * @date 2021/2/9 11:17 上午
 */
public class NullLearning {
    public static void main(String args[]){
        Optional<Integer> possible = Optional.of(5);
        System.out.println(possible.isPresent());
        System.out.println(possible.get());

        Integer a = 10;
        Optional<Integer> possible1 = Optional.of(a);
        System.out.println(possible1.get());
        System.out.println(possible1.or(1));
        System.out.println(possible1.orNull());

        Optional<Integer> possible2 = Optional.absent();
        System.out.println(possible2.orNull());
        System.out.println(possible2.or(100));

        String s = "s";
        Optional<String> stringOptional = Optional.of(s);

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        String pp = Optional.of(list.get(2)).or("s");
    }
}
