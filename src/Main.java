import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by simma1733207 on 2018-04-09.
 */
public class Main {
    public static final Scanner sc = new Scanner(System.in);
    public static HashMap<String, Contact> map=new HashMap<>();
    public static Queue<Contact> queue=new LinkedList<>();
    public static String[] listePays={"Canada","États-Unis","Mexique","France","Japon"};
    public static String[] listeProvince={"Quebec","Ontario","Manitoba","Alberta"};
    public static char[] listeCharacter={'%','*','¯','\\'};
    public static void main(String[] args) {
        int choixInt;
        System.out.println("Bienvenue!");
        while (true) {
            choixInt=listeChoix();
            choixSwitch(choixInt);
        }
    }
    public static int listeChoix(){
        System.out.println();
        System.out.println(" 1- Ajouter un contact");
        System.out.println(" 2- Modifier un contact");
        System.out.println(" 3- Afficher les contacts");
        System.out.println(" 4- Supprimer un contact");
        System.out.println(" 5- Ajouter un contact à la liste de rappels");
        System.out.println(" 6- Voir la liste de rappels");
        System.out.println(" 7- Charger la liste");
        System.out.println(" 8- Quitter");
        System.out.print("Que souhaitez-vous faire ? ");
        System.out.println();
        try{
            String stringTemp=sc.nextLine();
            int intTemp=Integer.parseInt(stringTemp);
            return intTemp;
        } catch(Exception e){
            return 0;
        }
    }
    public static void choixSwitch(int choixInt){
        String choixString;
        switch (choixInt) {
            case 1:
                Contact tempContact=Contact.ajouterContact();
                map.put(tempContact.getPrenom(),tempContact);
                break;
            case 2:
                System.out.println("Quel est le prenom du contact ?");
                choixString=sc.next();
                if(map.get(choixString)!=null) {
                    map.get(choixString).modifierContact();
                    if(!choixString.equals(map.get(choixString).getPrenom())){
                        map.put(map.get(choixString).getPrenom(),map.get(choixString));
                        map.remove(choixString);
                    }
                }
                else{
                    System.out.println("ERREUR: Le contact n'existe pas");
                }
                break;
            case 3:
                map.forEach((k,contact)-> {
                    //CONTACT
                    contact.afficherContact();
                });
                System.out.print("------------");
                break;
            case 4:
                System.out.println("Quel est le prenom du contact ?");
                choixString=sc.next();
                if(map.get(choixString)!=null) {
                    map.remove(choixString);
                }
                else{
                    System.out.println("ERREUR: Le contact n'existe pas");
                }
                break;
            case 5:
                System.out.println("Quel est le prenom du contact ?");
                choixString=sc.next();
                if(map.get(choixString)!=null) {
                    queue.add(map.get(choixString));
                }
                else{
                    System.out.println("ERREUR: Le contact n'existe pas");
                }
                break;
            case 6:
                if(queue.peek()!=null){
                    System.out.println("Le contact a rappelé au plus tôt est "+queue.peek().getPrenom()+" "+queue.poll().getNom());
                }
                else{
                    System.out.println("Il n'y a aucun contact à rappeler");
                }
                break;
            case 7:
                load();
                System.out.println("La liste a été chargé.");
                break;
            case 8:
                save();
                System.out.println("Au revoir !");
                System.exit(0);
                break;
            default:
                System.out.println("ERREUR: Entrez un choix valide (entre 1 et 7)");
                break;
        }
    }
    static void save(){
        try {
            ObjectOutputStream sortie = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("saveList.dat")));
            sortie.writeObject(map);
            sortie.writeObject(queue);
            sortie.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void load(){
        try {
            ObjectInputStream entree = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream("saveList.dat")));
            try {
                map = (HashMap<String, Contact>) entree.readObject();
                queue = (Queue<Contact>) entree.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static String verifyFormatCreation(){
        String entree="";
        boolean format=false;
        while(format==false){
            while(entree.equals("")) {
                entree = Main.sc.nextLine().trim();
            }
            format=formatVerification(entree);
        }
        return entree;
    }
    static String verifyFormatModification(String entree){
        boolean firstTime=true;
        boolean format=false;
        while(format==false){
            if (firstTime==false) {
                entree = Main.sc.nextLine().trim();
            }
            else{
                firstTime=false;
            }
            format=formatVerification(entree);
        }
        return entree;
    }
    static boolean formatVerification(String entree){
        boolean format=true;
        for(int i=0;i<entree.length();i++) {
            for (int j = 0; j < listeCharacter.length; j++){
                if (entree.charAt(i) == listeCharacter[j]) {
                    format = false;
                }
            }
        }
        if (format==false){
            System.out.println("Erreur dans l'entrée. Veuillez la réécrire.");
        }
        return format;
    }
}
