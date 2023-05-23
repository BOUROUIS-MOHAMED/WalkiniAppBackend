package com.walkini.repositories;

import com.walkini.models.WaitingProductManagingListModel;
import com.walkini.models.requestType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WaitingProductManagingListRepository extends JpaRepository<WaitingProductManagingListModel,Integer>  {
    List<WaitingProductManagingListModel> findByNameAndRequestType(String name, requestType requestType);
    List<WaitingProductManagingListModel> findByModifiedProductId(Integer productId);
    List<WaitingProductManagingListModel> findByModifiedProductIdAndRequestType(Integer id, requestType requestType);
}

