package dev.cubric.demo;

import org.springframework.stereotype.Component;

@Component
public class TestImplementation implements TestInterface {
    @Override
    public void sayHello() {
        System.out.println("hello my name is bean");
    }
}
