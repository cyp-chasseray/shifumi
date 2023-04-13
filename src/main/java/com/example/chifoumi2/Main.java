package com.example.chifoumi2;

public class Main {
    public static void main(String[] args) {
        Serveur serveur = new Serveur("ciseaux");
        System.out.println(serveur.getChoix());
        System.out.println(serveur.getChoixOrdinateur());
        System.out.println(serveur.getMessageFinal());

    }
}
