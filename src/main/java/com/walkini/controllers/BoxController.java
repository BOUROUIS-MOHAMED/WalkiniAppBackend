
package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.BoostsModel;
import com.walkini.models.BoxModel;
import com.walkini.models.ErrorResponseType;
import com.walkini.models.Response;
import com.walkini.repositories.BoxRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/box")
@CrossOrigin
public class BoxController {
    private final BoxRepository repository;

    public BoxController(BoxRepository repository) {
        this.repository = repository;
    }


    record CreationRequest(Integer id, String name, String description, String places, String coins, String boosts, String coupons, String coinPrice, String emeraldPrice, boolean buyInEmerald, Long duration, String availableQuantity, String leftQuantity, Timestamp createdAt)  {
    }
    record UpdateRequest(Integer id, String name, String description, String places, String coins, String boosts, String coupons, String coinPrice, String emeraldPrice, boolean buyInEmerald, Long duration, String availableQuantity, String leftQuantity, Timestamp modifiedAt )  {
    }
    Response response = new Response();

    @PostMapping("/openBox")
    public Response openBox(

    ) {
        return response;
    }
    @PostMapping("/addBoxToUser")
    public Response addBoxToUser(

    ) {
        return response;
    }


    @GetMapping("/getAllBox")
    public List<BoxModel> getAllBox() {
        return repository.findAll();
    }
    @GetMapping("/getBox{boxId}")
    public Response getBox(@RequestParam String boxId) {
        int id = Integer.parseInt(boxId);

        if (repository.existsById(id)) {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("box founded");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setObject(repository.findById(id));

        } else {
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setMessage("box unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
        }
        return response;


    }

    @PostMapping("/createBox")
    public Response createBox(@RequestBody CreationRequest request )  {

        ExampleMatcher matching = ExampleMatcher.matching()
                .withMatcher("boxName", ExampleMatcher.GenericPropertyMatchers.ignoreCase());
        Example<BoxModel> example = Example.<BoxModel>of(new BoxModel(request.name()), matching);
        boolean exists = repository.exists(example);
        if(exists){
            BoxModel box = new BoxModel();
           box.setCreatedAt(request.createdAt());
           box.setBoosts(request.boosts());
           box.setAvailableQuantity(request.availableQuantity());
           box.setBoxDurationInSeconds(request.duration());
           box.setCoins(request.coins());
           box.setCoupons(request.coupons());
           box.setName(request.name());
           box.setDescription(request.description());
           box.setBuyInEmerald(request.buyInEmerald());
           box.setEmeraldPrice(request.emeraldPrice());
           box.setCoinPrice(request.coinPrice());
           box.setLeftQuantity(request.availableQuantity());
           box.setPlaces(request.places());
            //ban
            //message
            repository.save(box);
            response.setMessage("box Added Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
        }else {
            response.setMessage("box already exist");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }


    @PutMapping("/updateBox")
    public Response updateBox(@RequestBody UpdateRequest request) {
        BoxModel box = new BoxModel();
        Optional<BoxModel> boxModel = repository.findById(request.id());
        if (boxModel.isPresent()){
            box.setModifiedAt(request.modifiedAt());
            box.setBoosts(request.boosts());
            box.setAvailableQuantity(request.availableQuantity());
            box.setBoxDurationInSeconds(request.duration());
            box.setCoins(request.coins());
            box.setCoupons(request.coupons());
            box.setName(request.name());
            box.setDescription(request.description());
            box.setBuyInEmerald(request.buyInEmerald());
            box.setEmeraldPrice(request.emeraldPrice());
            box.setCoinPrice(request.coinPrice());
            box.setLeftQuantity(request.availableQuantity());
            box.setPlaces(request.places());
            //ban
            //message
            repository.save(box);
            response.setMessage("box information updated Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
            response.setObject(box);
        }else {
            response.setMessage("action unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }
    @DeleteMapping("/deleteBox{boxId}")
    public void deleteBox(@PathVariable("boxId") int id) {
        repository.deleteById(id);
    }
}

