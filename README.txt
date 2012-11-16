GRIJINCU SILVIU 
323CB
TEMA 2 - SAH


Class Piesa  -  clasa abstracta care este extinsa de fiecare "Piesa" in parte.
Fiecare piesa are o clasa propirie.


Tura.java -  extinde clasa Regina, intrucat impartasesc o parte din proprietati/ mutari;
		Tura este o "regina" care se poate misca doar pe x sau pe y.


Nebun.java - extinde clasa Regina, intrucat impartasesc o parte din proprietati/mutari;
		Nebunul este o "regina" care se poate misca doar pe diagonala.


Regina.java - ofera doi constructori:
	    	* unul pentru clasele care o extind si care nu ar trebui folosit de utilizator
		  el fiind si definit "protected"
	    	* unul public, prin care utilizatorul instantiaza o noua piesa "regina"

Sah.java	- creeaza o matrice cu obiecte de tip Piesa
		