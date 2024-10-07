package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.NoleggioDevirent;

public interface NoleggioDevirentService {
    
    NoleggioDevirent createNoleggio(NoleggioDevirent noleggio);

    NoleggioDevirent getNoleggioByFilename(String filename);

    void deleteNoleggio(int noleggioId);
}
