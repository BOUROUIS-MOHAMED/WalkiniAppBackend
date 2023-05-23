package com.walkini.repositories;

import com.walkini.models.BanModel;
import com.walkini.models.CharityModel;
import com.walkini.models.CouponModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CouponRepository extends JpaRepository<CouponModel,Integer> {

    List<CouponModel> findBycouponOwnerEquals(Integer userId);
    List<CouponModel> findBycouponName(String couponName);


}
