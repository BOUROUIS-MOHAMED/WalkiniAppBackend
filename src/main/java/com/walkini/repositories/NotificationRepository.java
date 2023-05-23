package com.walkini.repositories;

import com.walkini.models.NewsModel;
import com.walkini.models.NotificationModel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository
        extends JpaRepository<NotificationModel,Integer> {
    List<NotificationModel> findByname(String name);


}
