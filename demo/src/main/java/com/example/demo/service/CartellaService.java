package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Cartella;


public interface CartellaService {
    
    Cartella createCartella(Cartella cartella);

    Cartella getCartellaById(int cartellaId);

    List<Cartella> getAllCartelle();

    List<Cartella> getCartelleByParentFolder(Cartella cartella);

    Cartella updateCartella(Cartella cartella);

    void deleteCartella(int cartellaId);
}
