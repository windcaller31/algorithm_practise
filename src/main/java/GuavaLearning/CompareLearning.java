package GuavaLearning;

import com.google.common.base.Function;
import com.google.common.collect.Comparators;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author limengtong
 * @date 2021/2/9 12:35 下午
 */
public class CompareLearning {
    public static void main(String args[]){
        List<BTest> blist = new ArrayList<>();
        blist.add(new BTest(100,"dd"));
        blist.add(new BTest(105,"cc"));
        blist.add(new BTest(19,"ff"));
        Ordering<BTest> ordering = Ordering.natural().onResultOf(
                new Function<BTest, String>() {
                    public String apply(BTest bTest) {
                        return bTest.b;
                    }
                }
        );
        blist = ordering.sortedCopy(blist);
        BTest b0=blist.get(0);
        blist=ordering.greatestOf(blist,2);

        List<ATT> attList = new ArrayList<>();
        attList.add(new ATT(1,"aba"));
        attList.add(new ATT(2,"baa"));
        attList.add(new ATT(3,"ccc"));
        Collections.sort(attList);
    }
}

class BTest{
    int a;
    String b;

    public BTest(int a, String b) {
        this.a = a;
        this.b = b;
    }
}

class ATT implements Comparable<ATT> {
    int a;
    String b;

    public ATT(int a, String b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public int compareTo(ATT that) {
        return ComparisonChain.start()
                .compare(this.b.charAt(1),that.b.charAt(1)).result();
    }
}
