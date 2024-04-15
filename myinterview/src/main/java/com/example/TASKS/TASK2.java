package com.example.TASKS;

import com.example.model.MinhaLista;

/**
 * Task here is to write a lista. Each element must know the element before and
 * after it. Print out your lista and them remove the element in the middle of
 * the lista. Print out again.
 *
 */
public class TASK2 {

    public static void listaDeElementos(String[] args) {
        MinhaLista lista = new MinhaLista();
        lista.add("A");
        lista.add("B");
        lista.add("C");
        lista.add("D");
        lista.add("E");

        System.out.println("Lista original:");
        lista.printList();

        lista.removeValorDoMeio();

        System.out.println("Lista após remover o elemento do meio:");
        lista.printList();

    }
}
