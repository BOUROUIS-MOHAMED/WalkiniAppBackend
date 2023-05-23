package com.walkini.repositories;

import com.walkini.models.BanModel;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface BanRepository extends JpaRepository<BanModel,Integer> {
    List<BanModel> findByName(String BanName);



}
