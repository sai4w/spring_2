package com.example.inventory;

import java.util.Date;

import com.example.inventory.entities.Skin;
import com.example.inventory.service.SkinService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SkinApplication implements CommandLineRunner {


	
	public static void main(String[] args) {
		SpringApplication.run(SkinApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

}
}
