package com.example.demo.controller;
import com.example.demo.entity.Intervento;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Sopralluogo;
import com.example.demo.entity.MerceInRiparazione;
import com.example.demo.entity.NotaTecnico;
import com.example.demo.entity.Destinazione;

import com.example.demo.service.UtenteService;
import com.example.demo.service.ClienteService;
import com.example.demo.service.InterventoService;
import com.example.demo.service.SopralluogoService;
import com.example.demo.service.DestinazioneService;
import com.example.demo.service.MerceInRiparazioneService;
import com.example.demo.service.NotaTecnicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/noteTecnico")
public class NotaTecnicoController{

    @Autowired
    private NotaTecnicoService notaService;

    @Autowired
    private DestinazioneService destinazioneService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private InterventoService interventoService;

    @Autowired
    private SopralluogoService sopralluogoService;

    @Autowired 
    private MerceInRiparazioneService merceService;

    @PostMapping
    public ResponseEntity<NotaTecnico> createNota(@RequestBody NotaTecnico nota){
        NotaTecnico savedNota = notaService.createNota(nota);
        return new ResponseEntity<>(savedNota, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<NotaTecnico> getInterventoById(@PathVariable("id") int notaId) {
        int idvariable = notaId;
        NotaTecnico nota = notaService.getNotaById(idvariable);
        if (nota == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(nota, HttpStatus.OK);
    }

    @GetMapping("ordered")
    public ResponseEntity<List<NotaTecnico>> getAllNoteOrderByIdDesc(){
        List<NotaTecnico> note = notaService.getAllNoteOrderByDesc();
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<Optional<NotaTecnico>>> getNoteByCliente(@PathVariable("id") int clienteId){
    
        Cliente cliente = clienteService.getClienteById(clienteId);
        List<Optional<NotaTecnico>> note = notaService.getNotaByCliente(cliente);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @GetMapping("/intervento/{id}")
    public ResponseEntity<List<Optional<NotaTecnico>>> getNotaByIntervento(@PathVariable("id") int interventoId){
        Intervento intervento = interventoService.getInterventoById(interventoId);
        List<Optional<NotaTecnico>> note = notaService.getNotaByIntervento(intervento);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @GetMapping("/sopralluogo/{id}")
    public ResponseEntity<List<Optional<NotaTecnico>>> getNotaBySopralluogo(@PathVariable("id") int sopralluogoId){
        Sopralluogo sopralluogo = sopralluogoService.getSopralluogoById(sopralluogoId);
        List<Optional<NotaTecnico>> note = notaService.getNotaBySopralluogo(sopralluogo);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @GetMapping("/destinazione/{id}")
    public ResponseEntity<List<Optional<NotaTecnico>>> getNotaByDestinazione(@PathVariable("id") int destinazioneId){
        Destinazione destinazione = destinazioneService.getDestinazioneById(destinazioneId);
        List<Optional<NotaTecnico>> note = notaService.getNotaByDestinazione(destinazione);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @GetMapping("/merce/{id}")
    public ResponseEntity<List<Optional<NotaTecnico>>> getNotaByMerce(@PathVariable("id") int merceId){
        MerceInRiparazione merce = merceService.getMerceById(merceId);
        List<Optional<NotaTecnico>> note = notaService.getNotaByMerce(merce);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @GetMapping("/utente/{id}")
    public ResponseEntity<List<Optional<NotaTecnico>>> getNotaByUtente(@PathVariable("id") int utenteId){
        Utente utente = utenteService.getUtenteById(utenteId);
        List<Optional<NotaTecnico>> note = notaService.getNotaByUtente(utente);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<NotaTecnico> updateNota(@RequestBody NotaTecnico nota) throws IOException{
        NotaTecnico updatedNota = notaService.updateNota(nota);
        return new ResponseEntity<>(updatedNota, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int notaId){
        notaService.deleteNota(notaId);
        return new ResponseEntity<>("Intervento successfully deleted!", HttpStatus.OK);
    }


}
