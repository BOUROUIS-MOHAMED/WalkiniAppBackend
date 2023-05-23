package com.walkini.repositories;

import com.walkini.models.WaitingCharityManagingListModel;
import com.walkini.models.WaitingProductManagingListModel;
import com.walkini.models.requestType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WaitingCharityManagingListRepository extends JpaRepository<WaitingCharityManagingListModel,Integer> {
    List<WaitingCharityManagingListModel> findByTitleAndRequestType(String title, requestType requestType);
    List<WaitingCharityManagingListModel> findByModifiedCharityId(Integer charityId);
    List<WaitingCharityManagingListModel> findByModifiedCharityIdAndRequestType(Integer id, requestType requestType);
}