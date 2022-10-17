package com.help.demokelly;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemokellyApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemokellyApplication.class, args);

		connectDB connect = new connectDB(); 
		


	}

}


