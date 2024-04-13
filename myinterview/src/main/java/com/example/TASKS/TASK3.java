package com.example.TASKS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Write a list and add an aleatory number of Strings. In the end, print out how
 * many distinct itens exists on the list.
 *
 */
public class TASK3 {
    public static void main(String[] args) {

        List<String> listaDeJogos = new ArrayList<String>();

        listaDeJogos.add("The Legend of Zelda: Ocarina of Time");
        listaDeJogos.add("Tony Hawk's Pro Skater 2");
        listaDeJogos.add("Red Dead Redemption 2");
        listaDeJogos.add("Super Mario");
        listaDeJogos.add("GTA 5");

        Set<String> uniqueItems = new HashSet<String>(listaDeJogos);

        System.out.println("Número de itens distintos na lista: " + uniqueItems.size());
    }
}
