package com.example.demo.controller;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import com.example.demo.entity.UtenteSivis;
import com.example.demo.service.UtenteSivisService;
import com.example.demo.entity.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/utenteSivis")
public class UtenteSivisController {
    
    private UtenteSivisService utenteService;

    @PostMapping("/login")
    public ApiResponse login(@RequestBody UtenteSivis loginDto){
        return utenteService.login(loginDto);
    }

    @PostMapping("/ulogin")
    public UtenteSivis ulogin(@RequestBody UtenteSivis loginDto){
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Un utente sta effettuando il Login! Orario:" + now);
        return utenteService.ulogin(loginDto);  
    }

    @PostMapping
    public ResponseEntity<UtenteSivis> createUtente(@RequestBody UtenteSivis utente){
        UtenteSivis savedUtente = utenteService.createUtente(utente);
        return new ResponseEntity<>(savedUtente, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UtenteSivis> getUtenteById(@PathVariable("id") int utenteId){
        UtenteSivis utente = utenteService.getUtenteById(utenteId);
        System.out.println("UTENTE: " + utente.getCognome() + " " + utente.getNome());
        return new ResponseEntity<>(utente, HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UtenteSivis> getUtenteByEmail(@PathVariable("email") String utenteEmail){
    	UtenteSivis utente = utenteService.getUtenteByEmail(utenteEmail);
        return new ResponseEntity<>(utente, HttpStatus.OK);
    }

    @PutMapping//("{id}")
    public ResponseEntity<UtenteSivis> updateUtente(//@PathVariable("id") Long utenteId,//, @RequestParam("file") MultipartFile file
    		@RequestBody UtenteSivis utente
    		) throws IOException{
    	//String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        //long size = multipartFile.getSize();
         
        //String filecode = FileUploadUtil.saveFile(fileName, file);
    	//report.setId(reportId);
    	//Utente utenteg = utenteService.getUtenteById(utenteId);
    	UtenteSivis updatedUtente = utenteService.updateUtente(utente);
    	//Utente utente = utenteService.updateUtente(utente);
        return new ResponseEntity<>(updatedUtente, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUtente(@PathVariable("id") int utenteId){
    	utenteService.deleteUtente(utenteId);
        return new ResponseEntity<>("Utente successfully deleted!", HttpStatus.OK);
    }
}
