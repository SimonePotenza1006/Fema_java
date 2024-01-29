package com.example.demo.service;

import com.example.demo.entity.Attrezzatura;

import java.util.List;
import java.util.Set;

public interface AttrezzaturaService {
    
    Attrezzatura createAttrezzatura(Attrezzatura attrezzatura);

    Attrezzatura getAttrezzaturaById(int attrezzaturaId);

    List<Attrezzatura> getAllAttrezzature();

    Attrezzatura updateAttrezzatura(Attrezzatura attrezzatura);

    void deleteAttrezzatura(int attrezzaturaId);
}
