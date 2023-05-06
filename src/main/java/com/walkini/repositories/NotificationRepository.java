package com.walkini.repositories;

import com.walkini.models.NotificationModel;
import com.walkini.models.ProfileModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository
        extends JpaRepository<NotificationModel,Integer> {


}
