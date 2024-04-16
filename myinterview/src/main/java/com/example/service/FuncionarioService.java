package com.example.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.form.FuncionarioForm;
import com.example.model.Funcionario;
import com.example.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Object[]> contagemPorGenero() {
        return funcionarioRepository.contagemPorGenero();
    }

    public List<Object[]> funcionariosGeneroEAnoNascimento() {
        return funcionarioRepository.funcionariosGeneroEAnoNascimento();
    }

    public List<Object[]> mediaMinMaxSalarioPorGenero() {
        return funcionarioRepository.mediaMinMaxSalarioPorGenero();
    }

    public Funcionario criarFuncionario(FuncionarioForm funcionarioForm) {
        // Converter os dados para os tipos corretos

        BigDecimal salario = new BigDecimal(funcionarioForm.getSalario());

        // Criar o objeto Funcionario
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(funcionarioForm.getNome());
        funcionario.setGenero(funcionarioForm.getGenero());
        funcionario.setDataNascimento(funcionarioForm.getAnoNascimento());
        funcionario.setSalario(salario);

        // Salvar o funcionário no banco de dados
        return funcionarioRepository.save(funcionario);
    }

    public void deletarFuncionario(int id) {
        funcionarioRepository.deleteById(id);
    }

}