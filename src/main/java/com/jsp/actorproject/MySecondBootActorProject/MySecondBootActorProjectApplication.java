package com.jsp.actorproject.MySecondBootActorProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jsp.actorproject.MySecondBootActorProject.controller.ActorController;

@SpringBootApplication
public class MySecondBootActorProjectApplication {

	public static void main(String[] args) {
	ApplicationContext ac=	SpringApplication.run(MySecondBootActorProjectApplication.class, args);
	   ActorController actorController =ac.getBean(ActorController.class);
	}

}
