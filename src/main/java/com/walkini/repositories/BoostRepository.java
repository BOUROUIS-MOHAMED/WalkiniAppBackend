package com.walkini.repositories;

import com.walkini.models.BoostsModel;
import com.walkini.models.ProfileModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoostRepository extends JpaRepository<BoostsModel,Integer> {


}
