package com.example.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class MinhaLista {

    private List<String> elementosDaLista;
    private int indice;

    public MinhaLista() {
        elementosDaLista = new ArrayList<>();
        indice = -1;
    }

    public void add(String data) {
        elementosDaLista.add(data);
        atualizarIndice();
    }

    private void atualizarIndice() {
        indice = elementosDaLista.size() / 2;
    }

    public void printList() {
        for (String elemento : elementosDaLista) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }

    public void removeValorDoMeio() {
        if (elementosDaLista.size() % 2 != 0) {
            elementosDaLista.remove(indice);
            atualizarIndice();
        }
    }

    public int numeroItensDistintos() {
        return elementosDaLista.size();
    }
}
