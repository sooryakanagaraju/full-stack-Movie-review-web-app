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
import com.summa.summa.Entity.ReviewEntity;
import com.summa.summa.Service.FavService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class FavController {

	
	@Autowired
	FavService favservice;
	
	@PostMapping("/createFav")
    public FavouritesEntity createShift(@RequestBody FavouritesEntity fav)
    {
        return favservice.createFav(fav);
    }
	
	@GetMapping("/listFav")
    public List<FavouritesEntity> getAllFav() {
    // TODO Auto-generated method stub
		return favservice.getAllFav();
	}
	
	@DeleteMapping("/deleteFav/{id}")
	public ResponseEntity<String> DeleteFav(@PathVariable("id") Long favId)
	{		
		favservice.deleteFav(favId);
		return new ResponseEntity<>("leave successfully deleted!",HttpStatus.OK);
	

}
	@PutMapping("/updateFav/{id}")
	public ResponseEntity<FavouritesEntity> updateResident(@PathVariable("id") Long favId,@RequestBody FavouritesEntity fav)
	{
		fav.setFavId(favId);	
		FavouritesEntity updatedfav = favservice.updateFav(fav);
		return new ResponseEntity<>(updatedfav,HttpStatus.OK);
	}	


}
