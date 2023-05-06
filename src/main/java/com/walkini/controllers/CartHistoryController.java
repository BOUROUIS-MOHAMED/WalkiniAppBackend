
package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.CartHistoryRepository;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/cartHistory")
@CrossOrigin
public class CartHistoryController {
    private final CartHistoryRepository repository;
    private final ProfileController profileController;

    public CartHistoryController(CartHistoryRepository repository, ProfileController profileController) {
        this.repository = repository;
        this.profileController = profileController;
    }


    record CreationRequest(Integer id, Integer user, String products, String totalPrice, String couponsUsed, Timestamp createdAt, Timestamp modifiedAt)  {
    }
    record UpdateRequest( Integer id, String user, String products, String totalPrice, String couponsUsed, Timestamp createdAt, Timestamp modifiedAt)  {
    }
    Response response = new Response();

    @GetMapping("/getAllCartHistory")
    public List<CartHistoryModel> getAllCartHistory() {
        return repository.findAll();
    }
    @GetMapping("/getCartHistoryByUser{x}")
    public Response getUser(@RequestParam String userId) {
        int id = Integer.parseInt(userId);
        if (profileController.checkUserExist(userId)){

            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("products for user founded");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setObject(repository.findByuserIdEquals(id));
        }else{
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setMessage("products for user not founded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);







        }
        return response;


    }

    @PostMapping("/createCartHistory")
    public Response createCartHistory(@RequestBody CreationRequest request )  {
        CartHistoryModel cartHistory = new CartHistoryModel();
        cartHistory.setCreatedAt(request.createdAt());
        cartHistory.setCouponsUsed(request.couponsUsed());
        cartHistory.setProducts(request.products());
        cartHistory.setUserId(request.user());
        cartHistory.setTotalPrice(request.totalPrice());

        //message
        repository.save(cartHistory);
        response.setMessage("cart history Added Successfully");
        response.setErrorCode(20000);
        response.setThereIsAnError(false);
        response.setErrorType(ErrorResponseType.Nothing);
        return response;
    }


    @DeleteMapping("/deleteCartHistory{cartHistory}")
    public void deleteCartHistory(@PathVariable("cartHistory") int id) {
        repository.deleteById(id);
    }
}

