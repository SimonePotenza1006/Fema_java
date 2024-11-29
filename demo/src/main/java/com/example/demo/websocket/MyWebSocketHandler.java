package com.example.demo.websocket;

import com.example.demo.entity.Intervento;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.concurrent.CopyOnWriteArraySet;

@Component
public class MyWebSocketHandler extends TextWebSocketHandler {

    // Set per tracciare le sessioni aperte
    private final CopyOnWriteArraySet<WebSocketSession> sessions = new CopyOnWriteArraySet<>();
    private final ObjectMapper objectMapper = new ObjectMapper(); // Per serializzare oggetti in JSON

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        // Aggiungi la sessione al set quando la connessione è stabilita
        sessions.add(session);
        System.out.println("Connessione aperta: " + session.getId());
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        // Stampa il messaggio ricevuto
        System.out.println("Messaggio ricevuto: " + message.getPayload());
        // (opzionale) puoi rispondere al client se necessario
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, org.springframework.web.socket.CloseStatus status) {
        // Rimuovi la sessione dal set quando la connessione è chiusa
        sessions.remove(session);
        System.out.println("Connessione chiusa: " + session.getId());
    }

    // Metodo per fare il broadcast dei messaggi a tutte le sessioni
    public void broadcast(String message) {
        for (WebSocketSession session : sessions) {
            try {
                session.sendMessage(new TextMessage(message));
            } catch (Exception e) {
                System.out.println("Errore nell'invio del messaggio: " + e.getMessage());
            }
        }
    }

    // Metodo specifico per inviare nuovi interventi
    public void broadcastIntervento(Intervento intervento) {
        try {
            String jsonMessage = objectMapper.writeValueAsString(intervento);
            broadcast(jsonMessage);
        } catch (Exception e) {
            System.out.println("Errore durante la serializzazione dell'intervento: " + e.getMessage());
        }
    }
}
