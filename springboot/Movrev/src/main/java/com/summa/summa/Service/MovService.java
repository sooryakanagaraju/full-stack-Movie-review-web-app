package com.summa.summa.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.summa.summa.Entity.FavouritesEntity;
import com.summa.summa.Entity.MovEntity;

@Service
public interface MovService {
	MovEntity createMov(MovEntity mov);
	List<MovEntity> getAllMov();
	void deleteMov(Long MovId);
	MovEntity updateMov(MovEntity mov);
	MovEntity getMoviesById(long movId);
}
