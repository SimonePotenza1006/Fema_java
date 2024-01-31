package com.example.demo.service.impl;

import lombok.AllArgsConstructor;

import com.example.demo.service.CategoriaDDTService;
import com.example.demo.entity.CategoriaDDT;
import com.example.demo.entity.Ruolo;
import com.example.demo.repository.CategoriaDDTRepository;


import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;


@Service
@AllArgsConstructor
public class CategoriaDDTServiceImpl implements CategoriaDDTService{
    
    private CategoriaDDTRepository categoriaDDTRepository;

    @Override
    public CategoriaDDT createCategoriaDDT(CategoriaDDT categoriaDDT) {
        return categoriaDDTRepository.save(categoriaDDT);
    }

    @Override
    public CategoriaDDT getCategoriaDDTById(int categoriaDDTId) {
        Optional<CategoriaDDT> optionalCategoriaDDT = categoriaDDTRepository.findById(categoriaDDTId);
        return optionalCategoriaDDT.get();
    }

    @Override
    public List<CategoriaDDT> getAllCategorieDDT() {
        return categoriaDDTRepository.findAll();
    }

    @Override
    public CategoriaDDT updateCategoria(CategoriaDDT categoriaDDT) {
        return categoriaDDTRepository.save(categoriaDDT);
    }

    @Override
    public void deleteCategoria(int categoriaId) {
    	categoriaDDTRepository.deleteById(categoriaId);
    }
}
