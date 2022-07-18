/*
 * smartLab - smart tools for smart clinical laboratory
 * 
 * @Author Gaetano Di Grazia
 * @version 1.0
 * @since 11/01/2022
 * 
 * 
 * */

package com.smartLab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


/*
 * The main of the project
 * */
@SpringBootApplication
@EnableSwagger2
public class smartLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(smartLabApplication.class, args);
	}

}
