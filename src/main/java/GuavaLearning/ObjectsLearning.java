package GuavaLearning;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

/**
 * @author limengtong
 * @date 2021/2/9 12:14 下午
 */
public class ObjectsLearning {
    public static void main(String args[]){
        //equal
        String a = null;
        String b = "q";
        String c = "s";
        System.out.println(Objects.equal("s",a));
        System.out.println(Objects.equal("s",b));
        System.out.println(Objects.equal("s",c));
        System.out.println(Objects.equal(a,null));

        //hash
        ATest at = new ATest(1,"dd");
        System.out.println(Objects.hashCode(at));
        System.out.println(Objects.hashCode(1,"dd"));
        System.out.println(Objects.hashCode("dd",1));

        //toString
        System.out.println(MoreObjects.toStringHelper(at).add("a",1).add("b","ddddd").toString());

        //compare
        ATest at1 = new ATest(2,"cc");
        System.out.println(at.compareTo(at1));

    }
}
class ATest implements Comparable<ATest> {
    int a;
    String b;

    public ATest(int a, String b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(ATest that) {
        return ComparisonChain.start()
                .compare(this.a,that.a)
                .compare(this.b,that.b).result();
    }
}
