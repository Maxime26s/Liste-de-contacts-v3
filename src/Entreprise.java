import java.io.Serializable;

public class Entreprise implements Serializable{
    private String nom;
    private Adresse adresse = new Adresse();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void ajouterEntreprise(){
        System.out.println("  Entreprise : ");
        System.out.print("    Nom : ");
        nom=Main.verifyFormatCreation();;
        getAdresse().ajouterAdresse();
    }

    public void modifierEntreprise(){
        String input;
        System.out.println("  Entreprise : ");
        System.out.print("    Nom (" + nom+ ") : ");
        input=Main.sc.nextLine().trim();
        if(!input.equals("")) {
            nom=Main.verifyFormatModification(input);
        }
        getAdresse().modifierAdresse();
    }

    public void afficherEntreprise(){
        System.out.println("  Entreprise : ");
        System.out.println("    Nom : "+nom);
        getAdresse().afficherAdresse();
    }
}