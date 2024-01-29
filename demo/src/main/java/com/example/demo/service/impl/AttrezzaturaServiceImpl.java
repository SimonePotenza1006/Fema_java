package com.example.demo.service.impl;

import lombok.AllArgsConstructor;

import com.example.demo.entity.Attrezzatura;
import com.example.demo.repository.AttrezzaturaRepository;
import com.example.demo.service.AttrezzaturaService;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class AttrezzaturaServiceImpl implements AttrezzaturaService {
    
    private AttrezzaturaRepository attrezzaturaRepository;

    @Override
    public Attrezzatura createAttrezzatura(Attrezzatura attrezzatura) {
        return attrezzaturaRepository.save(attrezzatura);
    }

    @Override
    public Attrezzatura getAttrezzaturaById(int attrezzaturaId) {
        Optional<Attrezzatura> optionalAttrezzatura = attrezzaturaRepository.findById(attrezzaturaId);
        return optionalAttrezzatura.get();
    }

    @Override
    public List<Attrezzatura> getAllAttrezzature(){
        return attrezzaturaRepository.findAll();
    }

    @Override
    public Attrezzatura updateAttrezzatura(Attrezzatura attrezzatura){
        return attrezzaturaRepository.save(attrezzatura);
    }

    @Override
    public void deleteAttrezzatura(int attrezzaturaId) {
        attrezzaturaRepository.deleteById(attrezzaturaId);
    }

}
