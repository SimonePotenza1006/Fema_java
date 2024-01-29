package com.example.demo.service.impl;

import lombok.AllArgsConstructor;

import com.example.demo.entity.TipologiaCarta;
import com.example.demo.entity.CartaDiCredito;
import com.example.demo.service.TipologiaCartaService;
import com.example.demo.service.CartaDiCreditoService;
import com.example.demo.repository.CartaDiCreditoRepository;
import com.example.demo.repository.TipologiaCartaRepository;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;


@Service
@AllArgsConstructor
public class CartaDiCreditoServiceImpl implements CartaDiCreditoService{
    
    private CartaDiCreditoRepository cartaDiCreditoRepository;

    @Override
    public CartaDiCredito createCartaDiCredito(CartaDiCredito cartaDiCredito) {
        return cartaDiCreditoRepository.save(cartaDiCredito);
    }

    @Override
    public CartaDiCredito getCartaDiCreditoById(int cartaDiCreditoId) {
        Optional<CartaDiCredito> optionalCarta = cartaDiCreditoRepository.findById(cartaDiCreditoId);
        return optionalCarta.get();
    }

    @Override
    public List<CartaDiCredito> getAllCarteDiCredito() {
        return cartaDiCreditoRepository.findAll();
    }

    @Override
    public CartaDiCredito updateCartaDiCredito(CartaDiCredito cartaDiCredito){
        return cartaDiCreditoRepository.save(cartaDiCredito);
    }

    @Override
    public void deleteCartaDiCredito(int cartaDiCreditoId) {
        cartaDiCreditoRepository.deleteById(cartaDiCreditoId);
    }

}
