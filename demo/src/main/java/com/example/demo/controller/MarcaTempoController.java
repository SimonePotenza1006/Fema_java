package com.example.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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

import com.example.demo.entity.MarcaTempo;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Viaggio;
import com.example.demo.repository.MarcaTempoRepository;
import com.example.demo.repository.SpesaRepository;
import com.example.demo.repository.ViaggioRepository;
import com.example.demo.service.MarcaTempoService;
import com.example.demo.util.ImageUtil;
import com.example.demo.repository.UtenteRepository;;

@RestController
@RequestMapping("/marcatempo")
public class MarcaTempoController {
    
    @Autowired
	public MarcaTempoService imageDataService;
	  
	@Autowired
	private ViaggioRepository viaggioRepository;
	
	@Autowired
	private UtenteRepository utenteRepository;
	
	@Autowired
	private SpesaRepository spesaRepository;

	@Autowired
	private MarcaTempoRepository marcatempoRepository;

    @PostMapping("/{idu}/{idviaggio}/{ing}/{gps}/{idmt}")
	public ResponseEntity<?> uploadImage(@RequestParam("pdf") MultipartFile file, 
	    @PathVariable("idu") int idutente, @PathVariable int idviaggio, @PathVariable Integer ing, @PathVariable String gps,  @PathVariable int idmt) throws IOException, ParseException {
	    	System.out.println("yt yyt yt "+idmt);
	    	Optional<Viaggio> optionalViaggio = viaggioRepository.findById(idviaggio);
	    	Optional<Utente> optionalUtente = utenteRepository.findById(idutente);
	        String response = imageDataService.uploadPdf(file, idviaggio, idutente, ing, gps, idmt);
	        System.out.println(file.getBytes());
	        return ResponseEntity.status(HttpStatus.OK).body(response);
	    }

        @GetMapping("/{idu}/{idviaggio}")
	    public ResponseEntity<?> getMarcaTempo(@PathVariable int idu, @PathVariable int idviaggio){
	    	//ResponseEntity<List<MarcaTempo>>
	    	List<MarcaTempo> marche = imageDataService.findByViaggioAndUtente(idviaggio, idu);
	    	byte[] maa = ImageUtil.decompressImage(marche.get(0).getImageData());
	    	System.out.println(maa);
	        return ResponseEntity.status(HttpStatus.OK)
	                .contentType(MediaType.valueOf("image/png"))
	                .body(maa);//new ResponseEntity<>(marche, HttpStatus.OK);
	    }

        @GetMapping("/oggi/{idu}/{idviaggio}")
	    public ResponseEntity<List<Optional<MarcaTempo>>> getMarcaTempoToday(@PathVariable int idu, @PathVariable int idviaggio){
	    	//ResponseEntity<List<MarcaTempo>>
	    	List<Optional<MarcaTempo>> marche = imageDataService.findByViaggioAndUtenteToday(idviaggio, idu);
	    	//byte[] maa = ImageUtil.decompressImage(marche.get(0).getImageData());
	    	System.out.println("today "+marche.size()+" "+marche);
	    	return new ResponseEntity<>(marche, HttpStatus.OK);
	    }

        @GetMapping("/s/{idu}/{idviaggio}")
	    public ResponseEntity<List<MarcaTempo>> getMarcaTempos(@PathVariable int idu, @PathVariable int idviaggio){

	    	
	    	List<MarcaTempo> viaggi = imageDataService.findByViaggioAndUtente(idviaggio, idu);
	        return new ResponseEntity<>(viaggi, HttpStatus.OK);
	    }
        
        @GetMapping("/pres/{idu}/{idviaggio}")
	    public ResponseEntity<List<Optional<MarcaTempo>>> getMarcaTemposP(@PathVariable int idu, @PathVariable int idviaggio){
	    	LocalDate giorno1 = LocalDate.now().withDayOfMonth(1);
			LocalDate giornoF = giorno1.plusMonths(1);//LocalDate.now().plusMonths(1);
			new Date();
			Date giorno1D= Date.from(giorno1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			Date giornoFD= Date.from(giornoF.atStartOfDay(ZoneId.systemDefault()).toInstant());
	    	Optional<Viaggio> optionalViaggio = viaggioRepository.findById(idviaggio);
	    	List<Optional<MarcaTempo>> viaggi = marcatempoRepository.findByViaggioAndDataBetweenOrderByUtenteAscDataAsc(optionalViaggio.get(), giorno1D, giornoFD);
	    	
	    	//List<MarcaTempo> viaggi = imageDataService.findByViaggioAndUtente(idviaggio, idu);
	        return new ResponseEntity<>(viaggi, HttpStatus.OK);
	    }  

        @GetMapping("/presprec/{idu}/{idviaggio}")
	    public ResponseEntity<List<Optional<MarcaTempo>>> getMarcaTemposPP(@PathVariable int idu, @PathVariable int idviaggio){
	    	LocalDate giornoP = LocalDate.now().minusMonths(1);
			LocalDate giorno1 = giornoP.withDayOfMonth(1);
			LocalDate giornoF = giorno1.plusMonths(1);
			new Date();
			Date giorno1D= Date.from(giorno1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			Date giornoFD= Date.from(giornoF.atStartOfDay(ZoneId.systemDefault()).toInstant());
	    	Optional<Viaggio> optionalViaggio = viaggioRepository.findById(idviaggio);
	    	List<Optional<MarcaTempo>> viaggi = marcatempoRepository.findByViaggioAndDataBetweenOrderByUtenteAscDataAsc(optionalViaggio.get(), giorno1D, giornoFD);
	        return new ResponseEntity<>(viaggi, HttpStatus.OK);
	    }

        @GetMapping("/presoggi/{idu}/{idviaggio}")
	    public ResponseEntity<List<Optional<MarcaTempo>>> getMarcaTemposPOggi(@PathVariable int idu, @PathVariable int idviaggio){
	    	LocalDate giorno1 = LocalDate.now();//.withDayOfMonth(1);
			LocalDate giornoF = giorno1.plusDays(1);//LocalDate.now().plusMonths(1);
			new Date();
			Date giorno1D= Date.from(giorno1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			Date giornoFD= Date.from(giornoF.atStartOfDay(ZoneId.systemDefault()).toInstant());
	    	Optional<Viaggio> optionalViaggio = viaggioRepository.findById(idviaggio);
	    	List<Optional<MarcaTempo>> viaggi = marcatempoRepository.findByViaggioAndDataBetweenOrderByUtenteAscDataAsc(optionalViaggio.get(), giorno1D, giornoFD);
	        return new ResponseEntity<>(viaggi, HttpStatus.OK);
	    }
        
        @GetMapping("/presieri/{idu}/{idviaggio}")
	    public ResponseEntity<List<Optional<MarcaTempo>>> getMarcaTemposPIeri(@PathVariable int idu, @PathVariable int idviaggio){
	    	LocalDate giornoP = LocalDate.now().minusDays(1);
			//LocalDate giorno1 = giornoP.withDayOfMonth(1);
			LocalDate giornoF = LocalDate.now();//giornoP.plusMonths(1);//LocalDate.now().plusMonths(1)
			new Date();
			Date giorno1D= Date.from(giornoP.atStartOfDay(ZoneId.systemDefault()).toInstant());
			Date giornoFD= Date.from(giornoF.atStartOfDay(ZoneId.systemDefault()).toInstant());
	    	Optional<Viaggio> optionalViaggio = viaggioRepository.findById(idviaggio);
	    	List<Optional<MarcaTempo>> viaggi = marcatempoRepository.findByViaggioAndDataBetweenOrderByUtenteAscDataAsc(optionalViaggio.get(), giorno1D, giornoFD);
	    	
	    	//List<MarcaTempo> viaggi = imageDataService.findByViaggioAndUtente(idviaggio, idu);
	        return new ResponseEntity<>(viaggi, HttpStatus.OK);
	    } 

        @GetMapping("/infoing/{id}")
	    public Boolean  getIngById(@PathVariable int id){
	    	Date date = new Date() ;
	    	Optional<Utente> optionalUtente = utenteRepository.findById(id);
	        Boolean image = imageDataService.getIngByDataByUtente(date, optionalUtente.get());

	        return image;
	    }
}