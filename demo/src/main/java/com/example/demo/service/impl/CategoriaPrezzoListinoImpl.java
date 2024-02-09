package com.example.demo.service.impl;

import lombok.AllArgsConstructor;

import com.example.demo.entity.Attivita;
import com.example.demo.entity.CategoriaInterventoSpecifico;
import com.example.demo.entity.CategoriaPrezzoListino;
import com.example.demo.repository.CategoriaPrezzoListinoRepository;
import com.example.demo.service.CategoriaPrezzoListinoService;




import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;


@Service
@AllArgsConstructor
public class CategoriaPrezzoListinoImpl implements CategoriaPrezzoListinoService {
    
    private CategoriaPrezzoListinoRepository categoriePrezzoListinoRepository;

    @Override
    public CategoriaPrezzoListino createCategoriaPrezzoListino(CategoriaPrezzoListino categoriaPrezzoListino) {
        return categoriePrezzoListinoRepository.save(categoriaPrezzoListino);
    }

    @Override
    public CategoriaPrezzoListino getCategoriaPrezzoListinoById(int categoriaPrezzoListinoId) {
        Optional<CategoriaPrezzoListino> optionalCategoriaPrezzoListino = categoriePrezzoListinoRepository.findById(categoriaPrezzoListinoId);
        return optionalCategoriaPrezzoListino.get();
    }

    @Override
    public List<CategoriaPrezzoListino> getAllCategoriePrezzoListini() {
        return categoriePrezzoListinoRepository.findAll();
    }

    @Override
    public List<Optional<CategoriaPrezzoListino>> getPrezzoListinoByCategoria(CategoriaInterventoSpecifico categoriaInterventoSpecifico){
        return categoriePrezzoListinoRepository.findByCategoriaInterventoSpecifico(categoriaInterventoSpecifico);
    }

    @Override
    public CategoriaPrezzoListino updateCategoriaPrezzoListino(CategoriaPrezzoListino categoriaPrezzoListino) {
        return categoriePrezzoListinoRepository.save(categoriaPrezzoListino);
    }

    @Override
    public void deleteCategoriaPrezzoListino(int categoriaPrezzoListinoId) {
    	categoriePrezzoListinoRepository.deleteById(categoriaPrezzoListinoId);
    }

}
