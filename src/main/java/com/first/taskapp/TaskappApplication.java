package com.first.taskapp;

import com.first.taskapp.services.TasksService;
import com.first.taskapp.services.TasksServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskappApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskappApplication.class, args);
	}
	@Bean
	public TasksService tasksService(){
		return new TasksServiceImpl();
	}
}
