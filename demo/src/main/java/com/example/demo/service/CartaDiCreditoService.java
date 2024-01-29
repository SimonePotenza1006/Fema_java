package com.example.demo.service;

import lombok.AllArgsConstructor;

import com.example.demo.entity.CartaDiCredito;
import com.example.demo.entity.Ruolo;
import com.example.demo.entity.Utente; 
import com.example.demo.entity.TipologiaCarta;
import com.example.demo.repository.RuoloRepository;
import com.example.demo.repository.UtenteRepository;
import com.example.demo.repository.CartaDiCreditoRepository;
import com.example.demo.repository.TipologiaCartaRepository;

import java.util.List;
import java.util.Set;

public interface CartaDiCreditoService {
    
    CartaDiCredito createCartaDiCredito(CartaDiCredito cartaDiCredito);

    CartaDiCredito getCartaDiCreditoById(int id);

    List<CartaDiCredito> getAllCarteDiCredito();

    CartaDiCredito updateCartaDiCredito(CartaDiCredito carta);

    void deleteCartaDiCredito(int id);

}
