package personnages;

public class Romain {
	
	private String nom;
	private int force;
    private Equipement[] equipements = new Equipement[2];
    public int nbEquipement=0;
	private String texte;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
//	public void recevoirCoup(int forceCoup) {
//		force -= forceCoup;
//		if (force > 0) {
//			parler("A�e");
//		} else {
//			parler("J'abandonne...");
//		}
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// precondition
		assert force > 0;
		int oldForce = force;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// 		parler("Aie");
		// } else {
		// 		equipementEjecte = ejecterEquipement();
		// 		parler("J'abandonne...");
		// }
		
		switch (force) {
		case 0:
			parler("Aie");
		default:
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			break;
			}
			// post condition la force
			assert force < oldForce;
			return equipementEjecte;
		}
	
	private int CalculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
			texte += "\nMais heureusement, grace � mon �quipement sa force est diminu� de ";
		for (int i = 0; i < nbEquipement;) {
			if ((equipements[i] != null && equipements[i].equals(Equipement.Bouclier)) == true) {
					resistanceEquipement += 8;
			} else {
				System.out.println("Equipement casque");
				resistanceEquipement += 5;
			}
			i++;
		}
		texte =+ resistanceEquipement + "!";
	}
	parler(texte);
	forceCoup -= resistanceEquipement;
	return forceCoup;
}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'equipement de " + nom.toString() + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
				continue;
			} else {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
				}
			}
			return equipementEjecte;
		}


	
	public void sEquiper(Equipement equipement) {
		switch(nbEquipement) {
		case 2:
			System.out.println("Le soldat " + nom + " est deja bien proteger");
			break;
		case 1:
			
			if (equipements[0]==equipement){
					System.out.println("Le soldat "+ nom + " possede deja un " + equipement);
					break;
				}
				else {
					nbEquipement+=1;
					equipements[0] = equipement.Casque;
					System.out.println("Le soldat "+ nom + "s'equipe avec un " + equipement);

				}
				
		break;
		
		case 0:
			switch(equipement) {
			case Casque:
				nbEquipement+=1;
				equipements[0] = equipement.Casque;
				System.out.println("Le soldat "+ nom + "s'equipe avec un " + equipement );
				break;
			case Bouclier:
				nbEquipement+=1;
				equipements[0] = equipement.Bouclier;
				System.out.println("Le soldat "+ nom + "s'equipe avec un " + equipement);
				break;
			default:
				break;
			}
			break;
		default:
			break;
		}
			
	}
		

	public static void main(String[] args) {
		Romain minus= new Romain("Minus",6);		
		minus.sEquiper(Equipement.Casque);
		minus.sEquiper(Equipement.Casque);
		minus.sEquiper(Equipement.Bouclier);
		minus.sEquiper(Equipement.Casque);
	}
	public int getForce() {
		return 0;
	}
}
