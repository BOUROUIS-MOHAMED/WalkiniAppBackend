package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.ErrorResponseType;
import com.walkini.models.FileData;
import com.walkini.models.ImageData;
import com.walkini.models.ResponseModel;
import com.walkini.repositories.FileDataRepository;
import com.walkini.repositories.StorageRepository;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/file")
@CrossOrigin
public class StorageController {
    private final StorageRepository repository;
    private final FileDataRepository fileDataRepository;

    public StorageController(StorageRepository repository, FileDataRepository fileDataRepository) {
        this.repository = repository;
        this.fileDataRepository = fileDataRepository;
    }

    public String uploadImage( MultipartFile file) throws IOException {
        ImageData imageData=new ImageData();
        imageData.setName(file.getOriginalFilename());
        imageData.setType(file.getContentType());
        imageData.setImageData(ImageUtils.compressImage(file.getBytes()));
       repository.save(imageData);


       if(imageData!=null){
           return  "file uploaded successfuly :" + file.getOriginalFilename();
       }
        return null;
    }




    public byte[] downloadImage( String fileName)  {
       Optional<ImageData> imageData= repository.findByName(fileName);


     byte[] images=ImageUtils.decompressImage(imageData.get().getImageData());
return  images;
    }
ResponseModel response =new ResponseModel();

@PostMapping("/uploadImage")
    public ResponseModel upIm(@RequestParam MultipartFile image) throws IOException {
 String s= uploadImage(image);
  response.setMessage(s);
  return response;
}
    @PostMapping("/downloadImage")
    public ResponseModel dwIm(@RequestParam String name) throws IOException {
        byte[] s= downloadImage(name);
        response.setObject(s);
        return response;
    }

    @PostMapping("/test")
    public ResponseModel test() throws IOException {

        response.setMessage("passed");
        return response;
    }






    public ResponseModel uploadImageToFileSystem(MultipartFile file, String imageName) throws IOException {
        String rootPath=  new FileSystemResource("").getFile().getAbsolutePath();

        String filename = file.getOriginalFilename();     // full file name
        int iend = filename.lastIndexOf("."); //this finds the first occurrence of "."


        String subString;
        if (iend != -1)
        {
            subString= filename.substring(iend , filename.length()); //this will give abc
        }else {
            subString=".png";
        }

        String filePath=rootPath+"/src/main/resources/static/uploadedFiles/"+imageName+subString;
        String path="/src/main/resources/static/uploadedFiles/"+imageName+subString;
        file.transferTo(new File(filePath));
        FileData fileData=new FileData();


        fileData.setName(file.getOriginalFilename());
        fileData.setType(file.getContentType());
        fileData.setFilePath(filePath);
        fileDataRepository.save(fileData);


        if(fileData!=null){
            response.setMessage(path);
            response.setErrorType(ErrorResponseType.Nothing);
            response.setErrorCode("20000");
            response.setObject(null);
            response.setReturnedBoolean(true);
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
            response.setThereIsAnError(false);
            return
                    response;
        }
        response.setMessage(null);
        response.setErrorType(ErrorResponseType.Nothing);
        response.setErrorCode("40000");
        response.setObject(null);
        response.setReturnedBoolean(false);
        response.setThereIsAnError(true);
        response.setReturnedInteger(null);
        response.setReturnedList(null);
        response.setReturnedString(null);
        response.setReturnedMultipartFile(null);
        response.setThereIsAnError(false);
        return
                response;
    }
    public byte[] downloadImageFromFileSystem( String fileName) throws IOException {
        Optional<FileData> fileData= fileDataRepository.findByName(fileName);
        String rootPath=  new FileSystemResource("").getFile().getAbsolutePath();

        String filePath=rootPath+"/src/main/resources/static/uploadedFiles/"+fileName;


        byte[] images= Files.readAllBytes(new File(filePath).toPath());

        return  images;
    }
    @PostMapping("/uploadImageToFileSystem")
    public ResponseModel upImToFS(@RequestParam MultipartFile image, @RequestParam String name) throws IOException {

        return uploadImageToFileSystem(image,name);
    }
    @PostMapping("/uploadProfileImageToFileSystem")
    public ResponseModel upPImToFS(@RequestParam MultipartFile image, @RequestParam String name) throws IOException {
      return  uploadImageToFileSystem(image,name);
    }
    @PostMapping("/downloadImageToFileSystem")
    public ResponseEntity dwImToFS(@RequestParam String name) throws IOException {
        byte[] s= downloadImageFromFileSystem(name);


        return  ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(s);
    }



}
