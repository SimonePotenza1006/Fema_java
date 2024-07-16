package com.example.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Base64;
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
import java.util.stream.Collectors;
import com.example.demo.entity.Azienda;
import com.example.demo.entity.ImmagineAzienda;
import com.example.demo.repository.AziendaRepository;
import com.example.demo.service.ImmagineAziendaService;
import com.example.demo.util.ImageUtil;

@RestController
@RequestMapping("api/immagineAzienda")
public class ImmagineAziendaController {
    
    @Autowired
    public ImmagineAziendaService immagineService;

    @Autowired
    public AziendaRepository aziendaRepository;

    @PostMapping("azienda/{id}")
    public ResponseEntity<?> uploadImageAzienda(@RequestParam("azienda") MultipartFile file,
            @PathVariable("id") int aziendaId) throws IOException{
                Optional<Azienda> optionalAzienda = aziendaRepository.findById(aziendaId);
                String response = immagineService.uploadImageAzienda(file, aziendaId);
                try{
                    Path path = Files.createDirectories(Paths.get("C:\\APP_FEMA\\Loghi_aziende\\"+optionalAzienda.get().getNome()));
                    Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()));
                    System.out.println("File is created!");
                } catch(IOException e){
                    System.err.println("Failed to create directory!" + e.getMessage());
                }
                System.out.print(response);
	            return ResponseEntity.status(HttpStatus.OK)
	                .body(response);
    }

    @GetMapping(value = "/azienda/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ImageWrapper>> getImagesByAzienda(@PathVariable int aziendaId){
        List<ImmagineAzienda> images = immagineService.getImageByAzienda(aziendaId);
        List<byte[]> imageBytes = images.stream()
            .map(image -> ImageUtil.decompressImage(image.getImageData()))
            .collect(Collectors.toList());

            List<ImageWrapper> imageWrappers = new ArrayList<>();
            for(byte[] imageData : imageBytes){
                ImageWrapper wrapper = new ImageWrapper();
                wrapper.setImageData(imageData);
                imageWrappers.add(wrapper);
            }
            return ResponseEntity.ok(imageWrappers);
    }

    class ImageWrapper {
        private String imageData;
    
        public String getImageData() {
            return imageData;
        }
    
        public void setImageData(byte[] imageData) {
            this.imageData = Base64.getEncoder().encodeToString(imageData);
        }
    }
}
