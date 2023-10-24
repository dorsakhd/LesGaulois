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
public Village(String nom) {
this.nom = nom;
this.nbVillageois = 0;
}
public void setChef(Chef chef) {
this.chef = chef;
}
public String getNom() {
return nom;
}
public void ajouterHabitant(Gaulois gaulois) {
    if (nbVillageois < villageois.length) {
        villageois[nbVillageois] = gaulois;
        nbVillageois++;
        System.out.println(gaulois.getNom() + " a été ajouté au village de " + nom);
    } else {
        System.out.println(" village est full.");
    }
}

}
