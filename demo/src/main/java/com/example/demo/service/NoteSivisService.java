package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.NotaTecnico;
import com.example.demo.entity.NoteSivis;

public interface NoteSivisService {
    
    NoteSivis createNota(NoteSivis nota);

    NoteSivis getNotaById(int notaId);

    List<NoteSivis> getAllNoteOrderByDesc();
}
