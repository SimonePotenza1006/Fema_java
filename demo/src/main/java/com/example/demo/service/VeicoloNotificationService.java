package com.example.demo.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Veicolo;
import com.example.demo.repository.VeicoloRepository;

@Service
public class VeicoloNotificationService {
    
    @Autowired
    private VeicoloRepository veicoloRepository; // Interfaccia per accedere ai veicoli dal DB

    @Autowired
    private EmailService emailService; // Servizio per inviare le email

    @Scheduled(cron = "0 15 10 * * ?")
    public void verificaScadenzeVeicoli() {
        List<Veicolo> veicoli = veicoloRepository.findAll();  // Recupera tutti i veicoli

        // Ottieni la data odierna
        LocalDate today = LocalDate.now();

        // Cicla su ogni veicolo per controllare le scadenze
        for (Veicolo veicolo : veicoli) {
            verificaScadenzeTemporali(veicolo, today);
            verificaScadenzeChilometri(veicolo);
        }
    }

    private void verificaScadenzeTemporali(Veicolo veicolo, LocalDate today) {
        // Controlla il bollo, polizza, ecc.
        verificaScadenza(veicolo.getData_scadenza_bollo(), "Bollo", veicolo, today);
        verificaScadenza(veicolo.getData_scadenza_polizza(), "Polizza RCA", veicolo, today);

        // Calcola la scadenza della revisione (aggiungendo 2 anni all'ultima revisione)
        Date ultimaRevisione = veicolo.getData_revisione();
        if (ultimaRevisione != null) {
            // Aggiungi 2 anni alla data dell'ultima revisione
            LocalDate prossimaRevisione = convertToLocalDateViaInstant(ultimaRevisione).plusYears(2);

            // Verifica la scadenza della revisione
            verificaScadenza(prossimaRevisione, "Revisione", veicolo, today);
        }
    }

    private void verificaScadenzeChilometri(Veicolo veicolo) {
        // Verifica inversione gomme
        int kmInversione = veicolo.getChilometraggio_attuale() - veicolo.getChilometraggio_ultima_inversione();
        if (veicolo.getSoglia_inversione() - kmInversione <= 120) {
            emailService.sendEmail(veicolo, "Inversione gomme", kmInversione);
        }

        // Verifica sostituzione gomme
        int kmSostituzione = veicolo.getChilometraggio_attuale() - veicolo.getChilometraggio_ultima_sostituzione();
        if (veicolo.getSoglia_sostituzione() - kmSostituzione <= 120) {
            emailService.sendEmail(veicolo, "Sostituzione gomme", kmSostituzione);
        }

        // Verifica tagliando
        int kmTagliando = veicolo.getChilometraggio_attuale() - veicolo.getChilometraggio_ultimo_tagliando();
        if (veicolo.getSoglia_tagliando() - kmTagliando <= 120) {
            emailService.sendEmail(veicolo, "Tagliando", kmTagliando);
        }
    }

    private void verificaScadenza(Date dataScadenza, String tipoScadenza, Veicolo veicolo, LocalDate today) {
        if (dataScadenza == null) return;

        LocalDate scadenza = convertToLocalDateViaInstant(dataScadenza);
        verificaScadenza(scadenza, tipoScadenza, veicolo, today);
    }

    private void verificaScadenza(LocalDate dataScadenza, String tipoScadenza, Veicolo veicolo, LocalDate today) {
        long giorniAllaScadenza = ChronoUnit.DAYS.between(today, dataScadenza);

        // Controllo delle scadenze: 30 giorni, 20 giorni, 15 giorni, 7 giorni, 3 giorni, 1 giorno e scadenza passata
        if (giorniAllaScadenza == 30 || giorniAllaScadenza == 20 || giorniAllaScadenza == 15 || giorniAllaScadenza == 7 || giorniAllaScadenza == 3 || giorniAllaScadenza == 1 || giorniAllaScadenza <= 0) {
            emailService.sendEmail(veicolo, tipoScadenza, giorniAllaScadenza);
        }
    }

    // Metodo per convertire Date a LocalDate
    private LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
