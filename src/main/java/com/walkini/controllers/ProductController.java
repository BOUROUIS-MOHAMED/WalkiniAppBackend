package com.walkini.controllers;


import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/product")
@CrossOrigin
public class ProductController {
    private final ProductRepository repository;
    private final WaitingProductManagingListRepository waitingProductManagingListRepository;
    private final WaitingProductSellListRepository sellListRepository;
    private final ShopHistoryRepository shopHistoryRepository;

    private final NormalUserRepository normalUserRepository;


    public ProductController(ProductRepository repository, WaitingProductManagingListRepository waitingProductManagingListRepository, WaitingProductSellListRepository sellListRepository, ShopHistoryRepository shopHistoryRepository, NormalUserRepository normalUserRepository) {
        this.repository = repository;

        this.waitingProductManagingListRepository = waitingProductManagingListRepository;
        this.sellListRepository = sellListRepository;
        this.shopHistoryRepository = shopHistoryRepository;
        this.normalUserRepository = normalUserRepository;
    }

    @PostMapping("/userBuyThisProduct")
    public ResponseModel userBuyThisProduct() {
        return response;
    }

    @GetMapping("/getById/{id}")
    public ResponseModel getById(@PathVariable Integer id) {
        Optional<ProductModel> model=repository.findById(id);
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
    @GetMapping("/getProductDemandById/{id}")
    public ResponseModel getProductDemandById(@PathVariable Integer id) {
        Optional<WaitingProductManagingListModel> model=waitingProductManagingListRepository.findById(id);
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
    @GetMapping("/getAllProducts")
    public List<ProductModel> getAllProducts() {
        return repository.findAll();
    }
    @GetMapping("/getAllWaitingProducts")
    public List<WaitingProductManagingListModel> getAllWaitingProducts() {
        return waitingProductManagingListRepository.findAll();
    }
    @GetMapping("/getAllWaitingSellProducts")
    public List<WaitingProductSellListModel> getAllWaitingSellProducts() {
        return sellListRepository.findAll();
    }
    @GetMapping("/getAllShopHistory")
    public List<ShopHistoryModel> getAllShopHistory() {
        return shopHistoryRepository.findAll();
    }



    ResponseModel response = new ResponseModel();

    record NewProductRequest(Integer id, String name, String description, Double coinPrice, Double emeraldPrice,
                             String image, String category, String score, Boolean isOnSale, Long saleLimitTimeInSeconds,
                             Double salePercent, Integer rarity, Integer initialQuantity, Integer leftQuantity,
                             Boolean isDeliverable, Integer owner, Boolean isAvailable, Boolean canUseCoupon,
                             String createdAt, String modifiedAt) {

    }


    @PostMapping("/acceptAddProduct{id}")
    public ResponseModel acceptAddProduct(@PathVariable("id") int id) {
        Optional<WaitingProductManagingListModel> waitingProductModelList = waitingProductManagingListRepository.findById(id);
        if (waitingProductModelList.isPresent()) {
            if (waitingProductModelList.get().getRequestType() == requestType.add) {
                List<ProductModel> productModelList = repository.findByname(waitingProductModelList.get().getName());
                if (productModelList.isEmpty()) {
                    ProductModel product = new ProductModel();
                    product.setAvailable(waitingProductModelList.get().getAvailable());
                    product.setCanUseCoupon(waitingProductModelList.get().getCanUseCoupon());
                    product.setCreatedAt(waitingProductModelList.get().getCreatedAt());
                    product.setCategory(waitingProductModelList.get().getCategory());
                    product.setCoinPrice(waitingProductModelList.get().getCoinPrice());
                    product.setDescription(waitingProductModelList.get().getDescription());
                    product.setDeliverable(waitingProductModelList.get().getDeliverable());
                    product.setEmeraldPrice(waitingProductModelList.get().getEmeraldPrice());
                    product.setImage(waitingProductModelList.get().getImage());
                    product.setInitialQuantity(waitingProductModelList.get().getInitialQuantity());
                    product.setLeftQuantity(waitingProductModelList.get().getLeftQuantity());
                    product.setModifiedAt(waitingProductModelList.get().getModifiedAt());
                    product.setName(waitingProductModelList.get().getName());
                    product.setRarity(waitingProductModelList.get().getRarity());
                    product.setScore(waitingProductModelList.get().getScore());
                    product.setSalePercent(waitingProductModelList.get().getSalePercent());
                    product.setSaleLimitTimeInSeconds(waitingProductModelList.get().getSaleLimitTimeInSeconds());
                    product.setOwner(waitingProductModelList.get().getOwner());
                    product.setOnSale(waitingProductModelList.get().getOnSale());
                    repository.save(product);
                    waitingProductManagingListRepository.deleteById(id);
                    response.setMessage("product Added Successfully");
                    response.setErrorType(ErrorResponseType.Nothing);
                    response.setReturnedBoolean(true);
                    response.setObject(product);
                    response.setErrorCode("20000");
                    response.setThereIsAnError(false);
                    response.setReturnedInteger(null);
                    response.setReturnedList(null);
                    response.setReturnedString(null);
                    response.setReturnedMultipartFile(null);
                } else {
                    response.setMessage("product already exist");
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
            } else {
                response.setMessage("the request type is not add ");
                response.setErrorType(ErrorResponseType.DataCorrupted);
                response.setReturnedBoolean(false);
                response.setObject(null);
                response.setErrorCode("40000");
                response.setThereIsAnError(true);
                response.setReturnedInteger(null);
                response.setReturnedList(null);
                response.setReturnedString(null);
                response.setReturnedMultipartFile(null);
            }

        } else {
            response.setMessage("no product found in the waiting list with this id");
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


    //
    //
    //
    //
    @PostMapping("/createProduct")
    public ResponseModel createNewProduct(@RequestBody NewProductRequest request) {
        List<ProductModel> productModelList = repository.findByname(request.name());
        if (productModelList.isEmpty()) {
            WaitingProductManagingListModel product = new WaitingProductManagingListModel();
            product.setRequestType(requestType.add);
            product.setAvailable(request.isAvailable());
            product.setCanUseCoupon(request.canUseCoupon());
            product.setCreatedAt(request.createdAt());
            product.setCategory(request.category());
            product.setCoinPrice(request.coinPrice());
            product.setDescription(request.description());
            product.setDeliverable(request.isDeliverable());
            product.setEmeraldPrice(request.emeraldPrice());
            product.setImage(request.image());
            product.setInitialQuantity(request.initialQuantity());
            product.setLeftQuantity(request.leftQuantity());
            product.setModifiedAt(request.modifiedAt());
            product.setName(request.name());
            product.setRarity(request.rarity());
            product.setScore(request.score());
            product.setSalePercent(request.salePercent());
            product.setSaleLimitTimeInSeconds(request.saleLimitTimeInSeconds());
            product.setOwner(request.owner());
            product.setOnSale(request.isOnSale());
            waitingProductManagingListRepository.save(product);
            response.setMessage("product Added Successfully to waiting list");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(product);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        } else {
            response.setMessage("product already exist in waiting list");
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


    /******************************************************************************************************************/


    record UpdateProductRequest(Integer id, String name, String description, Double coinPrice, Double emeraldPrice,
                                String image, String category, String score, Boolean isOnSale,
                                Long saleLimitTimeInSeconds, Double salePercent, Integer rarity,
                                Integer initialQuantity, Integer leftQuantity, Boolean isDeliverable, Integer owner,
                                Boolean isAvailable, Boolean canUseCoupon, String createdAt, String modifiedAt) {
    }

    public Boolean isProductAvailable(ProductModel productModel){
        if (productModel.getAvailable() && productModel.getLeftQuantity()>0 ){
            return true;
        }else{
            return false;
        }
    }


    /****UPDATE PRODUCT****/
    @PutMapping("/updateProduct")
    public ResponseModel updateProduct(@RequestBody UpdateProductRequest request) {
        Optional<ProductModel> productModel = repository.findById(request.id());
        if (productModel.isPresent()) {
            List<WaitingProductManagingListModel> waitingProductManagingListModel = waitingProductManagingListRepository.findByModifiedProductId(request.id());
            if (waitingProductManagingListModel.isEmpty()) {
                WaitingProductManagingListModel product = new WaitingProductManagingListModel();
                product.setModifiedProductId(request.id());
                product.setRequestType(requestType.modify);
                product.setAvailable(request.isAvailable());
                product.setCanUseCoupon(request.canUseCoupon());
                product.setCreatedAt(request.createdAt());
                product.setCategory(request.category());
                product.setCoinPrice(request.coinPrice());
                product.setDescription(request.description());
                product.setDeliverable(request.isDeliverable());
                product.setEmeraldPrice(request.emeraldPrice());
                product.setImage(request.image());
                product.setInitialQuantity(request.initialQuantity());
                product.setLeftQuantity(request.leftQuantity());
                product.setModifiedAt(request.modifiedAt());
                product.setName(request.name());
                product.setRarity(request.rarity());
                product.setScore(request.score());
                product.setSalePercent(request.salePercent());
                product.setSaleLimitTimeInSeconds(request.saleLimitTimeInSeconds());
                product.setOwner(request.owner());
                product.setOnSale(request.isOnSale());
                waitingProductManagingListRepository.save(product);
                response.setMessage("product Added Successfully to waiting list");
                response.setErrorType(ErrorResponseType.Nothing);
                response.setReturnedBoolean(true);
                response.setObject(product);
                response.setErrorCode("20000");
                response.setThereIsAnError(false);
                response.setReturnedInteger(null);
                response.setReturnedList(null);
                response.setReturnedString(null);
                response.setReturnedMultipartFile(null);
            } else {
                response.setMessage("already there is a modify request for this product,please wait or call the support team");
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
        } else {
            response.setMessage("product unfounded");
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

    @PutMapping("/acceptUpdateProduct{id}")
    public ResponseModel acceptUpdateProduct(@PathVariable("id") Integer id) {
        Optional<WaitingProductManagingListModel> waitingProductModelList = waitingProductManagingListRepository.findById(id);
        if (waitingProductModelList.isPresent()) {
            if (waitingProductModelList.get().getRequestType() == requestType.modify) {
                Optional<ProductModel> productModelList = repository.findById(waitingProductModelList.get().getModifiedProductId());
                if (!productModelList.isPresent()) {
                    ProductModel product = productModelList.get();
                    product.setAvailable(waitingProductModelList.get().getAvailable());
                    product.setCanUseCoupon(waitingProductModelList.get().getCanUseCoupon());
                    product.setCreatedAt(waitingProductModelList.get().getCreatedAt());
                    product.setCategory(waitingProductModelList.get().getCategory());
                    product.setCoinPrice(waitingProductModelList.get().getCoinPrice());
                    product.setDescription(waitingProductModelList.get().getDescription());
                    product.setDeliverable(waitingProductModelList.get().getDeliverable());
                    product.setEmeraldPrice(waitingProductModelList.get().getEmeraldPrice());
                    product.setImage(waitingProductModelList.get().getImage());
                    product.setInitialQuantity(waitingProductModelList.get().getInitialQuantity());
                    product.setLeftQuantity(waitingProductModelList.get().getLeftQuantity());
                    product.setModifiedAt(waitingProductModelList.get().getModifiedAt());
                    product.setName(waitingProductModelList.get().getName());
                    product.setRarity(waitingProductModelList.get().getRarity());
                    product.setScore(waitingProductModelList.get().getScore());
                    product.setSalePercent(waitingProductModelList.get().getSalePercent());
                    product.setSaleLimitTimeInSeconds(waitingProductModelList.get().getSaleLimitTimeInSeconds());
                    product.setOwner(waitingProductModelList.get().getOwner());
                    product.setOnSale(waitingProductModelList.get().getOnSale());
                    repository.save(product);
                    waitingProductManagingListRepository.deleteById(id);
                    response.setMessage("product modified Successfully");
                    response.setErrorType(ErrorResponseType.Nothing);
                    response.setReturnedBoolean(true);
                    response.setObject(product);
                    response.setErrorCode("20000");
                    response.setThereIsAnError(false);
                    response.setReturnedInteger(null);
                    response.setReturnedList(null);
                    response.setReturnedString(null);
                    response.setReturnedMultipartFile(null);
                } else {
                    response.setMessage("no product found with this id");
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

            } else {
                response.setMessage("cant perform update request in add request");
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

        } else {
            response.setMessage("no product found in the waiting list with this id");
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

    @DeleteMapping("/deleteProduct{productId}")
    public void deleteProduct(@PathVariable("productId") int id) {
        repository.deleteById(id);
    }
    @DeleteMapping("/refuseProductManagementDemand{demandId}")
    public void refuseProductManagement(@PathVariable("demandId") int id) {
        waitingProductManagingListRepository.deleteById(id);
    }


    //BuyProduct
    @PostMapping("/updateProductSellStatus")
    public ResponseModel updateProductSellStatus(@RequestBody UpdateProductSellStatusRequest request) {
        Optional<WaitingProductSellListModel> waitingProductSellListModel = sellListRepository.findById(request.id());
        if (waitingProductSellListModel.isPresent()) {
            if (waitingProductSellListModel.get().getStatus() != ProductSellingStatus.sold) {
                Optional<NormalUserModel> normalUserModel =normalUserRepository.findById(request.userId());
                if (normalUserModel.isPresent()){
                    Double userCoinCredit= normalUserModel.get().getCoinBalance();
                    Double userEmeraldCredit= normalUserModel.get().getEmeraldBalance();
                    String price0=waitingProductSellListModel.get().getBuyingPrice();
                    String priceCurrency=price0.substring(price0.length()-1);
                    String productPrice=price0.substring(0,price0.length()-1);
                    Boolean inEmerald=priceCurrency=="e"?true:false;
                    Double result;
                    if (inEmerald){
                       result= userEmeraldCredit-Double.parseDouble(productPrice);
                    }else {
                        result= userCoinCredit-Double.parseDouble(productPrice);
                    }
                    if (result>=0){
                        Optional<ProductModel> productModelList = repository.findById(waitingProductSellListModel.get().getProductId());
                        if (productModelList.isPresent()) {
                            if (isProductAvailable(productModelList.get())){
                                if (request.status==ProductSellingStatus.sold){
                                    WaitingProductSellListModel product=waitingProductSellListModel.get();
                                    ShopHistoryModel shopHistoryModel =new  ShopHistoryModel();
                                    shopHistoryModel.setBuyer(product.getUserId());
                                    shopHistoryModel.setBuyingQuantity(product.getBuyingQuantity());
                                    shopHistoryModel.setModifiedAt(request.modifiedAt());
                                    shopHistoryModel.setProductID(product.getProductId());
                                    shopHistoryModel.setPrice(product.getBuyingPrice());
                                    shopHistoryModel.setUsedCoupons(product.getCouponId());
                                    shopHistoryModel.setCreatedAt(request.createdAt());
                                    shopHistoryModel.setModifiedAt(request.modifiedAt());
                                    shopHistoryModel.setLogMessage("Today "+request.createdAt()+" the user with id="+ product.getUserId()+
                                            "buy the product with id="+product.getProductId()+"with "+product.getBuyingPrice()+"with this coupon id list "+product.getCouponId());
                                    shopHistoryRepository.save(shopHistoryModel);
                                    product.setMessage(request.message());
                                    product.setStatus(request.status());
                                    product.setModifiedAt(request.modifiedAt());
                                    sellListRepository.save(product);
                                    Integer x=(productModelList.get().getLeftQuantity())-product.getBuyingQuantity();
                                    ProductModel productModel = productModelList.get();
                                    productModel.setLeftQuantity(x);
                                    repository.save(productModel);
                                    NormalUserModel userModel=normalUserModel.get();
                                    if (inEmerald){
                                        userModel.setEmeraldBalance(result);
                                    }else {
                                        userModel.setCoinBalance(result);
                                    }
                                    normalUserRepository.save(userModel);
                                    response.setMessage("product sold  Successfully");
                                    response.setErrorType(ErrorResponseType.Nothing);
                                    response.setReturnedBoolean(true);
                                    response.setObject(product);
                                    response.setErrorCode("20000");
                                    response.setThereIsAnError(false);
                                    response.setReturnedInteger(null);
                                    response.setReturnedList(null);
                                    response.setReturnedString(null);
                                    response.setReturnedMultipartFile(null);

                                }else {
                                    WaitingProductSellListModel product =waitingProductSellListModel.get();
                                    product.setMessage(request.message());
                                    product.setStatus(request.status());
                                    product.setModifiedAt(request.modifiedAt());
                                    sellListRepository.save(product);
                                    response.setMessage("product status modified Successfully");
                                    response.setErrorType(ErrorResponseType.Nothing);
                                    response.setReturnedBoolean(true);
                                    response.setObject(product);
                                    response.setErrorCode("20000");
                                    response.setThereIsAnError(false);
                                    response.setReturnedInteger(null);
                                    response.setReturnedList(null);
                                    response.setReturnedString(null);
                                    response.setReturnedMultipartFile(null);
                                }

                            }else {
                                response.setMessage("product is unavailable");
                                response.setErrorType(ErrorResponseType.Nothing);
                                response.setReturnedBoolean(false);
                                response.setObject(null);
                                response.setErrorCode("40000");
                                response.setThereIsAnError(true);
                                response.setReturnedInteger(null);
                                response.setReturnedList(null);
                                response.setReturnedString(null);
                                response.setReturnedMultipartFile(null);
                            }
                        } else {
                            response.setMessage("product not available in dataBase");
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
                    }else {
                        response.setMessage("this user don't have enough credit");
                        response.setErrorType(ErrorResponseType.NotEnoughCredit);
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
                    response.setMessage("user unfounded ");
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

            } else {
                response.setMessage("this product already sold ");
                response.setErrorType(ErrorResponseType.DataCorrupted);
                response.setReturnedBoolean(false);
                response.setObject(null);
                response.setErrorCode("40000");
                response.setThereIsAnError(true);
                response.setReturnedInteger(null);
                response.setReturnedList(null);
                response.setReturnedString(null);
                response.setReturnedMultipartFile(null);
            }

        } else {
            response.setMessage("no product found in the sell list with this id");
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


    //
    //
    //
    //
    record BuyProductRequest(Integer id, Integer userId, Integer productId, Integer buyingQuantity, String buyingPrice,
                             Integer couponId, ProductSellingStatus status, String message, String createdAt,
                             String modifiedAt) {
    }
    record UpdateProductSellStatusRequest(Integer id, Integer userId, Integer productId, Integer buyingQuantity, String buyingPrice,
                                          Integer couponId, ProductSellingStatus status, String message, String createdAt,
                                          String modifiedAt) {
    }

    @PostMapping("/BuyProduct")
    public ResponseModel buyProduct(@RequestBody BuyProductRequest request) {
        Optional<ProductModel> productModelList = repository.findById(request.productId());
        if (productModelList.isPresent()) {
            ProductModel product = productModelList.get();
            Integer leftQuantity=product.getLeftQuantity()- request.buyingQuantity;
            if(leftQuantity>=0){
                WaitingProductSellListModel waitingProductSellListModel=new WaitingProductSellListModel();
                waitingProductSellListModel.setBuyingPrice(request.buyingPrice());
                waitingProductSellListModel.setBuyingQuantity(request.buyingQuantity());
                waitingProductSellListModel.setCouponId(request.couponId());
                waitingProductSellListModel.setProductId(request.productId());
                waitingProductSellListModel.setStatus(ProductSellingStatus.waiting);
                waitingProductSellListModel.setUserId(request.userId());
                waitingProductSellListModel.setMessage("This demand is under processing");
                waitingProductSellListModel.setCreatedAt(request.createdAt());
                waitingProductSellListModel.setModifiedAt(request.modifiedAt());
                sellListRepository.save(waitingProductSellListModel);
                response.setMessage("Your order is sent to the product owner,Please wait until he contact you,your balance will not changed until the product owner accept your demand, Thank you");
                response.setErrorType(ErrorResponseType.Nothing);
                response.setReturnedBoolean(true);
                response.setObject(null);
                response.setErrorCode("20000");
                response.setThereIsAnError(false);
                response.setReturnedInteger(null);
                response.setReturnedList(null);
                response.setReturnedString(null);
                response.setReturnedMultipartFile(null);
            }else {
                response.setMessage("Sorry but we dont have this quantity, just "+product.getLeftQuantity()+" item(s) left for this product");
                response.setErrorType(ErrorResponseType.ProductQuantityError);
                response.setReturnedBoolean(false);
                response.setObject(null);
                response.setErrorCode("40000");
                response.setThereIsAnError(true);
                response.setReturnedInteger(null);
                response.setReturnedList(null);
                response.setReturnedString(null);
                response.setReturnedMultipartFile(null);
            }
        } else {
            response.setMessage("no product found in the dataBase");
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


}
