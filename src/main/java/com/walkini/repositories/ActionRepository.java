package com.walkini.repositories;

import com.walkini.models.ActionModel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActionRepository extends JpaRepository<ActionModel,Integer> {
List<ActionModel> findByName(String name);

}
