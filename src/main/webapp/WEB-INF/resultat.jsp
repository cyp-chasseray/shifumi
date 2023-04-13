<%--
  Created by IntelliJ IDEA.
  User: Aerosson
  Date: 13/04/2023
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resultats</title>
</head>
<body>
<p>Vous avez choisi ${choix} </p>
<p>L'ordinateur choisit ${choixOrdinateur}</p>
<p>Résultat: ${messageFinal} </p>

<form method="get" action="jouer">
<button>Jouer à nouveau</button>
</form>

</body>
</html>
