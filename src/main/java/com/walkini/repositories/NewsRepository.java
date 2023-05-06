package com.walkini.repositories;

import com.walkini.models.NewsModel;
import com.walkini.models.ProfileModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository
        extends JpaRepository<NewsModel,Integer> {


}
