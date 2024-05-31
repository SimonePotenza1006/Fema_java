package com.example.demo.repository;
import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.NoteSivis;

@Repository
public interface NoteSivisRepository extends JpaRepository<NoteSivis, Integer>{
    List<NoteSivis> findAllByOrderByIdDesc();
}
