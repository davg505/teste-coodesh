package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.ContagemGeneroService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(tags = "ContagemGeneroControle", description = "Endpoints para manipulação de dados de contagem de gênero - TASK4")
public class ContagemGeneroControle {

    @Autowired
    private ContagemGeneroService contagemGeneroService;

    @ApiOperation(value = "Buscar dados e salvar no S3", response = String.class)
    @GetMapping("/process-data-and-save")
    public String processoDosDadosESalvamentoS3() {
        return contagemGeneroService.processoDosDadosESalvamentoS3();
    }

}