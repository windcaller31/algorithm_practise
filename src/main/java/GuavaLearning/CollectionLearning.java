package GuavaLearning;

import com.google.common.collect.*;
import com.google.common.primitives.Ints;
import sun.security.provider.certpath.Vertex;

import javax.swing.plaf.multi.MultiScrollBarUI;
import java.util.*;

/**
 * @author limengtong
 * @date 2021/2/9 2:42 下午
 */
public class CollectionLearning {
    public static void main(String args[]){
        //
        ImmutableSet<String> set = ImmutableSet.of("a","n","f");

        //
        Set<String> aSet = new HashSet<>();
        ImmutableSet<String> bSet = ImmutableSet.copyOf(aSet);

        //
        ImmutableSet<String> cSet = ImmutableSet.<String>builder().add("ff").build();

        //
        ImmutableSortedSet<Integer> dSet = ImmutableSortedSet.of(2,3,4,8,6,1);
        dSet.asList();

        //HashMultiset TreeMultiset linkedHashMultiset ConcurrentHashMultiset ImmutableMultiset
        Multiset<String> multiSet = HashMultiset.create();
        multiSet.add("a");
        multiSet.add("a");
        multiSet.add("b");
        multiSet.add("c");
        multiSet.add("d");
        System.out.println(multiSet.size());
        System.out.println(multiSet.count("a"));
        //all
        multiSet.iterator();
        //distinct
        System.out.println(multiSet.entrySet().size());
        //remove a
        multiSet.setCount("a",0);

        //ListMultimap SetMultimap
        SetMultimap<String,String> setMultimap = HashMultimap.create();
        setMultimap.put("a","A");
        setMultimap.put("a","C");
        setMultimap.put("a","C");
        setMultimap.put("a","D");
        setMultimap.put("b","K");
        setMultimap.put("b","L");
        setMultimap.put("b","M");
        System.out.println(setMultimap.toString());
        System.out.println(setMultimap.asMap());
        System.out.println(setMultimap.entries());
        System.out.println(setMultimap.keySet());
        System.out.println(setMultimap.keys());
        System.out.println(setMultimap.values());

        System.out.println("===");
        ListMultimap<String,String> listMultimap = ArrayListMultimap.create();
        listMultimap.put("a","A");
        listMultimap.put("a","C");
        listMultimap.put("a","C");
        listMultimap.put("a","D");
        listMultimap.put("b","K");
        listMultimap.put("b","L");
        listMultimap.put("b","M");
        System.out.println(listMultimap.toString());
        System.out.println(listMultimap.toString());
        System.out.println(listMultimap.asMap());
        System.out.println(listMultimap.entries());
        System.out.println(listMultimap.keySet());
        Multiset<String> midSet = listMultimap.keys();
        System.out.println(listMultimap.keys());
        System.out.println(listMultimap.values());

        List<String> reList= listMultimap.get("a");
        reList.clear();
        reList.add("v");
        reList.add("v");
        reList.add("b");
        reList.add("x");

        Map<String, Collection<String>> reMap = listMultimap.asMap();

        //双向映射 very nice
        BiMap<String,Integer> userBiMap = HashBiMap.create();
        System.out.println(userBiMap.put("a",42));
        System.out.println(userBiMap.put("a",52));
        BiMap<Integer,String> inverseUserBiMap = userBiMap.inverse();

        //图计算优先考虑 两个键 一个值
        Table<String,String,Integer> graph = HashBasedTable.create();
        graph.put("a","b",40);
        graph.put("c","d",5);
        graph.put("e","f",12);
        graph.put("g","h",7);
        System.out.println(graph.rowMap());
        System.out.println(graph.row("a"));
        System.out.println(graph.cellSet());

        //类型作为map
        ClassToInstanceMap<Number> numberDefaults=MutableClassToInstanceMap.create();
        numberDefaults.putInstance(Integer.class, Integer.valueOf(0));

        //空白区间融合的 Range collection
        RangeSet<Integer> rangeSet1 = TreeRangeSet.create();
        rangeSet1.add(Range.closedOpen(1,5));
        RangeSet<Integer> rangeSet2 = TreeRangeSet.create();
        rangeSet2.add(Range.closedOpen(2,7));
        System.out.println(rangeSet1.contains(6));
        RangeSet<Integer> rangeSet3 = rangeSet1.subRangeSet(Range.closedOpen(2,7));
        System.out.println(rangeSet3.asRanges());
        System.out.println(rangeSet3.rangeContaining(4));
        System.out.println(rangeSet3.encloses(Range.closedOpen(2,3)));
        rangeSet1.add(Range.closed(9,11));
        System.out.println(rangeSet3.span());
        System.out.println(rangeSet1.span());

        RangeMap<Integer,String> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closed(1,9),"a");
        System.out.println(rangeMap.asMapOfRanges());
        System.out.println(rangeMap.subRangeMap(Range.closed(2,4)));

        //guava静态工厂 very nice 可以直接初始化值
        Set<String> copySet = Sets.newHashSet("a","b");
        Iterable<Integer> concatenated = Iterables.concat(
                Ints.asList(1, 2, 3),
                Ints.asList(4, 5, 6));
        List<String> list = Lists.newArrayList("po","dr","uy");
        System.out.println(Lists.partition(list,2));
        System.out.println(Iterables.getLast(list));
        System.out.println(Lists.reverse(list));

        Set<String> set1 = Sets.newHashSet("19","d");
        Set<String> set2 = Sets.newHashSet("f","d");
        System.out.println(Sets.union(set1,set2));
        System.out.println(Sets.cartesianProduct(set1,set2));
        System.out.println(Sets.powerSet(set1));

        Map<String, Integer> left = ImmutableMap.of("a", 1, "b", 2, "c", 3);
        Map<String, Integer> right = ImmutableMap.of("d", 1, "b", 2, "e", 3);
        MapDifference<String, Integer> diff = Maps.difference(left, right);

        System.out.println(diff.entriesInCommon()); // {"b" => 2}
        System.out.println(diff.entriesOnlyOnLeft()); // {"a" => 1}
        System.out.println(diff.entriesOnlyOnRight()); // {"d" => 5}

        Multiset<String> multiset1 = HashMultiset.create();
        multiset1.add("a", 2);

        Multiset<String> multiset2 = HashMultiset.create();
        multiset2.add("a", 5);

        System.out.println(multiset1.containsAll(multiset2)); //返回true；因为包含了所有不重复元素，
        //虽然multiset1实际上包含2个"a"，而multiset2包含5个"a"
        System.out.println(Multisets.containsOccurrences(multiset1, multiset2)); // returns false

        multiset2.removeAll(multiset1);//multiset2移除所有"a"，虽然multiset1只有2个"a"
        System.out.println(multiset2.isEmpty()); // returns true
    }
}
