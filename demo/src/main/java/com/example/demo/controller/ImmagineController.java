package com.example.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.example.demo.entity.Immagine;
import com.example.demo.entity.Intervento;
import com.example.demo.entity.Spesa;
import com.example.demo.repository.ImmagineRepository;
import com.example.demo.repository.InterventoRepository;
import com.example.demo.service.ImmagineService;
import com.example.demo.service.InterventoService;


@RestController
@RequestMapping("api/immagine")
public class ImmagineController {
    
    @Autowired
    public ImmagineService immagineService;

    @Autowired
    public InterventoService interventoService;

    @Autowired
    public InterventoRepository interventoRepository;

    @PostMapping("/{id}") // Definisci l'ID come parametro di percorso
	public ResponseEntity<?> uploadImage(@RequestParam("intervento") MultipartFile file, 
                                     @PathVariable("id") int interventoId) throws IOException {
	    	
	    	Optional<Intervento> optionalIntervento = interventoRepository.findById(interventoId);
	        String response = immagineService.uploadImage(file, interventoId);
	        
	        try {
				System.out.println("Prova upload Immagine");
	        	Path path = Files.createDirectories(Paths.get("C:\\APP_FEMA\\Interventi\\Intervento_"+optionalIntervento.get().getId()+"\\Foto"));
    		    Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()));
    		    System.out.println("File is created!");
    		  } catch (IOException e) {
    		    System.err.println("Failed to create directory!" + e.getMessage());
    		  }
	        System.out.print(response);
	        return ResponseEntity.status(HttpStatus.OK)
	                .body(response);
	    }

        @GetMapping("/name/{name}")
	    public ResponseEntity<?>  getImageByName(@PathVariable String name){
	        byte[] image = immagineService.getImage(name);

	        return ResponseEntity.status(HttpStatus.OK)
	                .contentType(MediaType.valueOf("image/png"))
	                .body(image);
	    }

        @GetMapping("/spesa/{id}")
	    public ResponseEntity<?>  getImageByIntervento(@PathVariable int interventoId){
	        byte[] image = immagineService.getImageByIntervento(interventoId);

	        return ResponseEntity.status(HttpStatus.OK)
	                .contentType(MediaType.valueOf("image/png"))
	                .body(image);
	    }

        @GetMapping("/all/all")
	    public List<byte[]>  getAll(){
	    	List<Immagine> images = immagineService.getAllImmagini();
	    	List<byte[]> response = new ArrayList<byte[]>();
	    	images.forEach(image -> {
    	        response.add(image.getImageData());
    	    });
	    	return response;
	    }
}
