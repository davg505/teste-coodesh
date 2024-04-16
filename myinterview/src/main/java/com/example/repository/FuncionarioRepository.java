package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    @Query("SELECT f.genero, AVG(f.salario), MIN(f.salario), MAX(f.salario) FROM Funcionario f GROUP BY f.genero")
    List<Object[]> mediaMinMaxSalarioPorGenero();

    @Query("SELECT f.genero, YEAR(f.dataNascimento), COUNT(DISTINCT f.id) FROM Funcionario f GROUP BY f.genero, YEAR(f.dataNascimento)")
    List<Object[]> funcionariosGeneroEAnoNascimento();

    @Query("SELECT f.genero, COUNT(f) FROM Funcionario f GROUP BY f.genero")
    List<Object[]> contagemPorGenero();
}
