package dev.cubric.challenge;

import dev.cubric.basic.Lecturer;
import dev.cubric.basic.Person;
import dev.cubric.basic.Student;

import java.lang.reflect.Array;
import java.util.*;

public class ChallengeMain {
    public static void main(String[] args) {
        Person studentKim = new Student("Kim", 26);
        Person studentLee = new Student("Lee", 26);
        Person studentPark = new Student("Park", 26);

        Person lecturer = new Lecturer("Park Jeeho", 35);

        Set<Person> everyone = new HashSet<>();
        everyone.add(studentKim);
        everyone.add(studentLee);
        everyone.add(studentPark);

        printItems(everyone);
    }

    public static <T> void printItems(Iterable<T> iterable){
        Iterator<T> iterator = iterable.iterator();
        if(!iterator.hasNext()) {
            System.out.println("No Elements");
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("idx\t\titem\n");
        for (int i =0; iterator.hasNext(); i++){
            T item = iterator.next();
            stringBuilder.append(
                    String.format("%d\t\t%s\n", i, item));
        }
        System.out.println(stringBuilder);
    }
}
