package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.form.FuncionarioForm;
import com.example.model.Funcionario;
import com.example.service.FuncionarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/funcionarios")
@Api(tags = "FuncionarioController", description = "Endpoints para manipulação de dados de funcionários")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/contagem-genero")
    @ApiOperation(value = "Retorna a quantidade de funcionários separados por sexo", response = List.class)
    public ResponseEntity<List<Object[]>> contagemPorGenero() {
        List<Object[]> result = funcionarioService.contagemPorGenero();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/funcionarios-genero-nascimento")
    @ApiOperation(value = "Retorna a quantidade de funcionários distintos por sexo, ano e ano de nascimento", response = List.class)
    public ResponseEntity<List<Object[]>> funcionariosGeneroEAnoNascimento() {
        List<Object[]> result = funcionarioService.funcionariosGeneroEAnoNascimento();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/media-min-max")
    @ApiOperation(value = "Retorna a média, mínimo e máximo de salário por sexo", response = List.class)
    public ResponseEntity<List<Object[]>> mediaMinMaxSalarioPorGenero() {
        List<Object[]> result = funcionarioService.mediaMinMaxSalarioPorGenero();
        return ResponseEntity.ok(result);
    }

    @PostMapping
    @ApiOperation(value = "Cria um novo funcionário")
    public Funcionario criarFuncionario(@RequestBody FuncionarioForm form) {
        return funcionarioService.criarFuncionario(form);

    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta um funcionário pelo ID")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable int id) {
        funcionarioService.deletarFuncionario(id);
        return ResponseEntity.noContent().build();
    }
}