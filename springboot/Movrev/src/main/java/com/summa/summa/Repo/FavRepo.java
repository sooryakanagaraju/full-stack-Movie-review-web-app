package com.summa.summa.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.summa.summa.Entity.FavouritesEntity;

@Repository
public interface FavRepo extends CrudRepository<FavouritesEntity, Long>{

}
