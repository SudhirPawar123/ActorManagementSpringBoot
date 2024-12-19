package com.jsp.actorproject.MySecondBootActorProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.actorproject.MySecondBootActorProject.model.Actor;
import com.jsp.springboot.MyFirstBootProject.model.Student;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {

}
