package com.walkini.repositories;

import com.walkini.models.CartHistoryModel;
import com.walkini.models.PartnerWalletModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartnerWalletRepository extends JpaRepository<PartnerWalletModel,Integer> {
        List<CartHistoryModel> findByuserIdEquals(Integer ownerId);


        }
