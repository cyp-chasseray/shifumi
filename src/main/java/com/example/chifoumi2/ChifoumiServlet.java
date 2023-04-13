package com.example.chifoumi2;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(urlPatterns = {"/","/jouer"})
public class ChifoumiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jouer.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Récupère la session ou en crée une nouvelle
        HttpSession session = request.getSession();

        //Récupère l'attribut resultatCount du tour précédent, ou en initialise 1 si la session est nouvelle
        ResultatCount resultatCount = (ResultatCount) session.getAttribute("resultatCount");
        if (resultatCount == null) {
            resultatCount = new ResultatCount();
            session.setAttribute("resultatCount", resultatCount);
        }

        //Récupère le choix de l'utilisateur entré dans le formulaire grâce à la méthode post
        String choix = request.getParameter("choix");

        //Joue au jeu via l'objet serveur
        Serveur serveur = new Serveur(choix);

        //Met à jour le compteur de victoires ou de défaites en fonction du résultat de la manche (messageFinal)
        resultatCount.updateResultat(serveur.getMessageFinal());

        //Remplit les choix user et ordinateur à utiliser dans la page JSP
        request.setAttribute("choix", choix);
        request.setAttribute("choixOrdinateur", serveur.getChoixOrdinateur());

        //Remplit l'attribut messageFinal à afficher sur la JSP
        //Indique le vainqueur des manches, mais change pour indiquer le vainqueur final en cas de 3 victoires ou défaites
        //Ferme la session si les 3 victoires ou defaites sont atteintes
        if (resultatCount.victoryCount >= 3) {
            session.invalidate();
            request.setAttribute("messageFinal", "Vous avez gagné la partie !");
        } else if (resultatCount.defeatCount >= 3) {
            session.invalidate();
            request.setAttribute("messageFinal", "Vous avez perdu la partie !");
        } else {
            request.setAttribute("messageFinal", serveur.getMessageFinal());
        }

        //Déclenche l'envoi des attributs vers la page
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/resultat.jsp");
        rd.forward(request, response);
    }
}