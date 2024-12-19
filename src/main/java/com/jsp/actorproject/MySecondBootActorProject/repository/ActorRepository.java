package com.jsp.actorproject.MySecondBootActorProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.actorproject.MySecondBootActorProject.model.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Integer> {

}
