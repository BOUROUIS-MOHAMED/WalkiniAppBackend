package com.walkini.controllers;


import com.walkini.models.*;
import com.walkini.repositories.ProductRepository;
import com.walkini.repositories.ProfileRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;


import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.walkini.AppConstants;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/product")
@CrossOrigin
public class ProductController {
    private final ProductRepository repository;
    private final ProfileRepository profileRepository;

    private  final ProfileController profileController;


    public ProductController(ProductRepository repository, ProfileRepository profileRepository, ProfileController profileController) {
        this.repository = repository;

        this.profileRepository = profileRepository;
        this.profileController = profileController;
    }

    @PostMapping("/userBuyThisProduct")
    public Response userBuyThisProduct() {
        return response;
    }
    @PostMapping("/reviewThisProduct")
    public Response reviewThisProduct() {
        return response;
    }


    @GetMapping("/getAllProducts")
    public List<ProductModel> getAllProducts() {
        return repository.findAll();
    }

    @GetMapping("/getProductByOwner{x}")
    public Response getUser(@RequestParam String userId) {
        int id = Integer.parseInt(userId);
        if (profileController.checkUserExist(userId)){

            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("products for user founded");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setObject(repository.findByownerEquals(id));
        }else{
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setMessage("products for user not founded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
       

       
         

       
            
        }
        return response;


    }


    Response response = new Response();

    record NewProductRequest(Integer id,
                             String name,
                             String coinPrice,
                             String emeraldPrice,
                             String image,
                             String category,
                             String score,
                             Boolean isOnSale,
                             Long saleLimitTime,
                             Double salePercent,
                             Integer rarity,
                             Integer initialQuantity,
                             Boolean isDeliverable,
                             String deliveryPrice,
                             Integer owner,

                             Boolean isAvailable,
                             Timestamp createdAt
                             )  {
    }
    


    @PostMapping("/createProduct")
    public Response createProduct(@RequestBody NewProductRequest request) {

        ExampleMatcher productNameMatching = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.ignoreCase());
        Example<ProductModel> example = Example.<ProductModel>of(new ProductModel(request.name()), productNameMatching);
        boolean productExists = repository.exists(example);
        if(productExists){
            ProductModel product = new ProductModel();
            product.setName(request.name());
            product.setCategory(request.category());
            product.setImage(request.image());
            product.setDeliverable(request.isDeliverable());
            product.setCoinPrice(request.coinPrice());
            product.setEmeraldPrice(request.emeraldPrice());
            product.setScore("5");
            product.setDeliveryPrice(request.deliveryPrice());
            product.setInitialQuantity(request.initialQuantity());
            product.setOnSale(request.isOnSale());
            product.setLeftQuantity(request.initialQuantity());
            product.setOwner(request.owner());
            product.setRarity(request.rarity());
            product.setSaleLimitTimeInSeconds(request.saleLimitTime());
            product.setSalePercent(request.salePercent());
            product.setAvailable(request.isAvailable());
            product.setCreatedAt(request.createdAt());
           
            //ban
            //message
            repository.save(product);
            response.setMessage("product Added Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
        }else {
            response.setMessage("product already exist");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }








    /******************************************************************************************************************/



    record UpdateProductRequest(Integer id,
                                String name,
                                String coinPrice,
                                String emeraldPrice,
                                String image,
                                String category,
                                String score,
                                Boolean isOnSale,
                                Long saleLimitTime,
                                Double salePercent,
                                Integer rarity,
                                Integer initialQuantity,
                                Integer leftQuantity,
                                Boolean isDeliverable,
                                String deliveryPrice,
                                Integer owner,
                                Boolean isAvailable,
                                Timestamp modifiedAt) {
    }

    /****UPDATE PRODUCT****/
    @PutMapping("/updateProduct")
    public Response updateProduct(@RequestBody UpdateProductRequest request) {

        boolean productExists = repository.existsById(request.id());
        ProductModel product = new ProductModel();
        Optional<ProductModel> productModel = repository.findById(request.id());
        if (productModel.isPresent()){

            product.setName(request.name());
            product.setCategory(request.category());
            product.setImage(request.image());
            product.setDeliverable(request.isDeliverable());
            product.setCoinPrice(request.coinPrice());
            product.setEmeraldPrice(request.emeraldPrice());
            product.setScore("5");
            product.setDeliveryPrice(request.deliveryPrice());
            product.setInitialQuantity(request.initialQuantity());
            product.setOnSale(request.isOnSale());
            product.setLeftQuantity(request.initialQuantity());
            product.setOwner(request.owner());
            product.setRarity(request.rarity());
            product.setSaleLimitTimeInSeconds(request.saleLimitTime());
            product.setSalePercent(request.salePercent());
            product.setAvailable(request.isAvailable());
            product.setModifiedAt(request.modifiedAt());

            //ban
            //message
            repository.save(product);
            response.setObject(product);
            response.setMessage("product updated Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
        }else {
            response.setMessage("product unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }

    @DeleteMapping("/deleteProduct{productId}")
    public void deleteProduct(@PathVariable("productId") int id) {
        repository.deleteById(id);
    }


}
