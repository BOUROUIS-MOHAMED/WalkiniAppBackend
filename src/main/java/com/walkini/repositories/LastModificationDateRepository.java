package com.walkini.repositories;

import com.walkini.models.ActionModel;
import com.walkini.models.LastModificationDateModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LastModificationDateRepository extends JpaRepository<LastModificationDateModel,Integer> {

}
