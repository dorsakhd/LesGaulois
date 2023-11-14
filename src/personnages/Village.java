package personnages;

public class Village {
private String nom;
private Chef chef;
private Gaulois[] villageois;
private int nbVillageois; 

public Village(String nom, int nbVillageoisMaximum) {
    this.nom = nom;
    this.nbVillageois = 0;
    this.villageois = new Gaulois[nbVillageoisMaximum];
}
public void setChef(Chef chef) {
this.chef = chef;
}
public String getNom() {
return nom;
}
//public void ajouterHabitants(Gaulois gaulois) {
//    if (nbVillageois < villageois.length) {
//        villageois[nbVillageois] = gaulois;
//        nbVillageois++;
//        System.out.println(gaulois.getNom() + " a été ajouté au village de " + nom);
//    } else {
//        System.out.println(" village est full.");
//    }
//}
public void ajouterHabitants(Gaulois gaulois) {
	villageois[nbVillageois]=gaulois;
	nbVillageois++;
}
public Gaulois trouverHabitant(int numero) {
	return villageois[numero];
}
public void afficherVillageois(Chef chef) {
	System.out.println("Dans village du chef "+chef.getNom()+" vivent les légendaires gaulois :\n ");
	for(int i=0; i<nbVillageois; i++) {
		System.out.println("-"+trouverHabitant(i).getNom()+"\n"); 
	}
}
public static void main(String[] args) {
	Village village=new Village("Village des Irreductible",30);
//	Gaulois gaulois=village.trouverHabitant(30);
//On obtient l'erreur Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 30 out of bounds for length 30 car les éléments du tableau vont de 0 à 29, alors que 30 est la taille du tableau.
//	Chef abaracourcix = new Chef("abaracourcix",6,village);
//	village.setChef(abaracourcix);
//	Gaulois astérix=new Gaulois("astérix",8);
//	village.ajouterHabitants(astérix);
//	Gaulois gaulois = village.trouverHabitant(1);
//	System.out.println(gaulois);
//	On obtient null car asterix est à l'indice 0 pas 1.
	Chef abaracourcix = new Chef("Abraracourcix",6,village);
	Gaulois asterix=new Gaulois("asterix",8);
	village.ajouterHabitants(asterix);
	Gaulois obelix=new Gaulois("obelix",25);
	village.ajouterHabitants(obelix);
	village.afficherVillageois(abaracourcix);
	
}

}