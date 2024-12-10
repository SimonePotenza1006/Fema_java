package com.example.demo.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Base64;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import java.util.stream.Collectors;

import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.MetadataException;
import com.example.demo.entity.Azienda;
import com.example.demo.entity.Cartella;
import com.example.demo.entity.CredenzialiCliente;
import com.example.demo.entity.Immagine;
import com.example.demo.entity.Intervento;
import com.example.demo.entity.MerceInRiparazione;
import com.example.demo.entity.Movimenti;
import com.example.demo.entity.Preventivo;
import com.example.demo.entity.RestituzioneMerce;
import com.example.demo.entity.Sopralluogo;
import com.example.demo.entity.SpesaVeicolo;
import com.example.demo.entity.Task;
import com.example.demo.entity.Ticket;
import com.example.demo.entity.Veicolo;
import com.example.demo.repository.AziendaRepository;
import com.example.demo.repository.CartellaRepository;
import com.example.demo.repository.CredenzialiClienteRepository;
import com.example.demo.repository.InterventoRepository;
import com.example.demo.repository.MerceInRiparazioneRepository;
import com.example.demo.repository.MovimentiRepository;
import com.example.demo.repository.PreventivoRepository;
import com.example.demo.repository.RestituzioneMerceRepository;
import com.example.demo.repository.SopralluogoRepository;
import com.example.demo.repository.SpesaVeicoloRepository;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.VeicoloRepository;
import com.example.demo.service.ImmagineService;
import com.example.demo.service.InterventoService;
import com.example.demo.service.SpesaVeicoloService;
import com.example.demo.service.VeicoloService;
import com.example.demo.util.ImageUtil;


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
	public MovimentiRepository movimentoRepository;

	@Autowired
	public SopralluogoRepository sopralluogoRepository;

	@Autowired
	public CartellaRepository cartellaRepository;

	@Autowired
	public SpesaVeicoloRepository spesaRepository;

	@Autowired
	public SpesaVeicoloService spesaService;

	@Autowired
	public CredenzialiClienteRepository credenzialiRepository;

	@Autowired
	public RestituzioneMerceRepository restituzioneRepository;

	@Autowired
	public TaskRepository taskRepository;

	@Autowired
	public TicketRepository ticketRepository;

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

	@PostMapping("/movimento/{movimentoId}")
	public ResponseEntity<?> uploadImageMovimento(@RequestParam("movimento") MultipartFile file,
			@PathVariable("movimentoId") int movimentoId) throws IOException{
				Optional<Movimenti> optionalMovimento = movimentoRepository.findById(movimentoId);
				String response = immagineService.uploadImageMovimento(file, movimentoId);
				try{
					Path path = Files.createDirectories(Paths.get("C:\\APP_FEMA\\Movimenti\\Movimento_"+optionalMovimento.get().getDescrizione().replace(" ", "")));
					Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()));
					System.out.println("File is created!");
				} catch(IOException e){
					System.err.println("Failed to create directory!" + e.getMessage());
				}
				System.out.print(response);
				return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping("/credenziali/{credenzialiId}")
	public ResponseEntity<?> uploadImageCredenziali(@RequestParam("credenziali") MultipartFile file,
			@PathVariable("credenzialiId") int credenzialiId) throws IOException{
				Optional<CredenzialiCliente> optionalCredenziali = credenzialiRepository.findById(credenzialiId);
				String response = immagineService.uploadImageCredenziali(file, credenzialiId);
				try{
					Path path = Files.createDirectories(Paths.get("C:\\APP_FEMA\\Credenziali\\Credenziale_"+optionalCredenziali.get().getDescrizione().replace(" ", "")));
					Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()));
					System.out.println("File is created!");
				} catch(IOException e){
					System.err.println("Failed to create directory!" + e.getMessage());
				}
				System.out.print(response);
				return ResponseEntity.status(HttpStatus.OK).body(response);
			}

	@PostMapping("/ticket/{ticketId}")
	public ResponseEntity<?> uploadImageTicket(@RequestParam("ticket") MultipartFile file,
			@PathVariable("ticketId") int ticketId) throws IOException{
				Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
				String response = immagineService.uploadImageTicket(file, ticketId);
				try{
					Path path = Files.createDirectories(Paths.get("C:\\APP_FEMA\\Ticket\\Ticket_"+optionalTicket.get().getDescrizione().replace(" ", "")));
					Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()));
					System.out.println("File is created!");
				} catch(IOException e){
					System.err.println("Failed to create directory!" + e.getMessage());
				}
				System.out.print(response);
				return ResponseEntity.status(HttpStatus.OK).body(response);
			}		

	@PostMapping("/restituzione/{restituzioneId}")
	public ResponseEntity<?> uploadImageRestituzione(@RequestParam("restituzione") MultipartFile file,
			@PathVariable("restituzioneId") int restituzioneId) throws IOException{
				Optional<RestituzioneMerce> optionalRestituzione = restituzioneRepository.findById(restituzioneId);
				String response = immagineService.uploadImageRestituzioneMerce(file, restituzioneId);
				try{
					Path path = Files.createDirectories(Paths.get("C:\\APP_FEMA\\RMA\\Rma_"+optionalRestituzione.get().getProdotto().replace(" ", "")));
					Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()));
					System.out.println("File is created!");
				} catch(IOException e){
					System.err.println("Failed to create directory!" + e.getMessage());
				}
				System.out.print(response);
				return ResponseEntity.status(HttpStatus.OK).body(response);
			}
	
	@PostMapping("/taskcomp/{taskId}")
	public ResponseEntity<?> uploadImageTaskComp(@RequestParam("task") MultipartFile file,
			@PathVariable("taskId") int taskId) throws IOException, ImageProcessingException, MetadataException{
				Optional<Task> optionalTask = taskRepository.findById(taskId);
				String response = immagineService.uploadImageTaskComp(file, taskId);
				try{
					Path path = Files.createDirectories(Paths.get("C:\\APP_FEMA\\Task\\Task_"+optionalTask.get().getId()));
					Files.copy(new ByteArrayInputStream(ImageUtil.compressImage0912(file)),//file.getInputStream(), 
							path.resolve(file.getOriginalFilename()));
					System.out.println("File is created!");
				} catch(IOException e){
					System.err.println("Failed to create directory!" + e.getMessage());
				}
				System.out.print(response);
				return ResponseEntity.status(HttpStatus.OK).body(response);
			}
	
	@PostMapping("/task/{taskId}")
	public ResponseEntity<?> uploadImageTask(@RequestParam("task") MultipartFile file,
			@PathVariable("taskId") int taskId) throws IOException{
				Optional<Task> optionalTask = taskRepository.findById(taskId);
				String response = immagineService.uploadImageTask(file, taskId);
				try{
					Path path = Files.createDirectories(Paths.get("C:\\APP_FEMA\\Task\\Task_"+optionalTask.get().getId()));
					Files.copy(file.getInputStream(), 
							path.resolve(file.getOriginalFilename()));
					System.out.println("File is created!");
				} catch(IOException e){
					System.err.println("Failed to create directory!" + e.getMessage());
				}
				System.out.print(response);
				return ResponseEntity.status(HttpStatus.OK).body(response);
			}
	
	@PostMapping("/taskaudio/{taskId}")
	public ResponseEntity<?> uploadAudioTask(@RequestParam("task") MultipartFile file,
			@PathVariable("taskId") int taskId) throws IOException{
				Optional<Task> optionalTask = taskRepository.findById(taskId);
				String response = immagineService.uploadAudioTask(file, taskId);
				try{
					Path path = Files.createDirectories(Paths.get("C:\\APP_FEMA\\Task\\Task_"+optionalTask.get().getId()));
					Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()));
					System.out.println("File is created!");
				} catch(IOException e){
					System.err.println("Failed to create directory!" + e.getMessage());
				}
				System.out.print(response);
				return ResponseEntity.status(HttpStatus.OK).body(response);
			}
	
	@PostMapping("/ticketaudio/{ticketId}")
	public ResponseEntity<?> uploadAudioTickek(@RequestParam("ticket") MultipartFile file,
			@PathVariable("ticketId") int ticketId) throws IOException{
				Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
				String response = immagineService.uploadAudioTicket(file, ticketId);
				try{
					Path path = Files.createDirectories(Paths.get("C:\\APP_FEMA\\Ticket\\Ticket_"+optionalTicket.get().getDescrizione().replace(" ", "")));
					Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()));
					System.out.println("File is created!");
				} catch(IOException e){
					System.err.println("Failed to create directory!" + e.getMessage());
				}
				System.out.print(response);
				return ResponseEntity.status(HttpStatus.OK).body(response);
			}

	@PostMapping("/cartella/{cartellaId}")
	public ResponseEntity<?> uploadImageCartella(@RequestParam("cartella") MultipartFile file,
			@PathVariable("cartellaId") int cartellaId) throws IOException{
				Optional<Cartella> optionalCartella = cartellaRepository.findById(cartellaId);
				String response = immagineService.uploadImageCartella(file, cartellaId);
				try{
					Path path = Files.createDirectories(Paths.get("C:\\APP_FEMA\\Archivio\\Cartella_"+ optionalCartella.get().getNome()));
					Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()));
					System.out.println("File is created!");
				} catch(IOException e){
					System.err.println("Failed to create directory!" + e.getMessage());
				}
				System.out.print(response);
	        return ResponseEntity.status(HttpStatus.OK)
	                .body(response);
		}

	@PostMapping("/spesa/{spesaId}")
    public ResponseEntity<?> uploadImageSpesa(@RequestParam("spesa") MultipartFile file, 
    		@PathVariable("spesaId") int idSpesa) throws IOException {
	    	
	    	Optional<SpesaVeicolo> optionalSpesa = spesaRepository.findById(idSpesa);
	        String response = immagineService.uploadImageSpesa(file, idSpesa);
	        try {
	        	Path path = Files.createDirectories(Paths.get("C:\\APP_FEMA\\Spese_Veicolo\\Spesa_"+optionalSpesa.get().getIdSpesaVeicolo()));
    		    Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()));
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

		@PostMapping("/veicolo/{id}")
		public ResponseEntity<?> uploadImageVeicolo(@RequestParam("veicolo") MultipartFile file,
									 @PathVariable("id") int veicoloId) throws IOException {
			Optional<Veicolo> optionalVeicolo = veicoloRepository.findById(veicoloId);
			String response = immagineService.uploadImage(file, veicoloId);
			try{
				System.out.println("Prova upload Immagine");
				Path path = Files.createDirectories(Paths.get("C:\\APP_FEMA\\Aziende\\Azienda_"+optionalVeicolo.get().getDescrizione().replace(" ", "")+"\\Foto"));
				Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()));
    		    System.out.println("File is created!");
			} catch(IOException e){
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

		@GetMapping(value = "/sopralluogo/{sopralluogoId}/images", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<ImageWrapper>> getImagesBySopralluogo(@PathVariable int sopralluogoId) {
			List<Immagine> images = immagineService.getImagesBySopralluogo(sopralluogoId);
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

		@GetMapping(value = "/merce/{merceId}/images", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<ImageWrapper>> getImagesByMerce(@PathVariable int merceId) {
			List<Immagine> images = immagineService.getImagesByMerce(merceId);

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

		@GetMapping(value = "/ticket/{ticketId}/images", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<ImageWrapper>> getImagesByTicket(@PathVariable int ticketId) {
			List<Immagine> images = immagineService.getImagesByTicket(ticketId);
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

		@GetMapping(value = "/spesa/{spesaId}/images", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<ImageWrapper>> getImagesBySpesa(@PathVariable int spesaId){
			List<Immagine> images = immagineService.getImagesBySpesa(spesaId);
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
		

		@GetMapping(value="/restituzioneMerce/{restituzioneId}/images",  produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<ImageWrapper>> getImagesByRestituzione(@PathVariable int restituzioneId){
			List<Immagine> images = immagineService.getImagesByRestituzione(restituzioneId);
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

		@GetMapping(value="/task/{taskId}/images",  produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<ImageWrapper>> getImagesByTask(@PathVariable int taskId){
			List<Immagine> images = immagineService.getImagesByTask(taskId);
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
		
		@GetMapping(value="/task/{taskId}/audio",  produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
		public ResponseEntity<byte[]> getAudioByTask(@PathVariable int taskId){
			
			List<Immagine> images = immagineService.getAudioByTask(taskId);
			if (images.isEmpty()) {
		        return ResponseEntity.notFound().build(); // Restituisce un 404 Not Found
		    }
			byte[] imagea = images.get(0).getImageData();
			List<byte[]> imageBytes = images.stream()
				.map(image -> image.getImageData())
				.collect(Collectors.toList());

			 HttpHeaders headers = new HttpHeaders();
	            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	            headers.setContentLength(imagea.length);
	            headers.setContentDisposition(ContentDisposition.builder("attachment")
	                .filename("audio-file.mp3")
	                .build());
			
				/*List<ImageWrapper> imageWrappers = new ArrayList<>();
				for(byte[] imageData : imageBytes){
					ImageWrapper wrapper = new ImageWrapper();
					wrapper.setImageData(imageData);
					imageWrappers.add(wrapper);
				}*/
				return new ResponseEntity<>(imagea, headers, HttpStatus.OK);
		}
		
		@GetMapping(value="/ticket/{ticketId}/audio",  produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
		public ResponseEntity<byte[]> getAudioByTicket(@PathVariable int ticketId){
			
			List<Immagine> images = immagineService.getAudioByTicket(ticketId);
			if (images.isEmpty()) {
		        return ResponseEntity.notFound().build(); // Restituisce un 404 Not Found
		    }
			byte[] imagea = images.get(0).getImageData();
			List<byte[]> imageBytes = images.stream()
				.map(image -> image.getImageData())
				.collect(Collectors.toList());

			 HttpHeaders headers = new HttpHeaders();
	            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	            headers.setContentLength(imagea.length);
	            headers.setContentDisposition(ContentDisposition.builder("attachment")
	                .filename("audio-file.mp3")
	                .build());
		
				return new ResponseEntity<>(imagea, headers, HttpStatus.OK);
		}
		
		@GetMapping(value = "/credenziali/{credenzialeId}/images", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<ImageWrapper>> getImagesByCredenziale(@PathVariable int credenzialeId){
			List<Immagine> images = immagineService.getImagesByCredenziale(credenzialeId);
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

		@GetMapping(value = "/cartella/{cartellaId}/images", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<ImageWrapper>> getImagesByCartella(@PathVariable int cartellaId){
			List<Immagine> images = immagineService.getImagesByCartella(cartellaId);
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

        @GetMapping(value = "/intervento/{interventoId}/images", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<ImageWrapper>> getImagesByIntervento(@PathVariable int interventoId) {
    		List<Immagine> images = immagineService.getImagesByIntervento(interventoId);

    			List<byte[]> imageBytes = images.stream()
            		.map(image -> ImageUtil.decompressImage(image.getImageData()))
            		.collect(Collectors.toList());

					List<ImageWrapper> imageWrappers = new ArrayList<>();
					for (byte[] imageData : imageBytes) {
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

		@DeleteMapping("{id}")
		public ResponseEntity<String> deleteImage(@PathVariable("id") int immagineId) {
    		immagineService.deleteImmagine(immagineId);
			return new ResponseEntity<>("Immagine eliminata", HttpStatus.OK);
		}

		@DeleteMapping("/movimento/{id}")
		public ResponseEntity<String> deleteImagesMovimento(@PathVariable("id") int movimentoId) {
    		immagineService.deleteImmagineMovimento(movimentoId);
    		return new ResponseEntity<>("Immagini associate al movimento eliminate", HttpStatus.OK);
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
