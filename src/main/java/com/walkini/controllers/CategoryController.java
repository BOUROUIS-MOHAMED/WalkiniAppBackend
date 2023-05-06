
package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.BoxModel;
import com.walkini.models.CategoryModel;
import com.walkini.models.ErrorResponseType;
import com.walkini.models.Response;
import com.walkini.repositories.CategoryRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/category")
@CrossOrigin
public class CategoryController {
    private final CategoryRepository repository;

    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }


    record CreationRequest(String categoryName, String icon, Timestamp createdAt){}
    record UpdateRequest(Integer id, String categoryName, String icon, Timestamp modifiedAt){}
    Response response = new Response();

    @GetMapping("/getAllCategories")
    public List<CategoryModel> getAllCategories() {
        return repository.findAll();
    }


    @PostMapping("/createCategory")
    public Response createCategory(@RequestBody CreationRequest request )  {

        ExampleMatcher matching = ExampleMatcher.matching()
                .withMatcher("categoryName", ExampleMatcher.GenericPropertyMatchers.ignoreCase());
        Example<CategoryModel> example = Example.<CategoryModel>of(new CategoryModel(request.categoryName()), matching);
        boolean exists = repository.exists(example);
        if(exists){
            CategoryModel categoryModel = new CategoryModel();
           categoryModel.setCategoryName(request.categoryName());
           categoryModel.setIcon(request.icon());
           categoryModel.setCreatedAt(request.createdAt());

            //ban
            //message
            repository.save(categoryModel);
            response.setMessage("category Added Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
        }else {
            response.setMessage("category already exist");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }


    @PutMapping("/updateCategory")
    public Response updateCategory(@RequestBody UpdateRequest request) {
        CategoryModel category = new CategoryModel();
        Optional<CategoryModel> categoryModel = repository.findById(request.id());
        if (categoryModel.isPresent()){
           category.setCategoryName(request.categoryName());
           category.setModifiedAt(request.modifiedAt());
           category.setIcon(request.icon());

            //ban
            //message
            repository.save(category);
            response.setMessage("category information updated Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
            response.setObject(category);
        }else {
            response.setMessage("category unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }
    @DeleteMapping("/deleteCategory{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") int id) {
        repository.deleteById(id);
    }
}

