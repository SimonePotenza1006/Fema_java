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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import com.example.demo.entity.Azienda;
import com.example.demo.entity.Immagine;
import com.example.demo.entity.Intervento;
import com.example.demo.entity.MerceInRiparazione;
import com.example.demo.entity.Preventivo;
import com.example.demo.entity.Sopralluogo;
import com.example.demo.entity.Spesa;
import com.example.demo.entity.Veicolo;
import com.example.demo.repository.AziendaRepository;
import com.example.demo.repository.ImmagineRepository;
import com.example.demo.repository.InterventoRepository;
import com.example.demo.repository.MerceInRiparazioneRepository;
import com.example.demo.repository.PreventivoRepository;
import com.example.demo.repository.SopralluogoRepository;
import com.example.demo.repository.VeicoloRepository;
import com.example.demo.service.ImmagineService;
import com.example.demo.service.InterventoService;
import com.example.demo.service.PreventivoService;
import com.example.demo.service.VeicoloService;


@RestController
@RequestMapping("api/immagine")
public class ImmagineController {
    
    @Autowired
    public ImmagineService immagineService;

    @Autowired
    public InterventoService interventoService;

	@Autowired
	public VeicoloService veicoloService;

	@Autowired
	public VeicoloRepository veicoloRepository;

	@Autowired
	public MerceInRiparazioneRepository merceRepository;

	@Autowired
	public PreventivoRepository preventivoRepository ;

    @Autowired
    public InterventoRepository interventoRepository;

	@Autowired
	public AziendaRepository aziendaRepository;

	@Autowired
	public SopralluogoRepository sopralluogoRepository;

	@PostMapping("sopralluogo/{id}")
public ResponseEntity<?> uploadImageSopralluogo(@RequestParam("sopralluogo") MultipartFile file,
                                                 @PathVariable("id") int sopralluogoId) throws IOException {
    Optional<Sopralluogo> optionalSopralluogo = sopralluogoRepository.findById(sopralluogoId);
    String response = immagineService.uploadImageSopralluogo(file, sopralluogoId);
    try {
        System.out.println("Prova upload immagine sopralluogo");
        
        // Ottieni la data odierna formattata nel formato desiderato
        LocalDate currentDate = LocalDate.now();
        String formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(currentDate);
        
        // Crea la cartella con il nome che include la data odierna e l'ID del sopralluogo
        Path folderPath = Files.createDirectories(Paths.get("C:\\APP_FEMA\\Sopralluoghi\\Sopralluogo_" + optionalSopralluogo.get().getId() + "_" + formattedDate + "\\Foto"));
        
        // Copia il file nella cartella appena creata
        Files.copy(file.getInputStream(), folderPath.resolve(file.getOriginalFilename()));
        
        System.out.println("File is created!");
    } catch (IOException e) {
        System.err.println("Failed to create directory!" + e.getMessage());
    }
    System.out.print(response);
    return ResponseEntity.status(HttpStatus.OK)
            .body(response);
}

@PostMapping("veicolo/{id}")
public ResponseEntity<?> uploadImageSpesaVeicolo(@RequestParam("veicolo") MultipartFile file,
                                                 @PathVariable("id") int veicoloId) throws IOException {
    Optional<Veicolo> optionalVeicolo = veicoloRepository.findById(veicoloId);
	System.out.println("Prova upload immagine sopralluogo");
    String response = immagineService.uploadImageSpesaveicolo(file, veicoloId);
    try {
        System.out.println("Prova upload immagine sopralluogo");
        

        LocalDate currentDate = LocalDate.now();
        String formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(currentDate);
        

        Path folderPath = Files.createDirectories(Paths.get("C:\\APP_FEMA\\SpesaVeicolo\\Veicolo_" + optionalVeicolo.get().getDescrizione().toString() + "_" + formattedDate + "\\Foto"));
        

        Files.copy(file.getInputStream(), folderPath.resolve(file.getOriginalFilename()));
        
        System.out.println("File is created!");
    } catch (IOException e) {
        System.err.println("Failed to create directory!" + e.getMessage());
    }
    System.out.print(response);
    return ResponseEntity.status(HttpStatus.OK)
            .body(response);
}

@PostMapping("merce/{id}")
public ResponseEntity<?> uploadImageMerce(@RequestParam("merce") MultipartFile file,
                                                 @PathVariable("id") int merceId) throws IOException {
    Optional<MerceInRiparazione> optionalMerce = merceRepository.findById(merceId);
	System.out.println("Prova upload immagine merce");
    String response = immagineService.uploadImageMerce(file, merceId);
    try {
        System.out.println("Prova upload immagine sopralluogo");
        

        LocalDate currentDate = LocalDate.now();
        String formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(currentDate);
        

        Path folderPath = Files.createDirectories(Paths.get("C:\\APP_FEMA\\MerceInRiparazione\\Merce_" + optionalMerce.get().getArticolo().toString() + "_" + formattedDate + "\\Foto"));
        

        Files.copy(file.getInputStream(), folderPath.resolve(file.getOriginalFilename()));
        
        System.out.println("File is created!");
    } catch (IOException e) {
        System.err.println("Failed to create directory!" + e.getMessage());
    }
    System.out.print(response);
    return ResponseEntity.status(HttpStatus.OK)
            .body(response);
}




    @PostMapping("/{id}") // Definisci l'ID come parametro di percorso
	public ResponseEntity<?> uploadImageIntervento(@RequestParam("intervento") MultipartFile file, 
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

		@PostMapping("/azienda/{id}") // Definisci l'ID come parametro di percorso
		public ResponseEntity<?> uploadImageLogo(@RequestParam("azienda") MultipartFile file, 
                                     @PathVariable("id") int aziendaId) throws IOException {
	    	
	    	Optional<Azienda> optionalAzienda = aziendaRepository.findById(aziendaId);
	        String response = immagineService.uploadImage(file, aziendaId);
	        
	        try {
				System.out.println("Prova upload Immagine");
	        	Path path = Files.createDirectories(Paths.get("C:\\APP_FEMA\\Aziende\\Azienda_"+optionalAzienda.get().getId()+"\\Foto"));
    		    Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()));
    		    System.out.println("File is created!");
    		  } catch (IOException e) {
    		    System.err.println("Failed to create directory!" + e.getMessage());
    		  }
	        System.out.print(response);
	        return ResponseEntity.status(HttpStatus.OK)
	                .body(response);
	    }

		@PostMapping("/preventivo/{id}") // Definisci l'ID come parametro di percorso
		public ResponseEntity<?> uploadPdfPreventivo(@RequestParam("preventivo") MultipartFile file, 
                                     @PathVariable("id") int preventivoId) throws IOException {
	    	
	    	Optional<Preventivo> optionalPreventivo = preventivoRepository.findById(preventivoId);
	        String response = immagineService.uploadImage(file, preventivoId);
	        
	        try {
				System.out.println("Prova upload Immagine");
	        	Path path = Files.createDirectories(Paths.get("C:\\APP_FEMA\\Preventivi\\Preventivo_"+ optionalPreventivo.get().getId()+"\\Foto"));
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
