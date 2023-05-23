package com.walkini.repositories;

import com.walkini.models.NewsModel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository
        extends JpaRepository<NewsModel,Integer> {
    List<NewsModel> findByTitle(String newsTitle);

}
