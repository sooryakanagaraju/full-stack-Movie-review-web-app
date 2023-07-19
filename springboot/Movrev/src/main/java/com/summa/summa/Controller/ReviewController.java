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

import com.summa.summa.Entity.ReviewEntity;
import com.summa.summa.Service.ReviewService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ReviewController {

	@Autowired
	ReviewService revservice; 
	
	@PostMapping("/createRev")
    public ReviewEntity createShift(@RequestBody ReviewEntity Rev)
    {
        return revservice.createLeave(Rev);
    }

	@GetMapping("/listRev")
    public List<ReviewEntity> getAllRev() {
    // TODO Auto-generated method stub
		return revservice.getAllrev();
	}
	
	@DeleteMapping("/deleteReview/{id}")
	public ResponseEntity<String> DeleteRev(@PathVariable("id") Long revId)
	{		
		revservice.deleteReview(revId);
		return new ResponseEntity<>("leave successfully deleted!",HttpStatus.OK);
	}
	
	
	@PutMapping("/updateRev/{id}")
	public ResponseEntity<ReviewEntity> updateResident(@PathVariable("id") Long revId,@RequestBody ReviewEntity review)
	{
		review.setRevId(revId);	
		ReviewEntity updatedreview = revservice.updateRev(review);
		return new ResponseEntity<>(updatedreview,HttpStatus.OK);
	}
}
