
package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.CharityCategoryRepository;
import com.walkini.repositories.ProductCategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/category")
@CrossOrigin
public class CategoryController {
    private final ProductCategoryRepository productCategoryRepository;

    private final CharityCategoryRepository charityCategoryRepository;
    public CategoryController(ProductCategoryRepository productCategoryRepository, CharityCategoryRepository charityCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
        this.charityCategoryRepository = charityCategoryRepository;
    }



    record ProductCategoryCreationRequest(Integer id, String categoryName, String icon, String createdAt, String modifiedAt){}
    record ProductCategoryUpdateRequest(Integer id, String categoryName, String icon, String createdAt, String modifiedAt){}
    ResponseModel response = new ResponseModel();

    @GetMapping("/charityCategory/getById/{id}")
    public ResponseModel getCharityCategoryById(@PathVariable Integer id) {
        Optional<CharityCategoryModel> model=charityCategoryRepository.findById(id);
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
    @GetMapping("/productCategory/getById/{id}")
    public ResponseModel getProductCategoryById(@PathVariable Integer id) {
        Optional<ProductCategoryModel> model=productCategoryRepository.findById(id);
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

    @GetMapping("/getAllProductCategories")
    public List<ProductCategoryModel> getAllProductCategories() {
        return productCategoryRepository.findAll();
    }


    @PostMapping("/createProductCategory")
    public ResponseModel createProductCategory(@RequestBody ProductCategoryCreationRequest request )  {

       List<ProductCategoryModel> productCategoryModelList=productCategoryRepository.findBycategoryName(request.categoryName());
        if(productCategoryModelList.isEmpty()){
            ProductCategoryModel productCategoryModel = new ProductCategoryModel();
           productCategoryModel.setCategoryName(request.categoryName());
           productCategoryModel.setIcon(request.icon());
           productCategoryModel.setCreatedAt(request.createdAt());
           productCategoryModel.setModifiedAt(request.modifiedAt());
            productCategoryRepository.save(productCategoryModel);
            response.setMessage("category Added Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setErrorCode("20000");
            response.setObject(productCategoryModel);
            response.setReturnedBoolean(true);
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
            response.setThereIsAnError(false);
        }else {
            response.setMessage("category already exist");
            response.setErrorType(ErrorResponseType.DataAlreadyExist);
            response.setErrorCode("40000");
            response.setObject(null);
            response.setReturnedBoolean(false);
            response.setThereIsAnError(true);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
            response.setThereIsAnError(false);
        }
        return response;
    }


    @PutMapping("/updateProductCategory")
    public ResponseModel updateProductCategory(@RequestBody ProductCategoryUpdateRequest request) {

        Optional<ProductCategoryModel> productCategoryModel = productCategoryRepository.findById(request.id());
        if (productCategoryModel.isPresent()){
            ProductCategoryModel category = productCategoryModel.get();
            category.setCategoryName(request.categoryName());
           category.setModifiedAt(request.modifiedAt());
           category.setIcon(request.icon());
           category.setCreatedAt(request.createdAt());
            productCategoryRepository.save(category);
            response.setMessage("category information updated Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setErrorCode("20000");
            response.setObject(category);
            response.setReturnedBoolean(true);
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
            response.setThereIsAnError(false);
        }else {
            response.setMessage("category unfounded");
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setErrorCode("40000");
            response.setObject(null);
            response.setReturnedBoolean(false);
            response.setThereIsAnError(true);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
            response.setThereIsAnError(false);
        }
        return response;
    }
    @DeleteMapping("/deleteProductCategory{productCategoryId}")
    public void deleteProductCategory(@PathVariable("productCategoryId") int id) {
        productCategoryRepository.deleteById(id);
    }




















   record CharityCategoryCreationRequest(Integer id, String categoryName, String icon, String createdAt, String modifiedAt){}
    record CharityCategoryUpdateRequest(Integer id, String categoryName, String icon, String createdAt, String modifiedAt){}
        @GetMapping("/getAllCharityCategories")
    public List<CharityCategoryModel> getAllCharityCategories() {
        return charityCategoryRepository.findAll();
    }


    @PostMapping("/createCharityCategory")
    public ResponseModel createCharityCategory(@RequestBody CharityCategoryCreationRequest request )  {

        List<CharityCategoryModel> charityCategoryModelList=charityCategoryRepository.findByCategoryName(request.categoryName());
        if(charityCategoryModelList.isEmpty()){
            CharityCategoryModel charityCategoryModel = new CharityCategoryModel();
            charityCategoryModel.setCategoryName(request.categoryName());
            charityCategoryModel.setIcon(request.icon());
            charityCategoryModel.setCreatedAt(request.createdAt());
            charityCategoryModel.setModifiedAt(request.modifiedAt());

            charityCategoryRepository.save(charityCategoryModel);
            response.setMessage("category Added Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setErrorCode("20000");
            response.setObject(charityCategoryModel);
            response.setReturnedBoolean(true);
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
            response.setThereIsAnError(false);
        }else {
            response.setMessage("category already exist");
            response.setErrorType(ErrorResponseType.DataAlreadyExist);
            response.setErrorCode("40000");
            response.setObject(null);
            response.setReturnedBoolean(false);
            response.setThereIsAnError(true);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
            response.setThereIsAnError(false);
        }
        return response;
    }


    @PutMapping("/updateCharityCategory")
    public ResponseModel updateCharityCategory(@RequestBody CharityCategoryUpdateRequest request) {

        Optional<CharityCategoryModel> charityCategoryModel = charityCategoryRepository.findById(request.id());
        if (charityCategoryModel.isPresent()){
            CharityCategoryModel category = charityCategoryModel.get();
            category.setCategoryName(request.categoryName());
            category.setModifiedAt(request.modifiedAt());
            category.setIcon(request.icon());
            category.setCreatedAt(request.createdAt());
            charityCategoryRepository.save(category);
            response.setMessage("category information updated Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setErrorCode("20000");
            response.setObject(category);
            response.setReturnedBoolean(true);
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
            response.setThereIsAnError(false);
        }else {
            response.setMessage("category unfounded");
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setErrorCode("40000");
            response.setObject(null);
            response.setReturnedBoolean(false);
            response.setThereIsAnError(true);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
            response.setThereIsAnError(false);
        }
        return response;
    }
    @DeleteMapping("/deleteCharityCategory{charityCategoryId}")
    public void deleteCharityCategory(@PathVariable("charityCategoryId") int id) {
        productCategoryRepository.deleteById(id);
    }
}

