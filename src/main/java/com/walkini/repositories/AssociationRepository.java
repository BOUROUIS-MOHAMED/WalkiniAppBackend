package com.walkini.repositories;


import com.walkini.models.AssociationModel;
import com.walkini.models.NormalUserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssociationRepository extends JpaRepository<AssociationModel,Integer> {
    List<AssociationModel> findByEmailOrPhoneNumber(String Email, String phoneNumber);
    List<AssociationModel> findByEmail(String Email);
    List<AssociationModel> findByPhoneNumber(String phoneNumber);

}
