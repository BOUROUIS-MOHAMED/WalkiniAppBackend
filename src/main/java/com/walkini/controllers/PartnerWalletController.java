
package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.PartnerWalletRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/partnerWallet")
@CrossOrigin
public class PartnerWalletController {
    private final PartnerWalletRepository repository;
    private final ProfileController profileController;

    public PartnerWalletController(PartnerWalletRepository repository, ProfileController profileController) {
        this.repository = repository;
        this.profileController = profileController;
    }


    record CreationRequest( Integer profileType, Integer userId, Double partnerMoney, String soledProducts, String products, Timestamp createdAt, Timestamp modifiedAt) {
    }
    record UpdateRequest(String id, Integer profileType, Integer userId, Double partnerMoney, String soledProducts, String products, Timestamp createdAt, Timestamp modifiedAt) {
    }
    Response response = new Response();

    @GetMapping("/getUserPartnerWallet")
    public Optional<PartnerWalletModel> getUserPartnerWallet(@RequestParam Integer id) {
        return repository.findById(id);
    }


    @GetMapping("/getAllPartnerWallet")
    public List<PartnerWalletModel> getAllPartnerWallet() {
        return repository.findAll();
    }
    @GetMapping("/getPartnerWallet{partnerWalletId}")
    public Response getPartnerWallet(@RequestParam String partnerWalletId) {
        int id = Integer.parseInt(partnerWalletId);

        if (repository.existsById(id)) {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("partner wallet founded");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setObject(repository.findById(id));

        } else {
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setMessage("partner wallet unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
        }
        return response;


    }
    @GetMapping("/getPartnerWalletByOwner{Id}")
    public Response getPartnerWalletByOwner(@RequestParam String Id) {
        int id = Integer.parseInt(Id);
        if (profileController.checkUserExist(Id)){

            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("coupon for user founded");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setObject(repository.findByuserIdEquals(id));
        }else{
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setMessage("coupon for user not founded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);







        }
        return response;


    }

    @PostMapping("/createPartnerWallet")
    public Response createPartnerWallet(@RequestBody CreationRequest request )  {

        ExampleMatcher matching = ExampleMatcher.matching()
                .withMatcher("userId", ExampleMatcher.GenericPropertyMatchers.ignoreCase());
        Example<PartnerWalletModel> example = Example.<PartnerWalletModel>of(new PartnerWalletModel(request.userId()), matching);
        boolean exists = repository.exists(example);
        if(exists){
            PartnerWalletModel partnerWallet = new PartnerWalletModel();
           partnerWallet.setCreatedAt(request.createdAt());
           partnerWallet.setPartnerMoney(request.partnerMoney());
           partnerWallet.setProducts(request.products());
           partnerWallet.setModifiedAt(request.createdAt());
           partnerWallet.setSoledProducts(request.soledProducts());
           partnerWallet.setUserId(request.userId());

            //ban
            //message
            repository.save(partnerWallet);
            response.setMessage("partner wallet Added Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
        }else {
            response.setMessage("partner wallet already exist");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }


    @PutMapping("/updatePartnerWallet")
    public Response updatePartnerWallet(@RequestBody UpdateRequest request) {
        PartnerWalletModel partnerWallet = new PartnerWalletModel();
        Optional<PartnerWalletModel> partnerWalletModel = repository.findById(Integer.valueOf(request.id()));
        if (partnerWalletModel.isPresent()){

            partnerWallet.setCreatedAt(request.createdAt());
            partnerWallet.setPartnerMoney(request.partnerMoney());
            partnerWallet.setProducts(request.products());
            partnerWallet.setModifiedAt(request.modifiedAt());
            partnerWallet.setSoledProducts(request.soledProducts());
            partnerWallet.setUserId(request.userId());

            //ban
            //message
            repository.save(partnerWallet);
            response.setMessage("partner wallet information updated Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
            response.setObject(partnerWalletModel);
        }else {
            response.setMessage("partner wallet unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }
    @DeleteMapping("/deletePartnerWallet{id}")
    public void deletePartnerWallet(@PathVariable("id") int id) {
        repository.deleteById(id);
    }
}

