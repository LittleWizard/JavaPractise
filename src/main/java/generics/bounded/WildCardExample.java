package generics.bounded;


import generics.Person;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class WildCardExample {

    public static void main(String[] args) throws FileNotFoundException {

        Partner donDraper = new Partner("Don Draper", 89);
        Partner bertCooper =  new Partner("Bert Cooper", 100);
        Employee peggyOlson = new Employee("Peggy Olson", 65);

        //arrays are co variant in java so they are not safe
        //we can put small object to big object actually.

        /*Partner[]  partners = new Partner[2];
        Person[] persons = partners;
        persons[0] = donDraper;
        persons[1] = bertCooper;*/


     /*   Employee[] empolyees = new Employee[2];
        Person[] persons = empolyees;
        persons[0] = donDraper;
        persons[1] = bertCooper;*/

        //let's try with list
        //arrays are not co variant in java so they are safe

        PersonSaver personSaver = new PersonSaver(new Object());

       // List<Person> persons = new ArrayList<>();
        List<Partner> persons = new ArrayList<>();
        persons.add(donDraper);
        persons.add(bertCooper);
      //  personSaver.saveAll(persons);

        personSaver.saveAll(persons);

        //i want to say i can save any class that's a subclass of a person
        //so, i should be able to save all any class that's a subclass of person
        //


        //why don't we make all list co varient ?
        //and the answer is, because if we did that, we'd be back with the safety problems that we had with arrays.
        //we'd be abe to assign a list of employee to a list of person and then add some partners
        //into that list of employee.So, we'd be in a situation where our code wasn't safe.
        //Generic is all about nice combination of safety without having to duplicate copies of your code
        //all over the place.These wildcards fit very very nicely into that story because they let us have a little bit more flexibility
        //and still maintain safety.




    }


    static class PersonHolder<T extends Person, E extends  Person> {
        T get(){
            return null;
        }
    }

    //can't do the following

    /*static class PersonHolder<? extends Person> {

        ??? get(){    <<---  nothing to refer from here , and if we have got multiple parameter
            return null;// then how could we identify them from here (which question maps to which question marks from here)
        }

    }*/

}
