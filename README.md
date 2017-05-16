# BatailleNavale

## commande de build 
### ant build

## commande de lancement :
### ant Launcher


## commande de tests :
### ant GridTests
### ant ShipCellTests
### ant SeaCellTests

## Modification apporté ( Deuxieme partie du projet )
### Ajout de la stratégie Path qui fait emprunter à l'ordinateur une case voisine si elle est disponible sinon on choisit une case random
### L'ajout de la nouvelle stratégie n'a necessité aucune modification quand au code seulement des ajouts, donc l'architecture respecte bien l'open-close principle.
### Cependant le seul problème est que l'interface graphique n'affiche aucune action de l'ordinateur donc on ne peux pas tester le bon fonctionnement
