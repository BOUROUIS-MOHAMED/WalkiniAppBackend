
package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/box")
@CrossOrigin
public class BoxController {
    private final BoxRepository repository;
    private  final UtilsController utilsController;
    private final BoostRepository boostRepository;
    private final PlaceRepository placeRepository;
    private final CouponRepository couponRepository;

    private final RarityController rarityController;
    private  final NormalUserRepository normalUserRepository;

    public BoxController(BoxRepository repository, UtilsController utilsController, BoostRepository boostRepository, PlaceRepository placeRepository, CouponRepository couponRepository, RarityController rarityController, NormalUserRepository normalUserRepository) {
        this.repository = repository;
        this.utilsController = utilsController;
        this.boostRepository = boostRepository;
        this.placeRepository = placeRepository;
        this.couponRepository = couponRepository;
        this.rarityController = rarityController;
        this.normalUserRepository = normalUserRepository;
    }


    record CreationRequest( String name, String description, String places, String coins, String boosts, String coupons, Double coinPrice, Double emeraldPrice, Boolean buyInEmerald, Boolean isActive, Integer availableQuantity, Integer leftQuantity, String createdAt, String modifiedAt)  {
    }
    record UpdateRequest(Integer id, String name, String description, String places, String coins, String boosts, String coupons, Double coinPrice, Double emeraldPrice, Boolean buyInEmerald, Boolean isActive, Integer availableQuantity, Integer leftQuantity, String createdAt, String modifiedAt )  {
    }
    ResponseModel response = new ResponseModel();

    @GetMapping("/getById/{id}")
    public ResponseModel getById(@PathVariable Integer id) {
        Optional<BoxModel> model=repository.findById(id);
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




    @PostMapping("/openBox")
    public ResponseModel openBox(@RequestParam Integer userId,@RequestParam Integer boxId) {

        Optional<BoxModel> boxModel=repository.findById(boxId);
        if (boxModel.isPresent()){

            if (boxModel.get().getLeftQuantity()>boxModel.get().getAvailableQuantity()){

                Optional<NormalUserModel> normalUserModel=normalUserRepository.findById(userId);
                if (normalUserModel.isPresent()){
                    Double coinBalance= normalUserModel.get().getCoinBalance();
                    Double emeraldBalance= normalUserModel.get().getEmeraldBalance();
                    Double boxCoinPrice=boxModel.get().getCoinPrice();
                    Double boxEmeraldPrice=boxModel.get().getEmeraldPrice();
                    Double Mineresult=0.0;
                    if (boxModel.get().getBuyInEmerald()){
                        Mineresult=emeraldBalance-boxEmeraldPrice;
                    }else {
                        Mineresult=coinBalance-boxEmeraldPrice;
                    }
                    if (Mineresult>0.0){
                        NormalUserModel userModel=normalUserModel.get();
                        if (boxModel.get().getBuyInEmerald()){
                            userModel.setEmeraldBalance(Mineresult);
                        }else {
                            userModel.setCoinBalance(Mineresult);;
                        }
                        List<Integer> placeList=utilsController.returnListOfIntegerFromString(boxModel.get().getPlaces());
                        List<Integer> couponList=utilsController.returnListOfIntegerFromString(boxModel.get().getCoupons());
                        List<Integer> boostList=utilsController.returnListOfIntegerFromString(boxModel.get().getBoosts());
                        List<Integer> coinList=utilsController.returnListOfIntegerFromString(boxModel.get().getCoins());




                        List<PlaceModel>placeModelList=utilsController.returnPlacesListFromListOfIds(placeList);
                        List<CouponModel>couponModelList=utilsController.returnCouponListFromListOfIds(couponList);
                        List<BoostsModel>boostsModelList=utilsController.returnBoostsListFromListOfIds(boostList);
                        List<BoxContentElement> places=new ArrayList<BoxContentElement>();
                        List<BoxContentElement> coupons=new ArrayList<BoxContentElement>();
                        List<BoxContentElement> boosts=new ArrayList<BoxContentElement>();
                        List<BoxContentElement> coins=new ArrayList<BoxContentElement>();
                        for (PlaceModel placeModel :placeModelList
                        ) {
                            BoxContentElement boxContentElement=new BoxContentElement(placeModel,rarityController.returnRarity(placeModel.getRarity()),placeModel.getId());
                            places.add(boxContentElement);
                        }
                        for (CouponModel couponModel :couponModelList
                        ) {
                            BoxContentElement boxContentElement=new BoxContentElement(couponModel,rarityController.returnRarity(3),couponModel.getId());
                            coupons.add(boxContentElement);
                        }
                        for (BoostsModel boostsModel :boostsModelList
                        ) {
                            BoxContentElement boxContentElement=new BoxContentElement(boostsModel,rarityController.returnRarity(4),boostsModel.getId());
                            boosts.add(boxContentElement);
                        }
                        for (Integer coin :coinList
                        ) {
                            BoxContentElement boxContentElement=new BoxContentElement(coin,rarityController.returnRarity(1),coin);
                            coins.add(boxContentElement);
                        }

             List<List<BoxContentElement>> boxContent=List.of(places,coupons,boosts,coins);
                        int placeCounter=0;
                        int placeRarity=3;
                        int couponCounter=0;
                        int couponRarity=3;
                        int boostCounter=0;
                        int boostRarity=3;
                        int coinCounter=0;
                        int coinRarity=5;
                        Random rand = new Random();

// nextInt as provided by Random is exclusive of the top value, so you need to add 1


                        for (int j=0;j<100;j++){
                            int i = rand.nextInt((boxContent.size() )) ;
                            if (boxContent.get(i)==places){
                                placeCounter=placeCounter+placeRarity;
                            }else if (boxContent.get(i)==coupons){
                                couponCounter=couponCounter+couponRarity;
                            }else if (boxContent.get(i)==boosts){
                                boostCounter=boostCounter+boostRarity;
                            }else if (boxContent.get(i)==coins){
                                coinCounter=coinCounter+coinRarity;
                            }

                        }
                        List<Integer> firstRes = new ArrayList<>();
                        firstRes.add(placeCounter);
                        firstRes.add(couponCounter);
                        firstRes.add(boostCounter);
                        firstRes.add(coinCounter);
                        int index=   firstRes.indexOf(Collections.max(firstRes));
                        List <BoxContentResult>occ=new ArrayList<>();
                        List<Double> listOccurrence=new ArrayList<>();
                        BoxContentElement result=new BoxContentElement();
                        String returnedObjectType="";
                        if (index==0){
                            for (int k=0;k<100;k++){

                                int s = rand.nextInt((places.size() )) ;
                                occ.add(new BoxContentResult(places.get(s),s));
                            }
                            for (int l = 0; l < places.size(); l++) {
                                listOccurrence.add(1.0);
                            }
                            for (int m = 0; m < occ.size(); m++) {

                                listOccurrence.set(occ.get(m).getIndexInMainTable(),(listOccurrence.get(occ.get(m).getIndexInMainTable())+occ.get(m).getBoxContent().getRarity()));
                            }

                            double maxListItem = listOccurrence.stream().max(Comparator.naturalOrder()).get();
                            double minListItem = listOccurrence.stream().min(Comparator.naturalOrder()).get();

                            result=places.get(listOccurrence.indexOf(maxListItem));
                            NormalUserModel user=normalUserModel.get();
                            List<String> idList=utilsController.returnListOfStringsFromString(user.getPlaces());
                            idList.add(result.getObjectId().toString());
                            user.setPlaces(String.join("---",idList));

                            returnedObjectType="places";
                        }else if (index==1){
                            for (int k=0;k<100;k++){

                                int s = rand.nextInt((coupons.size() )) ;
                                occ.add(new BoxContentResult(coupons.get(s),s));
                            }
                            for (int l = 0; l < coupons.size(); l++) {
                                listOccurrence.add(1.0);
                            }
                            for (int m = 0; m < occ.size(); m++) {

                                listOccurrence.set(occ.get(m).getIndexInMainTable(),(listOccurrence.get(occ.get(m).getIndexInMainTable())+occ.get(m).getBoxContent().getRarity()));
                            }

                            double maxListItem = listOccurrence.stream().max(Comparator.naturalOrder()).get();
                            double minListItem = listOccurrence.stream().min(Comparator.naturalOrder()).get();

                            result=coupons.get(listOccurrence.indexOf(maxListItem));
                            NormalUserModel user=normalUserModel.get();
                            List<String> idList=utilsController.returnListOfStringsFromString(user.getCoupons());
                            idList.add(result.getObjectId().toString());
                            user.setCoupons(String.join("---",idList));

                            returnedObjectType="coupons";
                        }else if (index==2){
                            for (int k=0;k<100;k++){

                                int s = rand.nextInt((boosts.size() )) ;
                                occ.add(new BoxContentResult(boosts.get(s),s));
                            }
                            for (int l = 0; l < boosts.size(); l++) {
                                listOccurrence.add(1.0);
                            }
                            for (int m = 0; m < occ.size(); m++) {

                                listOccurrence.set(occ.get(m).getIndexInMainTable(),(listOccurrence.get(occ.get(m).getIndexInMainTable())+occ.get(m).getBoxContent().getRarity()));
                            }

                            double maxListItem = listOccurrence.stream().max(Comparator.naturalOrder()).get();
                            double minListItem = listOccurrence.stream().min(Comparator.naturalOrder()).get();

                            result=boosts.get(listOccurrence.indexOf(maxListItem));
                            NormalUserModel user=normalUserModel.get();
                            List<String> idList=utilsController.returnListOfStringsFromString(user.getBoosts());
                            idList.add(result.getObjectId().toString());
                            user.setBoosts(String.join("---",idList));

                            returnedObjectType="boosts";
                        }else if (index==3){
                            for (int k=0;k<100;k++){

                                int s = rand.nextInt((coins.size() )) ;
                                occ.add(new BoxContentResult(coins.get(s),s));
                            }
                            for (int l = 0; l < coins.size(); l++) {
                                listOccurrence.add(1.0);
                            }
                            for (int m = 0; m < occ.size(); m++) {

                                listOccurrence.set(occ.get(m).getIndexInMainTable(),(listOccurrence.get(occ.get(m).getIndexInMainTable())+occ.get(m).getBoxContent().getRarity()));
                            }

                            double maxListItem = listOccurrence.stream().max(Comparator.naturalOrder()).get();
                            double minListItem = listOccurrence.stream().min(Comparator.naturalOrder()).get();

                            result=coins.get(listOccurrence.indexOf(maxListItem));
                            NormalUserModel user=normalUserModel.get();

                            user.setCoinBalance(user.getCoinBalance()+Double.valueOf( result.getObjectId()));
                            returnedObjectType="coins";
                        }

/*
        response.setMessage("place counter = "+placeCounter+" || "+
                "coupon counter = "+couponCounter+" || "+
                "boost counter = "+boostCounter+" || "+
                "coin counter = "+coinCounter+" || "+
                "and we can say that our system chose "+returnedObjectType+" as a returned type ,where you earn "+result.getName()+" as a gift"+
                "and you can check this object occurrence in this list"+listOccurrence.toString());
*/

                        response.setMessage(returnedObjectType);
                        response.setObject(result.getObject());
                        response.setReturnedBoolean(true);
                        response.setThereIsAnError(false);














                    }else{
                        response.setMessage("Sorry, you can't afford this price");
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


                }else {
                    response.setMessage("user unfounded,please try to log in again");
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

            }else{
                response.setMessage("box is out of stock");
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

        }else {
            response.setMessage("box unfounded");
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



    @PostMapping("/addBoxToUser")
    public ResponseModel addBoxToUser(

    ) {
        return response;
    }



    @GetMapping("/getAllBox")
    public List<BoxModel> getAllBox() {
        return repository.findAll();
    }

    @PostMapping("/createBox")
    public ResponseModel createBox(@RequestBody CreationRequest request )  {
       List<BoxModel> boxModel=repository.findByName(request.name());

        if(boxModel.isEmpty()){
            BoxModel box = new BoxModel();
           box.setCreatedAt(request.createdAt());
           box.setBoosts(request.boosts());
           box.setAvailableQuantity(request.availableQuantity());
           box.setActive(request.isActive());
           box.setModifiedAt(request.modifiedAt());
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

            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(box);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("box already exist");

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


    @PutMapping("/updateBox")
    public ResponseModel updateBox(@RequestBody UpdateRequest request) {

        Optional<BoxModel> boxModel = repository.findById(request.id());
        if (boxModel.isPresent()){
            BoxModel box = boxModel.get();
            box.setCreatedAt(request.createdAt());
            box.setBoosts(request.boosts());
            box.setAvailableQuantity(request.availableQuantity());
            box.setActive(request.isActive());
            box.setModifiedAt(request.modifiedAt());
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
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(box);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("box unfounded");
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
    @DeleteMapping("/deleteBox{boxId}")
    public void deleteBox(@PathVariable("boxId") int id) {
        repository.deleteById(id);



    }
}










class BoxContentElement {
    private Object object;
    private  double rarity;

    private Integer objectId;

    public BoxContentElement() {
    }

    public BoxContentElement(Object object, double rarity, Integer objectId) {
        this.object = object;
        this.rarity = rarity;
        this.objectId = objectId;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public double getRarity() {
        return rarity;
    }

    public void setRarity(double rarity) {
        this.rarity = rarity;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }
}
class  BoxContentResult{
    private BoxContentElement boxContent;
    private  int indexInMainTable;



    public BoxContentResult() {
    }

    public BoxContentResult(BoxContentElement boxContent, int indexInMainTable) {
        this.boxContent = boxContent;
        this.indexInMainTable = indexInMainTable;
    }

    public BoxContentElement getBoxContent() {
        return boxContent;
    }

    public void setBoxContent(BoxContentElement boxContent) {
        this.boxContent = boxContent;
    }

    public int getIndexInMainTable() {
        return indexInMainTable;
    }

    public void setIndexInMainTable(int indexInMainTable) {
        this.indexInMainTable = indexInMainTable;
    }
}


