package histoire;

import personnages.Druide;
import personnages.Equipement;
import personnages.Gaulois;
import personnages.Romain;
//import villagegaulois.Musee;

public class Scenario {

	public static void main(String[] args) {
		Druide druide = new Druide("Panoramix", 5, 10);
		druide.parler("Je vais aller preparer une petite potion...");
//		druide.preparerPotion();
		Gaulois obelix = new Gaulois("Obelix", 25);
		Gaulois asterix = new Gaulois("Asterix", 8);
//		druide.booster(obelix);
		obelix.parler("Par Belenos, ce n'est pas juste !");
//		druide.booster(asterix);
		asterix.parler("Bonjour");
		Romain minus = new Romain("Minus", 6);
		Romain milexcus = new Romain("Milexcus", 8);
		minus.sEquiper(Equipement.Bouclier);
		minus.sEquiper(Equipement.Casque);
		milexcus.sEquiper(Equipement.Casque);
		minus.parler("UN GAU... UN GAUGAU...");

		do {
			asterix.frapper(minus);
		} while (minus.getForce()>=0);
		milexcus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(milexcus);
		do {
			asterix.frapper(milexcus);
		} while (milexcus.getForce() >= 0);
		
//		Partie a decommenter
		
//		Musee musee = new Musee();
//		asterix.faireUneDonnation(musee);

	}

}
