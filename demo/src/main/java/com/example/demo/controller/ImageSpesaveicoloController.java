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

import com.example.demo.entity.ImageSpesaveicolo;
import com.example.demo.entity.SpesaVeicolo;
import com.example.demo.repository.SpesaVeicoloRepository;
import com.example.demo.service.ImageSpesaveicoloService;
import com.example.demo.service.SpesaVeicoloService;

@RestController
@RequestMapping("/imagespesaveicolo")
public class ImageSpesaveicoloController {


    @Autowired
	public ImageSpesaveicoloService imageDataService;

	public SpesaVeicoloService spesaService;
	  
	@Autowired
	private SpesaVeicoloRepository spesaRepository;


    @PostMapping("/{id}")//, headers="Content-Type=application/json")
    public ResponseEntity<?> uploadImage(@RequestParam("spesa") MultipartFile file, 
    		@PathVariable("id") int idutente) throws IOException {
	    	
	    	Optional<SpesaVeicolo> optionalUtente = spesaRepository.findById(idutente);
	        String response = imageDataService.uploadImage(file, idutente);
	        
	        try {

    		    //Path path = Paths.get("C:\\Viaggi\\Viaggio_"+optionalUtente.get().getViaggio().getId());
	        	Path path = Files.createDirectories(Paths.get("C:\\APP_FEMA\\Spese_Veicolo\\Spesa_"+optionalUtente.get().getVeicolo().getDescrizione()));
	        	Path path2 = Paths.get("C:\\Spese\\Spesa_"+optionalUtente.get().getVeicolo().getDescrizione());
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


	    @GetMapping("/name/{name}")
	    public ResponseEntity<?>  getImageByName(@PathVariable String name){
	        byte[] image = imageDataService.getImage(name);

	        return ResponseEntity.status(HttpStatus.OK)
	                .contentType(MediaType.valueOf("image/png"))
	                .body(image);
	    }
	    
	    @GetMapping("/spesaveicolo/{idspesa}")
	    public ResponseEntity<?>  getImageBySpesa(@PathVariable int idspesa){
	        byte[] image = imageDataService.getImageBySpesa(idspesa);
	        return ResponseEntity.status(HttpStatus.OK)
	                .contentType(MediaType.valueOf("image/png"))
	                .body(image);
	    }
	    
	    
	    @GetMapping("/all/all")
	    public List<byte[]>  getAll(){//@PathVariable("tipofoto") String tipofoto, @PathVariable("idutente") String idutente){
	    	List<ImageSpesaveicolo> images = imageDataService.getAll();
	    	List<byte[]> response = new ArrayList<byte[]>();
	    	images.forEach(image -> {
    	        response.add(image.getImageData());
    	    });
	    	
	    	return response;
		}    
	
}
