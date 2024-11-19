package com.example.demo.repository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;
import com.example.demo.entity.TipoTask;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TipoTaskRepository extends JpaRepository<TipoTask, Integer>{
    Optional<TipoTask> findById(int tipoId);
    List<TipoTask> findAll();
}
