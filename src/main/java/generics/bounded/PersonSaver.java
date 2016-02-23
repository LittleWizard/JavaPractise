package generics.bounded;


import generics.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class PersonSaver {

    private  RandomAccessFile file;
    private  Object realFile;

    public PersonSaver(final File file) throws FileNotFoundException {
        this.file = new RandomAccessFile(file, "rw");
    }
    public PersonSaver(final Object file) throws FileNotFoundException {
        this.realFile = file;
    }



    public void saveAll(final List<? extends Person> persons) {

    }

    //method level generic
    public <T extends Person> void save(final List<T> persons) {

    }

    //anything a person or anything that's a parent of a person
    public void saveAllContraVarient(final List<? super Person> persons) {

    }

}
