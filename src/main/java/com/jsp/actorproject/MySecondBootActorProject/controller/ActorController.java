package com.jsp.actorproject.MySecondBootActorProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.actorproject.MySecondBootActorProject.model.Actor;
import com.jsp.actorproject.MySecondBootActorProject.service.ActorService;
import com.jsp.actorproject.MySecondBootActorProject.utility.ResponseStructure;
@RestController
public class ActorController {

 @Autowired
 private ActorService actorService;
 
 //@RequestMapping(method=RequestMethod.POST,value="/actors/addActor" )
 @PostMapping(value="/actors/addActor")
	public ResponseEntity<ResponseStructure<Actor>>  addActor(@RequestBody Actor actor) {
		return actorService.addActor(actor);
	}
	 
 //@RequestMapping(method = RequestMethod.GET ,value="/actors/findByActorId" )
 @GetMapping(value="/actors/findByActor/{actorId}")
 public ResponseEntity<ResponseStructure<Actor>> findByActorId(@PathVariable int actorId) {
	return actorService.findByActorId(actorId);
}
 
// @RequestMapping(method = RequestMethod.PUT,value="/actors/updateByActorId" )
 @PutMapping(value="/actors/updateByActorId")
 public ResponseEntity<ResponseStructure<Actor>> updateByActorId(@RequestParam int actorId, @RequestBody Actor updatedActor) {
	return actorService.updateByActorId(actorId,updatedActor);
}
 
// @RequestMapping(method = RequestMethod.DELETE,value="/actors/deleteByActorId" )
 @DeleteMapping(value="/actors/deleteByActorId")
 public ResponseEntity<ResponseStructure<Actor>> deleteByActorId(@RequestParam int actorId) {
	return actorService.deleteByActorId(actorId);
}
 
// @RequestMapping(value="/actors/findAllActor" )
 @GetMapping(value="/actors/findAllActor")
 public ResponseEntity<ResponseStructure<List<Actor>>> findAllActor() {
	return actorService.findAllActor();
}
 
}
