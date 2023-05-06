
package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.NewsRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/news")
@CrossOrigin
public class NewsController {
    private final NewsRepository repository;
    private final ProfileController profileController;

    public NewsController(NewsRepository repository, ProfileController profileController) {
        this.repository = repository;
        this.profileController = profileController;
    }


    record CreationRequest(String title, String description, String newsImage, String country, String color, String priority, Boolean sponsored, Integer action, Timestamp createdAt, Timestamp modifiedAt) {
    }
    record UpdateRequest(Integer id, String title, String description, String newsImage, String country, String color, String priority, Boolean sponsored, Integer action, Timestamp createdAt, Timestamp modifiedAt) {
    }
    Response response = new Response();

    @GetMapping("/getAllNews")
    public List<NewsModel> getAllNews() {
        return repository.findAll();
    }
    @GetMapping("/getNews{newsId}")
    public Response getNews(@RequestParam String newsId) {
        int id = Integer.parseInt(newsId);

        if (repository.existsById(id)) {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("news founded");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setObject(repository.findById(id));

        } else {
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setMessage("news unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
        }
        return response;


    }

    @PostMapping("/createNews")
    public Response createNews(@RequestBody CreationRequest request )  {

        ExampleMatcher matching = ExampleMatcher.matching()
                .withMatcher("title", ExampleMatcher.GenericPropertyMatchers.ignoreCase());
        Example<NewsModel> example = Example.<NewsModel>of(new NewsModel(request.title()), matching);
        boolean exists = repository.exists(example);
        if(exists){
            NewsModel news = new NewsModel();
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
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
        }else {
            response.setMessage("news already exist");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }


    @PutMapping("/updateNews")
    public Response updateNews(@RequestBody UpdateRequest request) {
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
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
            response.setObject(news);
        }else {
            response.setMessage("news unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }
    @DeleteMapping("/deleteNews{newsId}")
    public void deleteNews(@PathVariable("newsId") int id) {
        repository.deleteById(id);
    }
}

