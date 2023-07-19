package com.summa.summa.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.summa.summa.Entity.MovEntity;

@Repository
public interface MovRepo extends CrudRepository<MovEntity, Long> {

	
}
