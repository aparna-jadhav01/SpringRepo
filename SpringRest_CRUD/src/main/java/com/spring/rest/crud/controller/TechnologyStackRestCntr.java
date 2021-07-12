package com.spring.rest.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.crud.exception.ResourceNotFoundException;
import com.spring.rest.crud.model.TechnologyStack;
import com.spring.rest.crud.repository.TechnologyStackRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TechnologyStackRestCntr {
	
	@Autowired
	TechnologyStackRepo technologyStackRepo;
	
	@GetMapping("/technology")
	public List<TechnologyStack> getListOfTechnology(){
		return technologyStackRepo.findAll();
	}
	
	@PostMapping("/technology")
	public TechnologyStack createUser(@RequestBody TechnologyStack technology) {
		return technologyStackRepo.save(technology);
	}
	
	@GetMapping("/technology/{id}")
	public ResponseEntity<TechnologyStack> getTechData(@PathVariable(value = "id") Long id) throws ResourceNotFoundException{
		TechnologyStack techStack = technologyStackRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Technology not found :" + id));
		return ResponseEntity.ok().body(techStack);
	}
	
	
	@PutMapping("/technology/{id}")
    public ResponseEntity<TechnologyStack> updateTechnology(@PathVariable(value = "id") Long technologyId,
         @RequestBody TechnologyStack techDetails) throws ResourceNotFoundException {
		TechnologyStack tech = technologyStackRepo.findById(technologyId)
        .orElseThrow(() -> new ResourceNotFoundException("Technology not found for this id :: " + technologyId));

        tech.setTechnologyName(techDetails.getTechnologyName());
        tech.setVersion(techDetails.getVersion());
        final TechnologyStack technology = technologyStackRepo.save(tech);
        return ResponseEntity.ok(technology);
    }
	
	@DeleteMapping("/technology/{id}")
	public ResponseEntity<TechnologyStack> deleteTechnology(@PathVariable(value = "id") Long id) throws ResourceNotFoundException{
		TechnologyStack tech = technologyStackRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Technology not found"));
		this.technologyStackRepo.delete(tech);
		return ResponseEntity.ok().build();
	}

}
