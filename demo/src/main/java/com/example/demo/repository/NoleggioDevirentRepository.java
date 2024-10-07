package com.example.demo.repository;
import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.NoleggioDevirent;

@Repository
public interface NoleggioDevirentRepository extends JpaRepository<NoleggioDevirent, Integer> {
    NoleggioDevirent findByFilename(String filename);
}
