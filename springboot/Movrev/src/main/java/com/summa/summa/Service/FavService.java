package com.summa.summa.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.summa.summa.Entity.FavouritesEntity;
import com.summa.summa.Entity.ReviewEntity;

@Service
public interface FavService {

	FavouritesEntity createFav(FavouritesEntity fav);
	List<FavouritesEntity> getAllFav();
	void deleteFav(Long favId);
	FavouritesEntity updateFav(FavouritesEntity fav);
}
