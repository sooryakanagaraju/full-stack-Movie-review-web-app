package com.summa.summa.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summa.summa.Entity.MovEntity;
import com.summa.summa.Repo.MovRepo;


@Service
public class MovServiceImpl implements MovService {

	
	@Autowired
	MovRepo movrepo;
	
	@Override
	public MovEntity createMov(MovEntity mov) {
		// TODO Auto-generated method stub
		return movrepo.save(mov);
	}

	@Override
	public List<MovEntity> getAllMov() {
		// TODO Auto-generated method stub
		return (List<MovEntity>) movrepo.findAll();
	}

	@Override
	public void deleteMov(Long MovId) {
		// TODO Auto-generated method stub
		movrepo.deleteById(MovId);
		
	}

	@Override
	public MovEntity updateMov(MovEntity mov) {
		MovEntity existingMov = movrepo.findById(mov.getMovId()).get();
		existingMov.setName(mov.getName());
		existingMov.setGenre(mov.getGenre());
		existingMov.setReleased(mov.getReleased());
		existingMov.setDirector(mov.getDirector());
		existingMov.setStarring(mov.getStarring());
		existingMov.setDescription(mov.getDescription());
		existingMov.setImage(mov.getImage());
//		existingresident.setResidentEmail(resident.getResidentEmail());
		
		return movrepo.save(existingMov);
	}

	@Override
	public MovEntity getMoviesById(long movId) {
		// TODO Auto-generated method stub
		Optional<MovEntity> optionalresident = movrepo.findById(movId);
		return optionalresident.get();
	}

}
