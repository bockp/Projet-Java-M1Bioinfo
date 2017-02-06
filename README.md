# Projet-Java-M1Bioinfo

Sujet
Votre laboratoire de biologie se lance dans une étude approfondie de l’apprentissage chez les espèces
animales. Pour commencer vos collègues ont décidé de comparer la vitesse d’apprentissage d’espèces
considérées comme non-parentes afin d’identifier d’éventuelles similarités.

L’étude concerne un groupe de souris qui sera comparé à un groupe de singes. Etant donné les 2 espèces
étudiées, les expériences seront différentes.

Pour les souris, on dispose de 2 groupes. Pour le premier groupe, on mettra en place l’apprentissage d’un
labyrinthe, on mesure le temps que la souris met pour atteindre la sortie. On considère que la sortie est
toujours au même endroit d’une expérimentation à l’autre. Pour le second groupe, on met en place le
test de la nourriture. Dans un espace clos, on positionne 5 cachettes et dans l’une d’entre elles on met
de la nourriture.
On note si la souris est capable de trouver la cachette et après combien de visites des
cachettes.
Si au bout d’un certain temps prédéfini, elle n’a pas trouvé on considère que c’est un échec.
Pour les singes, on présente aux singes un écran avec une image puis on la fait disparaitre. Aprés 1 minute,
on rallume l’écran avec 10 images dont celle affichée au premier écran. On demande alors au singe de
retrouver cette image. On compte combien d’images il a choisi avant de retrouver la bonne. Aprés 8
échecs on considère que l’exercice est raté.
Une récompense sous forme de friandise lui est donnée si il
réussi. Cette exercice est répété 5 fois dans l’heure, le jeu d’images est toujours le même.
Ces expériences ont lieu pendant une semaine et se répète chaque jour pendant 5jours.
A la fin de la semaine, on analyse les résultats pour évaluer pour chaque espèce si il y a eu apprentissage
et qu’elle est le pourcentage de progression de chaque animal. Enfin, on s’intéresse au niveau de stress
induit par ces épreuves. La mesure de stress sera évaluée en fonction du poids de l’animal. On considère
qu’un animal qui aura perdu du poids entre le début de la semaine et la fin, sera un animal stressé.

Données à mémoriser

Votre programme doit permettre la réalisation de certaines tâches à l’entrée des animaux dans l’étude :

• Enregistrer les animaux qui entrent dans l’étude : identifiant, sexe, poids.

• Afficher par espèces tous les animaux qui sont dans l’étude.


Le protocole de l’étude précise les valeurs que vous devez relever :

• Chaque jour vous devez relever le poids de tous les animaux qui participent à l’étude.

• le statut de l’animal : vivant ou mort, car évident vous pourriez perdre des animaux au cours de la
semaine !


• Au cours des tests :

1– Pour le test labyrinthe : le temps du test en seconde.

– Pour le test nourriture : le nombre de cachette visitée et si la souris a réussi à atteindre la
nourriture avant le temps limite .

– Pour le test image : le score obtenu à chaque test, i.e. combien d’échec avant de retrouver
l’image.

• Prévoir une sauvegarde des données soit en “bloc” soit chaque jour pour pouvoir aisément reprendre
la saisie et/ou les calculs.

Bilan toutes les semaines Tous les vendredis vous devez faire le bilan de la semaine
Les données que vous devez calculées sont:

• Afficher pour chaque animal :

– Si il y a eu apprentissage, i.e. amélioration des performances au cours de la semaine. On
pourra calculer un apprentissage en fonction du pourcentage d’amélioration des résultats. Par
exemple, si le lundi le singe a besoin de 5 essais en moyenne et que le vendredi il lui suffit de
2 essais, sa progression est de 40%.

– Quel est le jour où il a fait sa meilleure performance.

– Si il est en état de stress/fatigue. On considérera qu’il est en état de fatigue si il a perdu plus
de 10% de son poids.

• Afficher pour toute l’étude quel est l’animal qui a le meilleur apprentissage chez les souris et chez
les singes. Et qui des singes ou des souris a le plus appris pendant la semaine. Vous pourrez afficher
toutes informations utiles sur les “gagnants” pour tacher d’identifier si les résultats pourraient être
liés au poids ? au sexe? des animaux.

• Afficher si ces performances sont associées à un état de stress. Les animaux n’ayant pas ou peu
appris, sont-ils en meilleur état que les meilleurs “compétiteurs” ?

NB : le propos ici n’est pas d’implémenter un programme statistique, on se contentera d’informations
basiques : min, max, moyenne ou médiane.


Indications


Votre programme doit être structuré de façon à permettre une bonne factorisation du code au travers
des différents traitements.
Le protocole de cette étude doit pouvoir être facilement remplacé par un autre protocole défini par
un autre ensemble de tests. Vous indiquerez dans votre rapport quelles sont les classes qui seraient à
réimplémenter pour changer de jeux de tests.
Il doit être aisé d’ajouter d’autres modules par exemple pour définir d’autres populations animales pour
l’enquête ou d’autres semaines.
N’oubliez pas de fournir un jeu d’essai de vos données sous forme de fichiers.
