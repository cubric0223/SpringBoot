package dev.cubric.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		TestComponent testComponent = new TestComponent(
				new TestInterface() {
					@Override
					public void sayHello() {
						System.out.println("hello World! this is temp interface");
					}
				}
		);
		testComponent.sayHello();
		SpringApplication.run(DemoApplication.class, args);
	}

}
