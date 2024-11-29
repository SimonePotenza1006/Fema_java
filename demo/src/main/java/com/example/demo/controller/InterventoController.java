package com.example.demo.controller;

import com.example.demo.entity.Intervento;
import com.example.demo.entity.MerceInRiparazione;
import com.example.demo.entity.Priorita;
import com.example.demo.entity.TipologiaIntervento;
import com.example.demo.entity.Utente;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.GruppoInterventi;
import com.example.demo.service.TipologiaInterventoService;
import com.example.demo.service.UtenteService;
import com.example.demo.service.WebSocketService;
import com.example.demo.service.impl.InterventoServiceImpl;
import com.example.demo.service.ClienteService;
import com.example.demo.service.GruppoInterventiService;
import com.example.demo.service.MerceInRiparazioneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/intervento")
public class InterventoController {

    @Autowired
    private InterventoServiceImpl interventoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired 
    private GruppoInterventiService gruppoService;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private MerceInRiparazioneService merceService;

    @Autowired
    private TipologiaInterventoService tipologiaInterventoService;

    @Autowired
    private WebSocketService webSocketService;

    @PostMapping
    public ResponseEntity<Intervento> createIntervento(@RequestBody Intervento intervento) {
        Intervento savedIntervento = interventoService.createIntervento(intervento);

    // Notifica i client WebSocket
        webSocketService.sendNewInterventoNotification(intervento);

        return new ResponseEntity<>(savedIntervento, HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    public ResponseEntity<Intervento> getInterventoById(@PathVariable("id") int interventoId) {
        int idvariable = interventoId;
        Intervento intervento = interventoService.getInterventoById(idvariable);
        if (intervento == null) {
            System.out.println("Intervento non trovato con ID: " + interventoId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println("Intervento non trovato con ID: " + interventoId);
        return new ResponseEntity<>(intervento, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Intervento>> getAllInterventi(){
        List<Intervento> interventi = interventoService.getAllInterventi();
        System.out.println("Get all interventi");
        return new ResponseEntity<>(interventi, HttpStatus.OK);
    }

    @GetMapping("withMerce")
    public ResponseEntity<List<Intervento>> getAllInterventiWithMerce(){
        List<Intervento> interventi = interventoService.getAllInterventiWithMerce();
        return new ResponseEntity<>(interventi, HttpStatus.OK);
    }



    @GetMapping("ordered")
    public ResponseEntity<List<Intervento>> getAllInterventiOrderByDesc(){
        List<Intervento> interventi = interventoService.getAllInterventiOrderdByDesc();
        return new ResponseEntity<>(interventi, HttpStatus.OK);
    }

    @GetMapping("orderedByGroup")
    public ResponseEntity<List<Intervento>> getAllInterventiOrderByGruppo(){
        List<Intervento> interventi = interventoService.getInterventiOrderedByGruppo();
        return new ResponseEntity<>(interventi, HttpStatus.OK);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<Optional<Intervento>>> getInterventiByCliente(@PathVariable("id") int clienteId){
        Cliente cliente = clienteService.getClienteById(clienteId);
        List<Optional<Intervento>> interventi = interventoService.getInterventoByCliente(cliente);
        return new ResponseEntity<>(interventi, HttpStatus.OK);
    }

    @GetMapping("withMerce/{id}")
    public ResponseEntity<List<Intervento>> getInterventiWithMerceByUtente(@PathVariable("id") int utenteId){
        Utente utente = utenteService.getUtenteById(utenteId);
        List<Intervento> interventi = interventoService.getAllInterventiWithMerceNonConclusiByUtente(utente);
        return new ResponseEntity<>(interventi, HttpStatus.OK);
    }

    @GetMapping("/categoriaIntervento/{id}")
    public ResponseEntity<List<Optional<Intervento>>> getInterventoByTipologia(@PathVariable("id") int tipologiaId){
        TipologiaIntervento tipologia = tipologiaInterventoService.getTipologiaInterventoById(tipologiaId);
        List<Optional<Intervento>> interventi = interventoService.getInterventoByTipologia(tipologia);
        return new ResponseEntity<>(interventi, HttpStatus.OK);
    }

    @GetMapping("/utente/{id}")
    public ResponseEntity<List<Optional<Intervento>>> getInterventoByUtente(@PathVariable("id") int utenteId){
        Utente utente = utenteService.getUtenteById(utenteId);
        List<Optional<Intervento>> interventi = interventoService.getInterventoByUtente(utente);
        return new ResponseEntity<>(interventi, HttpStatus.OK);
    }

    @GetMapping("/gruppo/{id}")
    public ResponseEntity<List<Optional<Intervento>>> getInterventoByGruppo(@PathVariable("id") int gruppoId){
        GruppoInterventi gruppo = gruppoService.getGruppoById(gruppoId);
        List<Optional<Intervento>> interventi = interventoService.getInterventiByGruppo(gruppo);
        return new ResponseEntity<>(interventi, HttpStatus.OK); 
    }
    
    @GetMapping("/merce/{id}")
    public ResponseEntity<List<Intervento>> getInterventoByMerce(@PathVariable("id") int merceId){
        MerceInRiparazione merce = merceService.getMerceById(merceId);
        List<Intervento> interventi = interventoService.getInterventiByMerce(merce);
        return new ResponseEntity<>(interventi, HttpStatus.OK);
    }


    @PutMapping("{id}")
    public ResponseEntity<Intervento> updateIntervento(@RequestBody Intervento intervento) throws IOException{
        Intervento updatedIntervento = interventoService.updateIntervento(intervento);
        return new ResponseEntity<>(updatedIntervento, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteIntervento(@PathVariable("id") int interventoId){
        interventoService.deleteIntervento(interventoId);
        return new ResponseEntity<>("Intervento successfully deleted!", HttpStatus.OK);
    }


    @Scheduled(cron = "0 30 4 * * ?")
    public void checkInterventiDelGiorno() {
        // Ottieni la data di oggi a mezzanotte
        Calendar calToday = Calendar.getInstance();
        calToday.set(Calendar.HOUR_OF_DAY, 0);
        calToday.set(Calendar.MINUTE, 0);
        calToday.set(Calendar.SECOND, 0);
        calToday.set(Calendar.MILLISECOND, 0);
        Date todayMidnight = calToday.getTime();
        System.out.println("Data di oggi a mezzanotte: " + todayMidnight);

        // Ottieni la data di ieri a mezzanotte
        Calendar calYesterday = Calendar.getInstance();
        calYesterday.add(Calendar.DAY_OF_MONTH, -1);
        calYesterday.set(Calendar.HOUR_OF_DAY, 0);
        calYesterday.set(Calendar.MINUTE, 0);
        calYesterday.set(Calendar.SECOND, 0);
        calYesterday.set(Calendar.MILLISECOND, 0);
        Date yesterdayMidnight = calYesterday.getTime();
        System.out.println("Data di ieri a mezzanotte: " + yesterdayMidnight);

        // Recupera tutti gli interventi
        List<Intervento> interventi = interventoService.getAllInterventi();

        // Cicla attraverso gli interventi
        for (Intervento intervento : interventi) {
            Date dataIntervento = intervento.getData();
            Date dataAperturaIntervento = intervento.getData_apertura_intervento();

            if (dataIntervento != null) {
                // Imposta la data dell'intervento a mezzanotte
                Calendar calIntervento = Calendar.getInstance();
                calIntervento.setTime(dataIntervento);
                calIntervento.set(Calendar.HOUR_OF_DAY, 0);
                calIntervento.set(Calendar.MINUTE, 0);
                calIntervento.set(Calendar.SECOND, 0);
                calIntervento.set(Calendar.MILLISECOND, 0);
                Date dataInterventoMidnight = calIntervento.getTime();
                System.out.println("Data intervento (a mezzanotte): " + dataInterventoMidnight);

                // Confronta le date a mezzanotte per oggi o ieri (non conclusi)
                if (todayMidnight.equals(dataInterventoMidnight) ||
                    (yesterdayMidnight.equals(dataInterventoMidnight) && !intervento.isConcluso())) {
                    
                    System.out.println("Intervento urgente trovato: " + intervento.getId());
                    // Imposta la priorità a "urgente"
                    intervento.setPriorita(Priorita.URGENTE);
                    // Salva l'intervento aggiornato
                    interventoService.createIntervento(intervento);
                }
            } else if (dataAperturaIntervento != null) {
                // Calcola i giorni trascorsi dalla data di apertura
                long daysSinceApertura = (todayMidnight.getTime() - dataAperturaIntervento.getTime()) / (1000 * 60 * 60 * 24);

                // Determina la nuova priorità ogni 3 giorni
                Priorita nuovaPriorita = calcolaPriorita(intervento.getPriorita(), daysSinceApertura);
                if (nuovaPriorita != intervento.getPriorita()) {
                    System.out.println("Aggiornamento priorità per intervento ID: " + intervento.getId() + 
                                       " da " + intervento.getPriorita() + " a " + nuovaPriorita);
                    intervento.setPriorita(nuovaPriorita);
                    interventoService.createIntervento(intervento);
                }
            }
        }
    }

    /**
     * Calcola la nuova priorità in base ai giorni trascorsi.
     * Ogni 3 giorni la priorità aumenta di un livello fino a raggiungere URGENTE.
     */
    private Priorita calcolaPriorita(Priorita prioritaAttuale, long giorniTrascorsi) {
        int livelliIncremento = (int) (giorniTrascorsi / 3);
        int prioritaIndex = prioritaAttuale.ordinal() + livelliIncremento;

        // Assicura che l'indice della priorità non superi il massimo livello
        Priorita[] livelliPriorita = Priorita.values();
        if (prioritaIndex >= livelliPriorita.length - 1) {
            return Priorita.URGENTE;
        }
        return livelliPriorita[prioritaIndex];
    }

}