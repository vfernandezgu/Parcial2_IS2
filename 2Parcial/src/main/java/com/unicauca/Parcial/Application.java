package com.unicauca.Parcial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Jose David Chilito Cometa, Valentina Fernandez Guerrero, Juan Esteban Yepez Rodriguez
 */

@SpringBootApplication
@ComponentScan(basePackages = "com.unicauca.Parcial")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}
}
