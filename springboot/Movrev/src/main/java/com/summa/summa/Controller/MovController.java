package com.summa.summa.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.summa.summa.Entity.FavouritesEntity;
import com.summa.summa.Entity.MovEntity;
import com.summa.summa.Entity.ReviewEntity;
import com.summa.summa.Service.MovService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class MovController {

	
	@Autowired
	MovService movservice;
	
	@PostMapping("/createMov")
    public MovEntity createMov(@RequestBody MovEntity mov)
    {
        return movservice.createMov(mov);
    }
	
	@GetMapping("/listMov")
    public List<MovEntity> getAllMov() {
    // TODO Auto-generated method stub
		return movservice.getAllMov();
	}
	
	@DeleteMapping("/deleteMov/{id}")
	public ResponseEntity<String> DeleteMov(@PathVariable("id") Long MovId)
	{		
		movservice.deleteMov(MovId);
		return new ResponseEntity<>("leave successfully deleted!",HttpStatus.OK);
	
}
	
	
	@PutMapping("/updateMov/{id}")
	public ResponseEntity<MovEntity> updateMov(@PathVariable("id") Long movId,@RequestBody MovEntity mov)
	{
		mov.setMovId(movId);	
		MovEntity updatedmov = movservice.updateMov(mov);
		return new ResponseEntity<>(updatedmov,HttpStatus.OK);
	}
	
	@GetMapping("/getMovie/{id}")
	public ResponseEntity<MovEntity> getMovieById(@PathVariable("id") Long movId)
	{
		MovEntity moviee = movservice.getMoviesById(movId);
		return new ResponseEntity<>(moviee,HttpStatus.OK);
	}
	
}
