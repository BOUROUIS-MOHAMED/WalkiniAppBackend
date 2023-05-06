package com.walkini.repositories;

import com.walkini.models.CouponModel;
import com.walkini.models.InboxModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InboxRepository extends JpaRepository<InboxModel,Integer> {




}