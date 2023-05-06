package com.walkini.repositories;

import com.walkini.models.ActionModel;
import com.walkini.models.ProfileModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository<ActionModel,Integer> {


}
