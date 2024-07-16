package com.example.demo.controller;

import lombok.AllArgsConstructor;

import com.example.demo.entity.Viaggio;
import com.example.demo.service.ViaggioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/viaggio")
public class ViaggioController {

    private ViaggioService viaggioService;

    // @PostMapping
    // public ResponseEntity<Viaggio> createViaggio(@RequestBody Viaggio viaggio) throws ParseException{
    // 	SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd hh:mm:ss Z yyyy", Locale.ENGLISH);
    // 	SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd");
    // 	Date d = sdf.parse(viaggio.getData_arrivo().toString());
    // 	viaggio.setData_arrivo(d);
    	
    // 	//Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(ruolo.getDatap().toString()); 
    // 	//ruolo.setDatap(date1);
    	
    // 	Viaggio savedViaggio = viaggioService.createViaggio(viaggio);
    // 	savedViaggio.setUtenti(viaggio.getUtenti());
    	
    // 	  try {

    // 		    Path path = Paths.get("C:\\APP_FEMA\\Viaggi\\Viaggio_"+viaggio.getId()+"\\Ddt");
    // 		    Path pathS = Paths.get("C:\\APP_FEMA\\Viaggi\\Viaggio_"+viaggio.getId()+"\\Spese");
    // 		    Path pathR = Paths.get("C:\\APP_FEMA\\Viaggi\\Viaggio_"+viaggio.getId()+"\\Report");

    // 		    //java.nio.file.Files;
    // 		    Files.createDirectories(path);
    // 		    Files.createDirectories(pathS);
    // 		    Files.createDirectories(pathR);

    // 		    System.out.println("Directory is created!");

    // 		  } catch (IOException e) {

    // 		    System.err.println("Failed to create directory!" + e.getMessage());

    // 		  }
    	
    //     return new ResponseEntity<>(savedViaggio, HttpStatus.CREATED);
    // }

    @GetMapping("{id}")
    public ResponseEntity<Viaggio> getViaggioById(@PathVariable("id") int viaggioId){
    	Viaggio viaggio = viaggioService.getViaggioById(viaggioId);
        return new ResponseEntity<>(viaggio, HttpStatus.OK);
    }

    // @GetMapping("/tecnico/{utente}")
    // public ResponseEntity<List<Optional<Viaggio>>> getViaggioByTecnico(@PathVariable Utente utente){
    	
    // 	List<Optional<Viaggio>> viaggi = viaggioService.getViaggioByUtente(utente);
    //     return new ResponseEntity<>(viaggi, HttpStatus.OK);
    // }
    
    @GetMapping
    public ResponseEntity<List<Viaggio>> getAllViaggi(){
        List<Viaggio> viaggi = viaggioService.getAllViaggi();
        Viaggio viaggio = viaggioService.getViaggioById(Integer.valueOf(5));
        viaggi.remove(viaggio);
        return new ResponseEntity<>(viaggi, HttpStatus.OK);
    }

    @PutMapping//("{id}")
    public ResponseEntity<Viaggio> updateViaggio(@RequestBody Viaggio viaggio) throws IOException{
    	Viaggio updatedViaggio = viaggioService.updateViaggio(viaggio);
        return new ResponseEntity<>(updatedViaggio, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteViaggio(@PathVariable("id") int viaggioId){
    	viaggioService.deleteViaggio(viaggioId);
        return new ResponseEntity<>("Viaggio successfully deleted!", HttpStatus.OK);
    }
}
