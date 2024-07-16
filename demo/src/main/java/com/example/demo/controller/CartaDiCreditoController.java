package com.example.demo.controller;
import lombok.AllArgsConstructor;
import com.example.demo.entity.CartaDiCredito;
import com.example.demo.service.CartaDiCreditoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/cartadicredito")
public class CartaDiCreditoController {
    
    private CartaDiCreditoService cartaDiCreditoService;

    @PostMapping
    public ResponseEntity<CartaDiCredito> createCartaDiCredito(@RequestBody CartaDiCredito cartaDiCredito){
    	CartaDiCredito savedCartaDiCredito = cartaDiCreditoService.createCartaDiCredito(cartaDiCredito);
        return new ResponseEntity<>(savedCartaDiCredito, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CartaDiCredito> getCartaDiCredito(@PathVariable("id") int cartaDiCreditoId){
    	CartaDiCredito cartaDiCredito = cartaDiCreditoService.getCartaDiCreditoById(cartaDiCreditoId);
        return new ResponseEntity<>(cartaDiCredito, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CartaDiCredito>> getAllCarteDiCredito(){
        List<CartaDiCredito> carteDiCredito = cartaDiCreditoService.getAllCarteDiCredito();
        return new ResponseEntity<>(carteDiCredito, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<CartaDiCredito> updateCartaDiCredito(@RequestBody CartaDiCredito cartaDiCredito) throws IOException {
        CartaDiCredito updatedCartaDiCredito = cartaDiCreditoService.updateCartaDiCredito(cartaDiCredito);
        return new ResponseEntity<>(updatedCartaDiCredito, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCartaDiCredito(@PathVariable("id") int cartaDiCreditoId) {
        cartaDiCreditoService.deleteCartaDiCredito(cartaDiCreditoId);
        return new ResponseEntity<>("Carta di credito successfully deleted!", HttpStatus.OK);
    }
}
