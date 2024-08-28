package com.example.demo.controller;

import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Azienda;
import com.example.demo.entity.Utente;
import com.example.demo.service.AziendaService;
import com.example.demo.service.PdfService;
import com.example.demo.service.UtenteService;

import org.springframework.http.MediaType;

@RestController
@RequestMapping(value = "api/pdf")
public class PdfController {
    
    @Autowired
	  private PdfService pdfService;
	  
	  @Autowired
	  private UtenteService utenteService2;
	  
	  @Autowired
	  private AziendaService aziendaService;
	  
	//   @Autowired
	//     private NotificaRepository notificationRepository;
	    
	//   @Autowired
	//   private SimpMessagingTemplate template;

	 /* @PostMapping("/{id}")
	  public ResponseEntity<?> uploadImage(@RequestParam("pdf") Optional<MultipartFile> file, 
	          @PathVariable("id") Long idutente) throws org.springframework.web.server.ResponseStatusException {
	      String response = null;
	      System.out.println("upload pdf " + file.toString());
	      try {
	          if (file.isEmpty()) {
	              return null;
	          } else {
	              File targetFile = new File("C:\\AppSivis\\Aziende\\" + aaaaz.getDescrizione() + "\\" + cognomeunico + "_" + nomeunico + "_" + savedUtente.getCodicefiscale() + "\\" + file.get().getOriginalFilename());
	              file.get().transferTo(targetFile);
	              response = "ok";
	              //...
	          }
	      } catch (Exception e) {
	          System.err.println("Failed to create directory! " + e.getMessage());
	          return null;
	      }
	      return ResponseEntity.status(HttpStatus.OK)
	             .body(response);
	  }*/
	  
	    @PostMapping("/{id}")//, headers="Content-Type=application/json")
	    public ResponseEntity<?> uploadIorigmage(@RequestParam("pdf") Optional<MultipartFile> file, 
	    		@PathVariable("id") int idutente) throws org.springframework.web.server.ResponseStatusException
	    //throws Exception//ServiceException, IllegalStateException, IOException, EOFException, MultipartException 
	    {
	    	String response = null;
	    	 System.out.println("upload pdf "+file.toString());
	    	 try {
	    		  Utente savedUtente = utenteService2.getUtenteById(idutente);
	         	
	         	 Path path = Paths.get( "C:\\AppFema\\Preventivi\\"+savedUtente.getCognome());//+"\\"+file.getOriginalFilename());
	    	     //Path pathUpload = Paths.get( "C:\\AppSivis\\Aziende\\"+aaaaz.getDescrizione()+"\\"+cognomeunico+"_"+nomeunico+"_"+savedUtente.getCodicefiscale()+"\\Uploaded");

	    		 /*if(file.isEmpty()) {return null;} else {
		    			 File targetFile = new File("C:\\AppSivis\\Aziende\\" + aaaaz.getDescrizione() + "\\" + cognomeunico + "_" + nomeunico + "_" + savedUtente.getCodicefiscale() + "\\" + file.get().getOriginalFilename());
		    			 file.get().transferTo(targetFile);
		    			 //response = imageDataService.uploadPdf(file, idutente); //salvataggio su db commentato
		    			 response = "ok"; 
	    		 }*/
	      
	       
	        
	       
    		    //Path path2 = Paths.get("C:\\UtentiSivis\\Utente_"+savedUtente.getCodicefiscale());
    		    //java.nio.file.Files;
    		    //Files.createFile(path, null);//createDirectories(path);
    		    //Files.copy(file.getInputStream(), path2.resolve(file.getOriginalFilename()));

    		    
    		    //byte[] bytes = file.get().getBytes();
    		    //Path path = Paths.get("C:\\AppSivis\\UtentiSivis\\Utente_"+savedUtente.getCodicefiscale());
    	      
    	       
    	       Files.createDirectories(path);
    	       System.out.println("nomefile "+file.get().getOriginalFilename()+file.get().getOriginalFilename().substring(0, 9));
    		    if(file.get().getOriginalFilename().substring(0, 9).equals("Uploaded_")) {
    		    	
    		    	//Files.createDirectories(pathUpload);
    		    	
    		    	 //File targetFile = new File("C:\\AppSivis\\Aziende\\" + aaaaz.getDescrizione() + "\\" + cognomeunico + "_" + nomeunico + "_" + savedUtente.getCodicefiscale() + "\\Uploaded\\" + file.get().getOriginalFilename());
	    			 //file.get().transferTo(targetFile);
	    			 //response = imageDataService.uploadPdf(file, idutente); //salvataggio su db commentato
	    			 response = "ok"; 
    		    	
    		    	//Files.copy(file.get().getInputStream(), pathUpload.resolve(file.get().getOriginalFilename()));
    		    	
    		    } else {
    		    	 File targetFile = new File("C:\\AppFema\\Preventivi\\"+savedUtente.getCognome());
	    			 file.get().transferTo(targetFile);
	    			 //response = imageDataService.uploadPdf(file, idutente); //salvataggio su db commentato
	    			 response = "ok"; 
    		    	 //Files.copy(file.get().getInputStream(), path.resolve(file.get().getOriginalFilename()));
    		    	 
    		    }
    	       // Files.write(path, bytes);
    		    
    		    file.get().getInputStream().close();
    		    System.out.println("pdfFile is created!");

    		    System.out.println("pdf "+response);
    	        return ResponseEntity.status(HttpStatus.OK)
    	                .body(response);
    		  } catch (Exception e) {
    			  
    			//  throw new RuntimeException("Could not save File: " + e.getMessage());
    		    System.err.println("Failed to create directory! " + e.getMessage());
    		    return null;
    		  } 
	        
	       
	    }

	    // @PostMapping("/send/{id}")//, headers="Content-Type=application/json")
	    // public ResponseEntity<?> uploadIorigmageSend(@RequestParam("pdf") Optional<MultipartFile> file, 
	    // 		@PathVariable("id") Long idutente) throws org.springframework.web.server.ResponseStatusException
	    // //throws Exception//ServiceException, IllegalStateException, IOException, EOFException, MultipartException 
	    // {
	    // 	String response = null;
	    // 	 System.out.println("upls ssend oad pdf "+file.get().getOriginalFilename());
	    // 	 try {
	    // 		 /* Utente savedUtente = utenteService2.getUtenteById(idutente);
	  	//         Azienda aaaaz = aziendaService.getRuoloById(savedUtente.getAzienda().getId());
	    // 		 Path path = Paths.get( "C:\\AppSivis\\Aziende\\"+aaaaz.getDescrizione()+"\\Utente_"+savedUtente.getCodicefiscale());//+"\\"+file.getOriginalFilename());
	    // 	        Files.createDirectories(path);
	    // 		 InputStream initialStream = file.get().getInputStream();
	    // 		 byte[] buffer = new byte[initialStream.available()];
	    // 		 initialStream.read(buffer);
	    // 		 File targetFile = new File(path.toString());
	    // 		 BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream( targetFile ));
	    // 	        InputStream is = file.get().getInputStream();
	    // 	        byte [] bytes = new byte[1024];
	    // 	        int sizeRead;
	    // 	        while ((sizeRead = is.read(bytes,0, 1024)) > 0) {
	    // 	            stream.write(bytes, 0, sizeRead);
	    // 	        }*/
	    	       
	    		 
	    // 		  Utente savedUtente = utenteService2.getUtenteById(idutente);
	    // 		 Azienda aaaaz = aziendaService.getRuoloById(savedUtente.getAzienda().getId());
	    // 		 String cognomeunico = savedUtente.getCognome().replaceAll(" ", "_").toUpperCase();
	    //      	String nomeunico = savedUtente.getNome().replaceAll(" ", "_").toUpperCase();
	    //      	  Path path = Paths.get( "C:\\AppSivis\\Aziende\\"+aaaaz.getDescrizione()+"\\"+cognomeunico+"_"+nomeunico+"_"+savedUtente.getCodicefiscale()+"\\Send");
	    //      	 Files.createDirectories(path);
	         	  
	    // 		 if(file.isEmpty()) {return null;} else {
	    // 			 System.out.println("ssendd "+file.toString());
		//     			 File targetFile = new File("C:\\AppSivis\\Aziende\\" + aaaaz.getDescrizione() + "\\" + cognomeunico + "_" + nomeunico + "_" + savedUtente.getCodicefiscale() + "\\Send\\" + file.get().getOriginalFilename());
		//     			 System.out.println("vvvbbb "+targetFile.toString());
		//     			 file.get().transferTo(targetFile);
		//     			 System.out.println("uiuiui "+file.get().getSize());
		//     			 //response = imageDataService.uploadPdf(file, idutente); //salvataggio su db commentato
		//     			 response = "ok"; 
		    			 
		//     			 Notifica notification = new Notifica();
		//              	//Utente utente = meeting.get().getUtente();
		//              	//Utente utente = utenteService.getUtenteById(Long.parseLong(meeting.get().getUtente()//request.getUserId()));
		//                  notification.setUtente(savedUtente); 
		//                  notification.setMessage("Hai ricevuto un file da Sivis. Entra nella sezione ALLEGATI RICEVUTI");//"Inizio turno previsto per le ore "+meeting.get().getFrom().format(DateTimeFormatter.ofPattern("HH:mm"))+". Ricordati di timbrare quando arrivi alla tua sede operativa");
		//                  notification.setDelivered(false);
		//                  System.out.println(" notif iniz tu "+savedUtente.getId());
		//                  notificationRepository.save(notification);
		//                  template.convertAndSendToUser(savedUtente.getId().toString(), "/topic/notifications", "Hai ricevuto un file da Sivis. Entra nella sezione ALLEGATI RICEVUTI");//"Inizio turno previsto per le ore "+meeting.get().getFrom().format(DateTimeFormatter.ofPattern("HH:mm"))+". Ricordati di timbrare quando arrivi alla tua sede operativa");
		             	
	    // 		 }
	      
	       
	    // 		 System.out.println("innnv "+response.toString());
	       
    	// 	    //Path path2 = Paths.get("C:\\UtentiSivis\\Utente_"+savedUtente.getCodicefiscale());
    	// 	    //java.nio.file.Files;
    	// 	    //Files.createFile(path, null);//createDirectories(path);
    	// 	    //Files.copy(file.getInputStream(), path2.resolve(file.getOriginalFilename()));

    		    
    	// 	    //byte[] bytes = file.get().getBytes();
    	// 	    //Path path = Paths.get("C:\\AppSivis\\UtentiSivis\\Utente_"+savedUtente.getCodicefiscale());
    	//      //+"\\"+file.getOriginalFilename());
    	//        /*Path pathUpload = Paths.get( "C:\\AppSivis\\Aziende\\"+aaaaz.getDescrizione()+"\\"+cognomeunico+"_"+nomeunico+"_"+savedUtente.getCodicefiscale()+"\\Uploaded");
    	//        System.out.println("sfggfdd "+path);
    	      
    	//        System.out.println("nomefile "+file.get().getOriginalFilename()+file.get().getOriginalFilename().substring(0, 9));
    	// 	    if(file.get().getOriginalFilename().substring(0, 9).equals("Uploaded_")) {
    	// 	    	Files.createDirectories(pathUpload);
    	// 	    	Files.copy(file.get().getInputStream(), pathUpload.resolve(file.get().getOriginalFilename()));
    	// 	    } else {
    	// 	    	 Files.copy(file.get().getInputStream(), path.resolve(file.get().getOriginalFilename()));
    	// 	    }*/
    	//        // Files.write(path, bytes);
    		    
    	// 	    file.get().getInputStream().close();
    	// 	    System.out.println("pdfFile is created!");

    	// 	    System.out.print("pdf "+response);
    	//         return ResponseEntity.status(HttpStatus.OK)
    	//                 .body(response);
    	// 	  } catch (Exception e) {
    			  
    	// 		//  throw new RuntimeException("Could not save File: " + e.getMessage());
    	// 	    System.err.println("Failed to create directory! " + e.getMessage());
    	// 	    return null;
    	// 	  } 
	        
	       
	    // }

	    
	    @PostMapping("/noleggio")//, headers="Content-Type=application/json")
	    public ResponseEntity<?> uploadIorigmageNoleggio(@RequestParam("pdf") Optional<MultipartFile> file) throws org.springframework.web.server.ResponseStatusException
	    //throws Exception//ServiceException, IllegalStateException, IOException, EOFException, MultipartException 
	    {
	    	String response = null;
	    	 System.out.println("upls ssend oad pdf "+file.get().getOriginalFilename());
	    	 try {
	         	  Path path = Paths.get( "C:\\AppSivis\\Magazzino_Auto\\Noleggio");
	         	 Files.createDirectories(path);
	         	  
	    		 if(file.isEmpty()) {return null;} else {
	    			 System.out.println("ssendd "+file.toString());
		    			 File targetFile = new File("C:\\AppFema\\Preventivi\\" + file.get().getOriginalFilename());
		    			 System.out.println("vvvbbb "+targetFile.toString());
		    			 file.get().transferTo(targetFile);
		    			 System.out.println("uiuiui "+file.get().getSize());
		    			 response = "ok"; 
	    		 }
	      
	       
	    		 System.out.println("innnv "+response.toString());
	       
    		    //Path path2 = Paths.get("C:\\UtentiSivis\\Utente_"+savedUtente.getCodicefiscale());
    		    //java.nio.file.Files;
    		    //Files.createFile(path, null);//createDirectories(path);
    		    //Files.copy(file.getInputStream(), path2.resolve(file.getOriginalFilename()));

    		    
    		    //byte[] bytes = file.get().getBytes();
    		    //Path path = Paths.get("C:\\AppSivis\\UtentiSivis\\Utente_"+savedUtente.getCodicefiscale());
    	     //+"\\"+file.getOriginalFilename());
    	       /*Path pathUpload = Paths.get( "C:\\AppSivis\\Aziende\\"+aaaaz.getDescrizione()+"\\"+cognomeunico+"_"+nomeunico+"_"+savedUtente.getCodicefiscale()+"\\Uploaded");
    	       System.out.println("sfggfdd "+path);
    	      
    	       System.out.println("nomefile "+file.get().getOriginalFilename()+file.get().getOriginalFilename().substring(0, 9));
    		    if(file.get().getOriginalFilename().substring(0, 9).equals("Uploaded_")) {
    		    	Files.createDirectories(pathUpload);
    		    	Files.copy(file.get().getInputStream(), pathUpload.resolve(file.get().getOriginalFilename()));
    		    } else {
    		    	 Files.copy(file.get().getInputStream(), path.resolve(file.get().getOriginalFilename()));
    		    }*/
    	       // Files.write(path, bytes);
    		    
    		    file.get().getInputStream().close();
    		    System.out.println("pdfFile is created!");

    		    System.out.print("pdf "+response);
    	        return ResponseEntity.status(HttpStatus.OK)
    	                .body(response);
    		  } catch (Exception e) {
    			  
    			//  throw new RuntimeException("Could not save File: " + e.getMessage());
    		    System.err.println("Failed to create directory! " + e.getMessage());
    		    return null;
    		  } 
	        
	       
	    }	    
	    
	    // @GetMapping("/info/{name}")
	    // public ResponseEntity<?>  getImageInfoByName(@PathVariable("name") String name){
	    //     Pdf image = imageDataService.getInfoByImageByName(name);

	    //     return ResponseEntity.status(HttpStatus.OK)
	    //             .body(image);
	    // }

	    // @GetMapping("/{name}")
	    // public ResponseEntity<?>  getImageByName(@PathVariable("name") String name){
	    //     byte[] image = imageDataService.getImage(name);

	    //     return ResponseEntity.status(HttpStatus.OK)
	    //             .contentType(MediaType.valueOf("image/png"))
	    //             .body(image);
	    // }
	    
	    // @GetMapping("/tipofoto/{tipofoto}/{idutente}")
	    // public ResponseEntity<?>  getProfilo(@PathVariable("tipofoto") String tipofoto, @PathVariable("idutente") String idutente){
	    // 	byte[] image = imageDataService.getProfilo(tipofoto, Long.parseLong(idutente));
	    	
	    // 	 return ResponseEntity.status(HttpStatus.OK)
		//                 .contentType(MediaType.valueOf("image/png"))
		//                 .body(image);
	    	//List<ImageData> imageModelList2 = Ima
	    	/*List<ImageData> imageModelList = ImageDataService.getAll();
	    	//List<ImageData> imageModelList = retrievedImages.get();
	        List<byte[]> response = new ArrayList<byte[]>();
	        
	        imageModelList.forEach(image -> {
	            response.add(image.getImageData());
	        });
	        
	    	return response;*/
	    	/*List<byte[]> images = imageDataService.getProfilo(tipofoto, Long.parseLong(idutente));
	    	ResponseEntity<?> aaa=ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(images);
	    	List<byte[]> response = new ArrayList<byte[]>();
	    	//List<ResponseEntity<?>> response;
	    	 imageModelList.forEach(image -> {
	    	        response.add(image.getPicByte());
	    	    });
	        return List<ResponseEntity.status(HttpStatus.OK)
	                .contentType(MediaType.valueOf("image/png"))
	                .body(image)>;*/
	    //}
	    
	    // @GetMapping("/all/{idutente}/{filename}")
	    // public ResponseEntity<?>  getAllByUtente(@PathVariable("idutente") Long idutente, @PathVariable("filename") String filename){//@PathVariable("tipofoto") String tipofoto, @PathVariable("idutente") String idutente){
	    // 	String filenamexyz = filename.replace("xyz0", "\\");
	    // 	System.out.println("mostrafile "+idutente+filenamexyz);
	    // 	Utente savedUtente = utenteService2.getUtenteById(idutente);
	    // 	Azienda aaaaz = aziendaService.getRuoloById(savedUtente.getAzienda().getId());
	    // 	//byte[] images = imageDataService.getAllByUtente(idutente).get(0).getImageData();
	    // 	/*List<byte[]> response = new ArrayList<byte[]>();
	    // 	images.forEach(image -> {
    	//         response.add(image.getImageData());
    	//     });*/
	    // 	String cognomeunico = savedUtente.getCognome().replaceAll(" ", "_").toUpperCase();
        // 	String nomeunico = savedUtente.getNome().replaceAll(" ", "_").toUpperCase();
	    // 	Resource resource;

	    //     String fileBasePath = "C:\\AppSivis\\Aziende\\"+aaaaz.getDescrizione()+"\\"+cognomeunico+"_"+nomeunico+"_"+savedUtente.getCodicefiscale()+"\\";
	    //     Path path = Paths.get(fileBasePath + filenamexyz);
	    //     File[] files = new File(fileBasePath).listFiles();
	    //     try {
	    //         resource = new UrlResource(path.toUri());
	    //     } catch (MalformedURLException e) {
	    //         e.printStackTrace();
	    //         return null;
	    //     }

	    //     // Try to determine file's content type
	    //     String contentType = null;
	    //     contentType = "application/octet-stream";//request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
	    //     return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
	    //             .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+filenamexyz+"\"")	                
	    //             .body(resource);
	        //return response;
	    	/*return ResponseEntity.status(HttpStatus.OK)
	                .contentType(MediaType.MULTIPART_FORM_DATA)
	                .body(images);*/
	    	/*return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType("applicatioin/pdf"))
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Liberatoria_app_vyvyvt_6ggyft_1699546355777.pdf")// + entity.getName() + CommonConstants.DOUBLE_QUOTE)
	                .body(new ByteArrayResource(images));*/
	    	//List<ImageData> imageModelList2 = Ima
	    	/*List<ImageData> imageModelList = ImageDataService.getAll();
	    	//List<ImageData> imageModelList = retrievedImages.get();
	        List<byte[]> response = new ArrayList<byte[]>();
	        
	        imageModelList.forEach(image -> {
	            response.add(image.getImageData());
	        });
	        
	    	return response;*/
	    	/*List<byte[]> images = imageDataService.getProfilo(tipofoto, Long.parseLong(idutente));
	    	ResponseEntity<?> aaa=ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(images);
	    	List<byte[]> response = new ArrayList<byte[]>();
	    	//List<ResponseEntity<?>> response;
	    	 imageModelList.forEach(image -> {
	    	        response.add(image.getPicByte());
	    	    });
	        return List<ResponseEntity.status(HttpStatus.OK)
	                .contentType(MediaType.valueOf("image/png"))
	                .body(image)>;*/
	    //}
	    
	    // @GetMapping("/noleggio/{filename}")
	    // public ResponseEntity<?>  getNoleggio(@PathVariable("filename") String filename){//@PathVariable("tipofoto") String tipofoto, @PathVariable("idutente") String idutente){
	    // 	String filenamexyz = filename.replace("xyz0", "\\");
	    
	    // 	Resource resource;

	    //     String fileBasePath = "C:\\AppSivis\\Magazzino_Auto\\Noleggio\\";
	    //     Path path = Paths.get(fileBasePath + filenamexyz);
	    //     File[] files = new File(fileBasePath).listFiles();
	    //     try {
	    //         resource = new UrlResource(path.toUri());
	    //     } catch (MalformedURLException e) {
	    //         e.printStackTrace();
	    //         return null;
	    //     }

	    //     // Try to determine file's content type
	    //     String contentType = null;
	    //     contentType = "application/octet-stream";//request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
	    //     return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
	    //             .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+filenamexyz+"\"")	                
	    //             .body(resource);
	      
	    // }
	    	    
	    
	    // @GetMapping("/filesnamesend/{idutente}")
	    // public ResponseEntity<List<String>>  getFilesNameByUtenteSend(@PathVariable("idutente") Long idutente){//@PathVariable("tipofoto") String tipofoto, @PathVariable("idutente") String idutente){
	    // 	 System.out.println("jkifrf ");
	    // 	Utente savedUtente = utenteService2.getUtenteById(idutente);
	    // 	Azienda aaaaz = aziendaService.getRuoloById(savedUtente.getAzienda().getId());
	    // 	//byte[] images = imageDataService.getAllByUtente(idutente).get(0).getImageData();
	    // 	/*List<byte[]> response = new ArrayList<byte[]>();
	    // 	images.forEach(image -> {
    	//         response.add(image.getImageData());
    	//     });*/
	    // 	String cognomeunico = savedUtente.getCognome().replaceAll(" ", "_").toUpperCase();
        // 	String nomeunico = savedUtente.getNome().replaceAll(" ", "_").toUpperCase();
	    // 	Resource resource;

	    //     String fileBasePath = "C:\\AppSivis\\Aziende\\"+aaaaz.getDescrizione()+"\\"+cognomeunico+"_"+nomeunico+"_"+savedUtente.getCodicefiscale()+"\\Send\\";
	    //     Path path = Paths.get(fileBasePath + "Tesserasanitaria.pdf");
	    //     File[] files = new File(fileBasePath).listFiles();
	    //     List<String> response = new ArrayList<String>();
	    //     if(files != null)
	    //     for(File image: files) {
	    //     	if (image.isDirectory()) {
	        		
	    //     		for(File imagesub: new File(image.getPath()).listFiles()) {
	    //     			System.out.println("cassettsssub "+imagesub.getName());//.substring(imagesub.getName().lastIndexOf('.')+1));
	    //     			if (imagesub.getName().substring(imagesub.getName().lastIndexOf('.')+1).equalsIgnoreCase("pdf")) {
	    //     				String[] sttt = (image.toString()).split("\\\\");
	    //         	        response.add(sttt[5]+"xyz0"+imagesub.getName()+ "|" + new Date(imagesub.lastModified()));
	    //         	        }
	    //     		}
	    //     	}
	    //     	System.out.println("cassett "+image.getName());//.substring(image.getName().lastIndexOf('.')+1));
	    //     	if (image.getName().substring(image.getName().lastIndexOf('.')+1).equalsIgnoreCase("pdf"))
    	//         response.add(image.getName() + "|" + new Date(image.lastModified()));
    	//     };
	        
    	//     System.out.println("rrreeee "+response);
	    //     // Try to determine file's content type
	    //     String contentType = null;
	    //     contentType = "application/octet-stream";//request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
	    //     return new ResponseEntity<>(response, HttpStatus.OK);
	    //     //return response;
	    // 	/*return ResponseEntity.status(HttpStatus.OK)
	    //             .contentType(MediaType.MULTIPART_FORM_DATA)
	    //             .body(images);*/
	    // 	/*return ResponseEntity.ok()
	    //             .contentType(MediaType.parseMediaType("applicatioin/pdf"))
	    //             .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Liberatoria_app_vyvyvt_6ggyft_1699546355777.pdf")// + entity.getName() + CommonConstants.DOUBLE_QUOTE)
	    //             .body(new ByteArrayResource(images));*/
	    // 	//List<ImageData> imageModelList2 = Ima
	    // 	/*List<ImageData> imageModelList = ImageDataService.getAll();
	    // 	//List<ImageData> imageModelList = retrievedImages.get();
	    //     List<byte[]> response = new ArrayList<byte[]>();
	        
	    //     imageModelList.forEach(image -> {
	    //         response.add(image.getImageData());
	    //     });
	        
	    // 	return response;*/
	    // 	/*List<byte[]> images = imageDataService.getProfilo(tipofoto, Long.parseLong(idutente));
	    // 	ResponseEntity<?> aaa=ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(images);
	    // 	List<byte[]> response = new ArrayList<byte[]>();
	    // 	//List<ResponseEntity<?>> response;
	    // 	 imageModelList.forEach(image -> {
	    // 	        response.add(image.getPicByte());
	    // 	    });
	    //     return List<ResponseEntity.status(HttpStatus.OK)
	    //             .contentType(MediaType.valueOf("image/png"))
	    //             .body(image)>;*/
	    // }
	    
	    // @GetMapping("/filesname/{idutente}")
	    // public ResponseEntity<List<String>>  getFilesNameByUtente(@PathVariable("idutente") Long idutente){//@PathVariable("tipofoto") String tipofoto, @PathVariable("idutente") String idutente){
	    // 	Utente savedUtente = utenteService2.getUtenteById(idutente);
	    // 	Azienda aaaaz = aziendaService.getRuoloById(savedUtente.getAzienda().getId());
	    // 	//byte[] images = imageDataService.getAllByUtente(idutente).get(0).getImageData();
	    // 	/*List<byte[]> response = new ArrayList<byte[]>();
	    // 	images.forEach(image -> {
    	//         response.add(image.getImageData());
    	//     });*/
	    // 	String cognomeunico = savedUtente.getCognome().replaceAll(" ", "_").toUpperCase();
        // 	String nomeunico = savedUtente.getNome().replaceAll(" ", "_").toUpperCase();
	    // 	Resource resource;

	    //     String fileBasePath = "C:\\AppSivis\\Aziende\\"+aaaaz.getDescrizione()+"\\"+cognomeunico+"_"+nomeunico+"_"+savedUtente.getCodicefiscale()+"\\";
	    //     Path path = Paths.get(fileBasePath + "Tesserasanitaria.pdf");
	    //     File[] files = new File(fileBasePath).listFiles();
	    //     List<String> response = new ArrayList<String>();
	    //     if(files != null)
	    //     for(File image: files) {
	    //     	if (image.isDirectory()) {
	        		
	    //     		for(File imagesub: new File(image.getPath()).listFiles()) {
	    //     			System.out.println("cassettsssub "+imagesub.getName());//.substring(imagesub.getName().lastIndexOf('.')+1));
	    //     			if (imagesub.getName().substring(imagesub.getName().lastIndexOf('.')+1).equalsIgnoreCase("pdf")) {
	    //     				String[] sttt = (image.toString()).split("\\\\");
	    //         	        response.add(sttt[5]+"xyz0"+imagesub.getName()+ "|" + new Date(imagesub.lastModified()));
	    //         	        }
	    //     		}
	    //     	}
	    //     	System.out.println("cassett "+image.getName());//.substring(image.getName().lastIndexOf('.')+1));
	    //     	if (image.getName().substring(image.getName().lastIndexOf('.')+1).equalsIgnoreCase("pdf"))
    	//         response.add(image.getName() + "|" + new Date(image.lastModified()));
    	//     };
	        
    	//     System.out.println("rrreeee "+response);
	    //     // Try to determine file's content type
	    //     String contentType = null;
	    //     contentType = "application/octet-stream";//request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
	    //     return new ResponseEntity<>(response, HttpStatus.OK);
	    //     //return response;
	    // 	/*return ResponseEntity.status(HttpStatus.OK)
	    //             .contentType(MediaType.MULTIPART_FORM_DATA)
	    //             .body(images);*/
	    // 	/*return ResponseEntity.ok()
	    //             .contentType(MediaType.parseMediaType("applicatioin/pdf"))
	    //             .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Liberatoria_app_vyvyvt_6ggyft_1699546355777.pdf")// + entity.getName() + CommonConstants.DOUBLE_QUOTE)
	    //             .body(new ByteArrayResource(images));*/
	    // 	//List<ImageData> imageModelList2 = Ima
	    // 	/*List<ImageData> imageModelList = ImageDataService.getAll();
	    // 	//List<ImageData> imageModelList = retrievedImages.get();
	    //     List<byte[]> response = new ArrayList<byte[]>();
	        
	    //     imageModelList.forEach(image -> {
	    //         response.add(image.getImageData());
	    //     });
	        
	    // 	return response;*/
	    // 	/*List<byte[]> images = imageDataService.getProfilo(tipofoto, Long.parseLong(idutente));
	    // 	ResponseEntity<?> aaa=ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(images);
	    // 	List<byte[]> response = new ArrayList<byte[]>();
	    // 	//List<ResponseEntity<?>> response;
	    // 	 imageModelList.forEach(image -> {
	    // 	        response.add(image.getPicByte());
	    // 	    });
	    //     return List<ResponseEntity.status(HttpStatus.OK)
	    //             .contentType(MediaType.valueOf("image/png"))
	    //             .body(image)>;*/
	    // }
	    
	    // @GetMapping("/filesnamenoleggio")
	    // public ResponseEntity<List<String>>  getFilesNameNoleggio(){//@PathVariable("tipofoto") String tipofoto, @PathVariable("idutente") String idutente){
	    // 	//Utente savedUtente = utenteService2.getUtenteById(idutente);
	    // 	//Azienda aaaaz = aziendaService.getRuoloById(savedUtente.getAzienda().getId());
	    // 	//byte[] images = imageDataService.getAllByUtente(idutente).get(0).getImageData();
	    // 	/*List<byte[]> response = new ArrayList<byte[]>();
	    // 	images.forEach(image -> {
    	//         response.add(image.getImageData());
    	//     });*/
	    // 	//String cognomeunico = savedUtente.getCognome().replaceAll(" ", "_").toUpperCase();
        // 	//String nomeunico = savedUtente.getNome().replaceAll(" ", "_").toUpperCase();
	    // 	Resource resource;

	    //     String fileBasePath = "C:\\AppSivis\\Magazzino_Auto\\Noleggio\\";
	    //     Path path = Paths.get(fileBasePath + "Tesserasanitaria.pdf");
	    //     File[] files = new File(fileBasePath).listFiles();
	    //     List<String> response = new ArrayList<String>();
	    //     if(files != null)
	    //     for(File image: files) {
	    //     	if (image.isDirectory()) {
	        		
	    //     		for(File imagesub: new File(image.getPath()).listFiles()) {
	    //     			System.out.println("cassettsssub "+imagesub.getName());//.substring(imagesub.getName().lastIndexOf('.')+1));
	    //     			if (imagesub.getName().substring(imagesub.getName().lastIndexOf('.')+1).equalsIgnoreCase("pdf")) {
	    //     				String[] sttt = (image.toString()).split("\\\\");
	    //         	        response.add(sttt[5]+"xyz0"+imagesub.getName()+ "|" + new Date(imagesub.lastModified()));
	    //         	        }
	    //     		}
	    //     	}
	    //     	System.out.println("cassett "+image.getName());//.substring(image.getName().lastIndexOf('.')+1));
	    //     	if (image.getName().substring(image.getName().lastIndexOf('.')+1).equalsIgnoreCase("pdf"))
    	//         response.add(image.getName() + "|" + new Date(image.lastModified()));
    	//     };
	        
    	//     System.out.println("rrreeee "+response);
	    //     // Try to determine file's content type
	    //     String contentType = null;
	    //     contentType = "application/octet-stream";//request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
	    //     return new ResponseEntity<>(response, HttpStatus.OK);
	    //     //return response;
	    // 	/*return ResponseEntity.status(HttpStatus.OK)
	    //             .contentType(MediaType.MULTIPART_FORM_DATA)
	    //             .body(images);*/
	    // 	/*return ResponseEntity.ok()
	    //             .contentType(MediaType.parseMediaType("applicatioin/pdf"))
	    //             .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Liberatoria_app_vyvyvt_6ggyft_1699546355777.pdf")// + entity.getName() + CommonConstants.DOUBLE_QUOTE)
	    //             .body(new ByteArrayResource(images));*/
	    // 	//List<ImageData> imageModelList2 = Ima
	    // 	/*List<ImageData> imageModelList = ImageDataService.getAll();
	    // 	//List<ImageData> imageModelList = retrievedImages.get();
	    //     List<byte[]> response = new ArrayList<byte[]>();
	        
	    //     imageModelList.forEach(image -> {
	    //         response.add(image.getImageData());
	    //     });
	        
	    // 	return response;*/
	    // 	/*List<byte[]> images = imageDataService.getProfilo(tipofoto, Long.parseLong(idutente));
	    // 	ResponseEntity<?> aaa=ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(images);
	    // 	List<byte[]> response = new ArrayList<byte[]>();
	    // 	//List<ResponseEntity<?>> response;
	    // 	 imageModelList.forEach(image -> {
	    // 	        response.add(image.getPicByte());
	    // 	    });
	    //     return List<ResponseEntity.status(HttpStatus.OK)
	    //             .contentType(MediaType.valueOf("image/png"))
	    //             .body(image)>;*/
	    // }
	    
	    // @GetMapping("/all/all")
	    // public List<byte[]>  getAll(){//@PathVariable("tipofoto") String tipofoto, @PathVariable("idutente") String idutente){
	    // 	List<PdfUtente> images = imageDataService.getAll();
	    // 	List<byte[]> response = new ArrayList<byte[]>();
	    // 	images.forEach(image -> {
    	//         response.add(image.getImageData());
    	//     });
	    	
	    // 	return response;
	    // 	//List<ImageData> imageModelList2 = Ima
	    // 	/*List<ImageData> imageModelList = ImageDataService.getAll();
	    // 	//List<ImageData> imageModelList = retrievedImages.get();
	    //     List<byte[]> response = new ArrayList<byte[]>();
	        
	    //     imageModelList.forEach(image -> {
	    //         response.add(image.getImageData());
	    //     });
	        
	    // 	return response;*/
	    // 	/*List<byte[]> images = imageDataService.getProfilo(tipofoto, Long.parseLong(idutente));
	    // 	ResponseEntity<?> aaa=ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(images);
	    // 	List<byte[]> response = new ArrayList<byte[]>();
	    // 	//List<ResponseEntity<?>> response;
	    // 	 imageModelList.forEach(image -> {
	    // 	        response.add(image.getPicByte());
	    // 	    });
	    //     return List<ResponseEntity.status(HttpStatus.OK)
	    //             .contentType(MediaType.valueOf("image/png"))
	    //             .body(image)>;*/
	    // }
    
	}

