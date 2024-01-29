package com.example.demo.service;

import com.example.demo.entity.Spesa;
import com.example.demo.entity.Viaggio;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface SpesaService {
    
    Spesa createSpesa(Spesa spesa);

	Spesa getSpesaById(int spesaId);

    List<Spesa> getAllSpese();

    List<Optional<Spesa>> getSpesaByViaggio(Viaggio viaggio);

    Spesa updateSpesa(Spesa spesa);

    void deleteSpesa(int spesaId);
}
