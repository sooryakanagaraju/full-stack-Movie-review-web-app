package com.summa.summa.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summa.summa.Entity.FavouritesEntity;

import com.summa.summa.Repo.FavRepo;


@Service
public class FavServiceImpl implements FavService {
	
	
	@Autowired
	FavRepo favrepo;

	@Override
	public FavouritesEntity createFav(FavouritesEntity fav) {
		// TODO Auto-generated method stub
		return favrepo.save(fav);
	}

	@Override
	public List<FavouritesEntity> getAllFav() {
		// TODO Auto-generated method stub
		return (List<FavouritesEntity>) favrepo.findAll();
	}

	@Override
	public void deleteFav(Long favId) {
		favrepo.deleteById(favId);
		
	}

	@Override
	public FavouritesEntity updateFav(FavouritesEntity fav) {
		// TODO Auto-generated method stub
		FavouritesEntity existingfav = favrepo.findById(fav.getFavId()).get();
		existingfav.setName(fav.getName());
		existingfav.setImage(fav.getImage());
		existingfav.setGenre(fav.getGenre());
		existingfav.setReleased(fav.getReleased());
		existingfav.setDirector(fav.getDirector());
//		existingresident.setResidentEmail(resident.getResidentEmail());
		
		return favrepo.save(existingfav);
	}

}
