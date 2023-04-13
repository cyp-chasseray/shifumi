package com.example.chifoumi2;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Serveur {
    private String choix;
    List<String> options = Arrays.asList("pierre", "papier", "ciseaux");
    Random rand = new Random();
    String choixOrdinateur;
    String messageFinal;
    Serveur(String choix) {
        this.choix = choix;
        this.choixOrdinateur = this.options.get(this.rand.nextInt(this.options.size()));
        if (choix.equals(this.choixOrdinateur)) {
            this.messageFinal = "Match nul";
        } else if (choix.equals("pierre") && this.choixOrdinateur.equals("ciseaux") ||
                choix.equals("ciseaux") && this.choixOrdinateur.equals("feuille") ||
                choix.equals("feuille") && this.choixOrdinateur.equals("pierre")) {
            this.messageFinal = "1 point pour toi!";
        } else {
            this.messageFinal = "1 point pour l'ordinateur!";
        }
    }

    public String getChoix() {
        return this.choix;
    }

    public String getChoixOrdinateur() {
        return this.choixOrdinateur;
    }

    public String getMessageFinal() {
        return this.messageFinal;
    }

}
