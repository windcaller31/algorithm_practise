package GuavaLearning;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

import javax.annotation.Nullable;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author limengtong
 * @date 2021/2/10 5:06 下午
 */
public class BloomFilterStudy {
    public static void main(String args[]){
        Funnel<Person> personFunnel = new Funnel<Person>() {
            @Override
            public void funnel(Person person, PrimitiveSink into) {
                into.putInt(person.id).putString(person.firstName, Charsets.UTF_8).putString(person.lastName, Charsets.UTF_8).putInt(person.birthYear);
            }
        };

        BloomFilter<Person> friends = BloomFilter.create(personFunnel, 500, 0.01);
        List<Person> friendsList = new ArrayList<>();
        friendsList.add(new Person(1,"li","mengtong",1993));
        friendsList.add(new Person(1,"wu","hu",2008));
        for(Person friend : friendsList) {
            friends.put(friend);
        }

        // 很久以后
        Person wuhu=new Person(1,"wu","hu",2008);
        if (friends.mightContain(wuhu)) {
            System.out.println(111);
        }

    }
}

class Person {
    int id;
    String firstName;
    String lastName;
    int birthYear;

    public Person(@Nullable int id, String firstName, String lastName, int birthYear) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }
}
