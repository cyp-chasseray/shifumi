package com.example.chifoumi2;

public class ResultatCount {
    int victoryCount;
    int defeatCount;

    public void updateResultat(String messageFinal) {
        if (messageFinal.equals("1 point pour toi!")) {
            victoryCount +=1;
        } else if (messageFinal.equals("1 point pour l'ordinateur!")) {
            defeatCount +=1;
        }
    }


}
