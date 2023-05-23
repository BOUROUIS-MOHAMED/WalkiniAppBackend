
package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.NewsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/news")
@CrossOrigin
public class NewsController {
    private final NewsRepository repository;


    public NewsController(NewsRepository repository) {
        this.repository = repository;

    }


    record CreationRequest(String title, String description, String newsImage, String country, String color, String priority, Boolean sponsored, Boolean newsIsInfo, Boolean newsIsFilteredByCountry, Integer action, String createdAt, String modifiedAt) { }
    record UpdateRequest(Integer id, String title, String description, String newsImage, String country, String color, String priority, Boolean sponsored, Boolean newsIsInfo, Boolean newsIsFilteredByCountry, Integer action, String createdAt, String modifiedAt) { }
    ResponseModel response = new ResponseModel();


    @GetMapping("/getById/{id}")
    public ResponseModel getById(@PathVariable Integer id) {
        Optional<NewsModel> model=repository.findById(id);
        if(model.isPresent()){
            response.setMessage("Exist");

            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(model);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("unfounded");
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setReturnedBoolean(false);
            response.setObject(null);
            response.setErrorCode("40000");
            response.setThereIsAnError(true);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }
        return response;
    }
    @GetMapping("/getAllNews")
    public List<NewsModel> getAllNews() {
        return repository.findAll();
    }

    @PostMapping("/createNews")
    public ResponseModel createNews(@RequestBody CreationRequest request )  {

       List<NewsModel> newsModelList=repository.findByTitle(request.title());
        if(newsModelList.isEmpty()){
            NewsModel news = new NewsModel();
            news.setModifiedAt(request.modifiedAt());
            news.setNewsIsFilteredByCountry(request.newsIsFilteredByCountry());
            news.setNewsIsInfo(request.newsIsInfo());
            news.setNewsImage(request.newsImage());
            news.setAction(request.action());
            news.setCreatedAt(request.createdAt());
            news.setColor(request.color());
            news.setCountry(request.country());
            news.setDescription(request.description());
            news.setPriority(request.priority());
            news.setSponsored(request.sponsored());
            news.setTitle(request.title());

            //ban
            //message
            repository.save(news);
            response.setMessage("news Added Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(news);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("news already exist");
            response.setErrorType(ErrorResponseType.DataAlreadyExist);
            response.setReturnedBoolean(false);
            response.setObject(null);
            response.setErrorCode("40000");
            response.setThereIsAnError(true);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }
        return response;
    }


    @PutMapping("/updateNews")
    public ResponseModel updateNews(@RequestBody UpdateRequest request) {
        NewsModel news = new NewsModel();
        Optional<NewsModel> newsModel = repository.findById(request.id());
        if (newsModel.isPresent()){
            news.setNewsImage(request.newsImage());
            news.setAction(request.action());
            news.setCreatedAt(request.createdAt());
            news.setColor(request.color());
            news.setCountry(request.country());
            news.setDescription(request.description());
            news.setPriority(request.priority());
            news.setSponsored(request.sponsored());
            news.setTitle(request.title());
            //ban
            //message
            repository.save(news);
            response.setMessage("news information updated Successfully");
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setReturnedBoolean(true);
            response.setObject(news);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("news unfounded");
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setReturnedBoolean(false);
            response.setObject(null);
            response.setErrorCode("40000");
            response.setThereIsAnError(true);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }
        return response;
    }
    @DeleteMapping("/deleteNews{newsId}")
    public void deleteNews(@PathVariable("newsId") int id) {
        repository.deleteById(id);
    }
}

