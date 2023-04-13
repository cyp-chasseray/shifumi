<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Jeu de Chifoumi</title>
</head>
<body>
<h1>Jeu de Chifoumi</h1>
<form method="post" action="jouer">
  <p>
    <label for="choix">Choisissez votre coup :</label>
    <select id="choix" name="choix">
      <option value="pierre">Pierre</option>
      <option value="feuille">Feuille</option>
      <option value="ciseaux">Ciseaux</option>
    </select>
  </p>
  <button type="submit">Jouer</button>
</form>
</body>
</html>