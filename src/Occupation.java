import java.io.Serializable;

public class Occupation implements Serializable{
    private String poste;
    private Entreprise entreprise = new Entreprise();

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public void ajouterOccupation(){
        System.out.println("Occupation : ");
        System.out.print("  Poste :");
        poste=Main.verifyFormatCreation();;
        getEntreprise().ajouterEntreprise();
    }

    public void modifierOccupation(){
        String input;
        System.out.println("Occupation : ");
        System.out.print("  Poste (" + poste + ") : ");
        input=Main.sc.nextLine().trim();
        if(!input.equals("")) {
            poste=Main.verifyFormatModification(input);
        }
        getEntreprise().modifierEntreprise();
    }

    public void afficherOccupation(){
        System.out.println("Occupation : ");
        System.out.println("  Poste : "+poste);
        getEntreprise().afficherEntreprise();
    }
}