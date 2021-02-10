package GuavaLearning;

import com.google.common.collect.*;

import java.util.*;

/**
 * @author limengtong
 * @date 2021/2/9 5:55 下午
 */
public class ForwardingCollection {
    public static void main(String args[]) {
//        AddLoggingList<String> list = new AddLoggingList<String>(
//                Arrays.asList("Alice", "Bob", "Carol")
//        );
//        list.add("assd");

        List<String> list1 = new ArrayList<String>();
        list1.add("dfad");
        PeekingIterator<String> peekIt = Iterators.peekingIterator(list1.iterator());
        System.out.println(peekIt.peek());

        skipNulls(list1.iterator());
    }

    public static Iterator<String> skipNulls(final Iterator<String> in) {
        return new AbstractIterator<String>() {
            protected String computeNext() {
                while (in.hasNext()) {
                    String s = in.next();
                    if (s != null) {
                        return s;
                    }
                }
                return endOfData();
            }
        };
    }
}



class AddLoggingList<E> extends ForwardingList<E> {
    final List<E> delegate; // backing list

    AddLoggingList(List<E> delegate) {
        this.delegate = delegate;
    }

    @Override
    protected List<E> delegate() {
        return delegate;
    }

    @Override
    public boolean add(E elem) {
        System.out.println(elem);
        return super.add(elem); // 用add(int, E)实现
    }
}
