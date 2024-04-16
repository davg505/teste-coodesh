package com.example.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FuncionarioForm {

    @Schema(example = "nome")
    private String nome;

    @Schema(example = "M")
    private String genero;

    @Schema(example = "1990")
    private int anoNascimento;

    @Schema(example = "3000")
    private String salario;

}
