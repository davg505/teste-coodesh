package com.example.TASKS;

import java.util.Scanner;

/**
 * 
 *
 * Task here is to implement a function that says if a given string is
 * palindrome.
 * 
 * 
 * 
 * Definition=> A palindrome is a word, phrase, number, or other sequence of
 * characters which reads the same backward as forward, such as madam or
 * racecar.
 */
public class TASK1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Entra com  valor da string: ");
        String string = scanner.nextLine();
        if (verificadorPalíndromo(string)) {
            System.out.println("Esta string é palíndromo.");
        } else {
            System.out.println("Esta string é não palíndromo.");
        }
        scanner.close();
    }

    public static boolean verificadorPalíndromo(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int valorDaEsquerda = 0;
        int valorDaDireta = str.length() - 1;
        while (valorDaEsquerda < valorDaDireta) {
            if (str.charAt(valorDaEsquerda) != str.charAt(valorDaDireta)) {
                return false;
            }
            valorDaEsquerda++;
            valorDaDireta--;
        }
        return true;
    }

}