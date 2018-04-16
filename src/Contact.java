import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Character.toLowerCase;

public class Contact implements Serializable{
    private String prenom;
    private String nom;
    private Adresse adresse = new Adresse();
    private Occupation occupation = new Occupation();
    private ArrayList<Telephone> telephone = new ArrayList<>();

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

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

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public ArrayList<Telephone> getTelephone() {
        return telephone;
    }

    public void setTelephone(ArrayList<Telephone> telephone) {
        this.telephone = telephone;
    }

    public static Contact ajouterContact(){
        char choixChar=0;
        Contact tempContact=new Contact();
        System.out.println("Veuillez entrer les informations suivantes :");
        //CONTACT
        System.out.print("Prénom : ");
        tempContact.prenom=Main.verifyFormatCreation();
        System.out.print("Nom : ");
        tempContact.nom=Main.verifyFormatCreation();
        //ADRESSE
        tempContact.getAdresse().ajouterAdresse();
        //OCCUPATION
        tempContact.getOccupation().ajouterOccupation();
        //TELEPHONE
        while (choixChar != 'n') {
            System.out.print("Entrer un numéro de téléphone (o/n) ? ");
            choixChar = toLowerCase(Main.sc.nextLine().trim().charAt(0));
            if(choixChar=='o') {
                Telephone tempTelephone=Telephone.creerTelephone();
                tempContact.telephone.add(tempTelephone);
                System.out.println();
            }
        }
        System.out.println("Votre contact a été entré avec succès !");
        return tempContact;

    }

    public void modifierContact(){
        char choixChar=0;
        String input;
        Main.sc.reset();
        System.out.println("Veuillez entrer les informations suivantes :");
        //CONTACT
        System.out.print("Prénom (" + prenom + ") : ");
        input = Main.sc.nextLine().trim();
        input = Main.sc.nextLine().trim();
        if (!input.equals("")) {
            prenom = Main.verifyFormatModification(input);
        }
        System.out.print("Nom (" + nom + ") : ");
        input = Main.sc.nextLine().trim();
        if (!input.equals("")) {
            nom = Main.verifyFormatModification(input);
        }
        //ADRESSE
        getAdresse().modifierAdresse();
        //OCCUPATION
        getOccupation().modifierOccupation();
        //TELEPHONE
        System.out.println("Téléphones : ");
        for (Telephone telephone:telephone) {
            telephone.modifierTelephone();
        }
        System.out.println();
        while (choixChar != 'n') {
            System.out.print("Entrer un numéro de téléphone (o/n) ? ");
            choixChar = toLowerCase(Main.sc.next().charAt(0));
            if(choixChar=='o') {
                Telephone tempTelephone=Telephone.creerTelephone();
                telephone.add(tempTelephone);
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("Votre contact a été modifié avec succès !");
    }

    public void afficherContact(){
        System.out.println("------------");
        System.out.println("Contact \"" + prenom+ "\" :");
        System.out.println("------------");
        //CONTACT
        System.out.println("Prénom : "+prenom);
        System.out.println("Nom : "+nom);
        //ADRESSE
        getAdresse().afficherAdresse();
        //OCCUPATION
        getOccupation().afficherOccupation();
        //TELEPHONE
        System.out.println("Téléphones : ");
        for(Telephone telephone:telephone){
            System.out.println("  "+telephone.getInfo()+" : "+telephone.getNum());
        }
        System.out.println();
    }
}