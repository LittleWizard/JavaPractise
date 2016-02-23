package generics;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class SetExample {

    public static void main(String[] args) {

        Person donDraper = new Person("Don Draper", 89);
        Person peggyOlson = new Person("Peggy Olson", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        Set<Person> madMen = new HashSet<>();

        madMen.add(donDraper);
        madMen.add(peggyOlson);
        madMen.add(donDraper);

        System.out.println(madMen);

        for (Person person : madMen) {
            System.out.println(person);
        }

        Map<String, Person> map  = new HashMap<>();
        map.put(donDraper.getName(), donDraper);
        map.put(peggyOlson.getName(), peggyOlson);
        map.put(bertCooper.getName(), bertCooper);

        for (Map.Entry<String, Person> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }
}
