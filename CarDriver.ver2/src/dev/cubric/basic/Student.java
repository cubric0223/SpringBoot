package dev.cubric.basic;

public class Student extends AbstractPerson{
    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public void speak() {
        System.out.println(String.format("My name is %s, and i am a student", getName()));

    }
}
