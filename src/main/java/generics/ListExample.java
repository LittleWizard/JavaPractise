package generics;


import java.util.*;

public class ListExample {

    public static void main(String[] args) {

        System.out.println("Hello World");

        ArrayList<String> numbers = new ArrayList<>(Arrays.asList("one", "two", "three"));
        numbers.add("four");
        for(String str : numbers){
            str = str + " 11";
            System.out.println(str);
        }
        numbers.forEach(System.out::println);

        List<String> places = Arrays.asList("Dhaka", "Canada");
        places.set(0, "US");
        System.out.println(places.get(0));

        //this is immutable , and can contain only one element which is specified at creation time or an empty list
        List<String> names = Collections.singletonList("Dhaka");
        System.out.println(names.get(0));

        //in map we can't use primitive types as key so we have used object here.
        Map<Integer, String> map = new HashMap<>();
        map.put(Integer.valueOf(1), "one-two");
        System.out.println(map.get(1));

        //set : no duplicate and must be comparable, it actually removes the duplicates

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        System.out.println(set.size());

        //
        List list = new ArrayList<>();
        list.add("one");
        list.add(1);

        //List is just an interface
        //Array list is backed by an array
        Person donDraper = new Person("Don Draper", 89);
        Person peggyOlson = new Person("Peggy Olson", 65);

        List<Person> madMen = new ArrayList<Person>();
        // List<Person> madMen = new ArrayList<>();
        //from java 7 diamond operator was added.It means, don't add the generics
        //in explicitly, just infer it from the context, so you know this a list of person
        //and you know array list implements list, so you know you can construct an array
        //list of person and assign it to the mad men variable.

        //all it means is, just take the generic parameter from left hand side and fill
        //it in as the generic parameter in our constructor.

        madMen.add(donDraper);
        madMen.add(peggyOlson);

        System.out.println(madMen);

        madMen.add(new Person("Bert Cooper", 100));
        //add method automatically resize the list
        System.out.println(madMen);

        Collections.sort(madMen, new AgeComparator());
        System.out.println(madMen);

        Collections.sort(madMen, new ReverseComparator<>(new AgeComparator()));
        System.out.println(madMen);

        final Iterator<Person> iterator = madMen.iterator();
        while(iterator.hasNext()) {
            final Person person = iterator.next();
            System.out.println(person);
        }

        int[] values = new int[] { 1,5,10,50,100 };
        Random random = new Random();
        List<Dollar> wallet = new ArrayList<Dollar>();

        for(int i = 0; i < 10; i++) {
            Dollar dollar = new Dollar();
            dollar.setCountry("US");
            dollar.setValue(values[random.nextInt(values.length)]);
            wallet.add(dollar);
        }
        for(Dollar dollar : wallet) {
            System.out.println(dollar + "\t");
        }
        Collections.sort(wallet);
        for(Dollar dollar : wallet) {
            System.out.println(dollar + "\t");
        }

       // final Person youngestCastMember = (Person) min(madMen, new AgeComparator());

        final Person youngestCastMember =  min(madMen, new AgeComparator());

        //no type safety , so we'll get runtime error.If we don't use generic we'll get runtime error
        //other than compile time error.

     /*   final Person youngestCastMember = (Person) min(madMen, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });*/


        System.out.println(youngestCastMember);

        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        System.out.println(min(ints, Integer::compare));
    }


   /* public static Object min(List values, Comparator comparator) {
        if(values.isEmpty()) {
            throw new IllegalArgumentException("List is empty, can not find minimum");
        }
        Object lowestElement = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            final Object element = values.get(i);
            if(comparator.compare(element, lowestElement) < 0) {
                lowestElement = element;
            }
        }
        return lowestElement;
    }*/


    public static <T> T min(List<T> values, Comparator<T> comparator) {
        if(values.isEmpty()) {
            throw new IllegalArgumentException("List is empty, can not find minimum");
        }
        T lowestElement = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            final T element = values.get(i);
            if(comparator.compare(element, lowestElement) < 0) {
                lowestElement = element;
            }
        }
        return lowestElement;
    }


}
