package dev.cubric.basic;

import java.util.ArrayList;
import java.util.List;

public class BasicMain {
    public static void main(String[] args){
        Person studentKim = new Student("Kim", 26);
        Person studentLee = new Student("Lee", 26);
        Person studentPark = new Student("Park", 26);

        Person lecturer = new Lecturer("Park Jeeho", 35);

        List<Person> everyone = new ArrayList<>();
        everyone.add(studentKim);
        everyone.add(studentLee);
        everyone.add(studentPark);

        for (Person person: everyone){
            person.speak();
        }
    }
}
