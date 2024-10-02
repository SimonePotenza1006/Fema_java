package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Veicolo;

@Service
public class EmailService {
    
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(Veicolo veicolo, String tipoScadenza, long giorniAllaScadenza) {
        String to = "s.potenza@femasistemi.it";  // Email destinatario

        String subject = "Scadenza " + tipoScadenza + " per veicolo " + veicolo.getDescrizione();

        String text = "Il veicolo " + veicolo.getDescrizione() + 
                      " ha una scadenza per " + tipoScadenza +
                      " tra " + giorniAllaScadenza + " giorni.";

        // Costruisci il messaggio email
        SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("noreply@femasistemi.it");  // Imposta l'indirizzo del mittente
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);

            mailSender.send(message);
        }

    public void sendEmail(Veicolo veicolo, String tipoIntervento, int kmPercorsi) {
        String to = "s.potenza@femasistemi.it";

        String subject = "Scadenza chilometrica per " + tipoIntervento + " del veicolo " + veicolo.getDescrizione();

        String text = "Il veicolo " + veicolo.getDescrizione() +
                      " richiede un " + tipoIntervento +
                      " entro 120 km. Chilometri percorsi dall'ultimo intervento: " + kmPercorsi;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);
    }
}
