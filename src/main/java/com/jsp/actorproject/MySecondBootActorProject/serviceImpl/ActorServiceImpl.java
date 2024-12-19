package com.jsp.actorproject.MySecondBootActorProject.serviceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsp.actorproject.MySecondBootActorProject.model.Actor;
import com.jsp.actorproject.MySecondBootActorProject.repository.ActorRepository;
import com.jsp.actorproject.MySecondBootActorProject.service.ActorService;
import com.jsp.actorproject.MySecondBootActorProject.utility.ResponseStructure;

@Service
public class ActorServiceImpl implements ActorService {
	@Autowired
	private ActorRepository actorRepository;

	@Override
	public ResponseEntity<ResponseStructure<Actor>> addActor(Actor actor) {
		Actor actor2=actorRepository.save(actor);
		ResponseStructure<Actor> responseStructure=new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Actor Object Created Successfully..!");
		responseStructure.setData(actor2);
		return new ResponseEntity<ResponseStructure<Actor>>(responseStructure,HttpStatus.CREATED);	
	}

	@Override
	public ResponseEntity<ResponseStructure<Actor>> findByActorId(int actorId) {
		 Optional<Actor> optional=actorRepository.findById(actorId);
		if(optional.isPresent()) {
			Actor actor=optional.get();
			ResponseStructure<Actor> responseStructure=new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Actor Object Found Successfully..!");
			responseStructure.setData(actor);
			return new ResponseEntity<ResponseStructure<Actor>>(responseStructure,HttpStatus.FOUND);	
		}
		else
			return null;
			
		
	}

	@Override
	public ResponseEntity<ResponseStructure<Actor>> updateByActorId(int actorId,Actor updatedActor) {
		Optional<Actor> optional=actorRepository.findById(actorId);
		if(optional.isPresent()) {
			
			Actor existingActor=optional.get();
			updatedActor.setActorId(existingActor.getActorId());
			actorRepository.save(updatedActor);
			ResponseStructure<Actor> responseStructure=new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Actor Object Updated Successfully..!");
			responseStructure.setData(updatedActor);
			return new ResponseEntity<ResponseStructure<Actor>>(responseStructure,HttpStatus.OK);	
		}
		else
			return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<Actor>> deleteByActorId(int actorId) {
		Optional<Actor> optional=actorRepository.findById(actorId);
		if(optional.isPresent()) {
			
			Actor actor=optional.get();
			actorRepository.delete(actor);
			
			ResponseStructure<Actor> responseStructure=new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Actor Object Deleted Successfully..!");
			responseStructure.setData(actor);
			return new ResponseEntity<ResponseStructure<Actor>>(responseStructure,HttpStatus.OK);	
		}
		else
			return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Actor>>> findAllActor() {
		List<Actor> actorList= actorRepository.findAll();
		if(!actorList.isEmpty()) {
			ResponseStructure<List<Actor>> responseStructure=new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Actor Object Found Successfully..!");
			responseStructure.setData(actorList);
			return new ResponseEntity<ResponseStructure<List<Actor>>>(responseStructure,HttpStatus.FOUND);	
		}
	else {
		ResponseStructure<List<Actor>> responseStructure=new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("No Actor Object Found..!");
		responseStructure.setData(Collections.emptyList());//optional set an empty list
		return new ResponseEntity<ResponseStructure<List<Actor>>>(responseStructure,HttpStatus.NOT_FOUND);		}
		}

}
