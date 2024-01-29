package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

import com.example.demo.entity.ImageData;
import com.example.demo.service.ImageDataService;


@RestController
@RequestMapping("/image")
public class ImageDataController {
    
    @Autowired
	public ImageDataService imageDataService;

    @PostMapping("/{tipo}/{id}")//, headers="Content-Type=application/json")
	public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file, @PathVariable("tipo") String tipofoto, @PathVariable("id") int idutente) throws IOException {
	    String response = imageDataService.uploadImage(file, tipofoto, idutente);
	    System.out.print(response);
	    return ResponseEntity.status(HttpStatus.OK).body(response);
	}

    @GetMapping("/{name}")
	public ResponseEntity<?>  getImageByName(@PathVariable String name){
	    byte[] image = imageDataService.getImage(name);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
	}

    @GetMapping("/tipofoto/{tipofoto}/{idutente}")
	public ResponseEntity<?>  getProfilo(@PathVariable String tipofoto, @PathVariable String idutente){
	    byte[] image = imageDataService.getProfilo(tipofoto, Integer.parseInt(idutente));
	    System.out.println("getimageprofilo");
	    return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
	}

    @GetMapping("/all/all")
	    public List<byte[]>  getAll(){
	    	List<ImageData> images = imageDataService.getAll();
	    	List<byte[]> response = new ArrayList<byte[]>();
	    	images.forEach(image -> {
    	        response.add(image.getImageData());
    	    });
	    	return response;
	    }
}
