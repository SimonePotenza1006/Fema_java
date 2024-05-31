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

import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.ImmagineSpesaSivis;
import com.example.demo.entity.SpesaVeicolo;
import com.example.demo.entity.SpesaVeicoloSivis;
import com.example.demo.repository.SpesaVeicoloSivisRepository;
import com.example.demo.service.ImmagineSpesaSivisService;
import com.example.demo.service.SpesaVeicoloSivisService;

@RestController
@RequestMapping("api/immagineSivis")
public class ImmagineSpesaSivisController {
    
    @Autowired
    public ImmagineSpesaSivisService imageService;

    @Autowired
    public SpesaVeicoloSivisService spesaService;

    @Autowired
    public SpesaVeicoloSivisRepository spesaRepository;

    @PostMapping("/{spesaId}")
    public ResponseEntity<?> uploadImage(@RequestParam("spesa") MultipartFile file, 
    		@PathVariable("spesaId") int idSpesa) throws IOException {
	    	
	    	Optional<SpesaVeicoloSivis> optionalSpesa = spesaRepository.findById(idSpesa);
	        String response = imageService.uploadImage(file, idSpesa);
	        try {
    		    //Path path = Paths.get("C:\\Viaggi\\Viaggio_"+optionalUtente.get().getViaggio().getId());
	        	Path path = Files.createDirectories(Paths.get("C:\\APP_SIVIS\\Spese_Veicolo\\Spesa_"+optionalSpesa.get().getId()));
	        	Path path2 = Paths.get("C:\\Spese\\Spesa_"+optionalSpesa.get().getVeicolo().getDescrizione());
    		    //java.nio.file.Files;
    		    //Files.createFile(path, null);//createDirectories(path);
    		    Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()));
    		    System.out.println("File is created!");
    		  } catch (IOException e) {
    		    System.err.println("Failed to create directory!" + e.getMessage());
    		  }
	        
	        System.out.print(response);
	        return ResponseEntity.status(HttpStatus.OK)
	                .body(response);
	    }

        @GetMapping("/spesa/{spesaId}")
	    public ResponseEntity<?>  getImageByIntervento(@PathVariable int spesaId){
	        byte[] image = imageService.getImageBySpesa(spesaId);

	        return ResponseEntity.status(HttpStatus.OK)
	                .contentType(MediaType.valueOf("image/png"))
	                .body(image);
	    }    
}
