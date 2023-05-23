package com.walkini.repositories;


import com.walkini.models.WaitingProductSellListModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaitingProductSellListRepository  extends JpaRepository<WaitingProductSellListModel,Integer> {
}
