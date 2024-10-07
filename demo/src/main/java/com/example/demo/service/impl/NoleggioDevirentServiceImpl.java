package com.example.demo.service.impl;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.NoleggioDevirent;
import com.example.demo.repository.NoleggioDevirentRepository;
import com.example.demo.service.NoleggioDevirentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NoleggioDevirentServiceImpl implements NoleggioDevirentService{
    
    @Autowired
    private NoleggioDevirentRepository noleggioRepository;

    @Override
    public NoleggioDevirent createNoleggio(NoleggioDevirent noleggio){
        return noleggioRepository.save(noleggio);
    }

    @Override
    public NoleggioDevirent getNoleggioByFilename(String filename){
        return noleggioRepository.findByFilename(filename);
    }

    @Override
    public void deleteNoleggio(int noleggioId){
        noleggioRepository.deleteById(noleggioId);
    }
}
