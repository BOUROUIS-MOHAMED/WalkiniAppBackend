package com.walkini.repositories;

import com.walkini.models.CouponModel;
import com.walkini.models.FileData;
import com.walkini.models.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileDataRepository extends JpaRepository<FileData,Integer> {
    Optional<FileData> findByName(String fileName);

}
