import java.io.Serializable;

public class Adresse implements Serializable{
    private String numP;
    private String rue;
    private String app;
    private String ville;
    private String province;
    private String pays;

    public String getNumP() {
        return numP;
    }

    public void setNumP(String numP) {
        this.numP = numP;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void ajouterAdresse(){
        String input;
        System.out.println("Adresse :");
        System.out.print("  Numéro de porte : ");
        numP=Main.verifyFormatCreation();
        System.out.print("  Rue : ");
        rue=Main.verifyFormatCreation();
        System.out.print("  Appartement : ");
        input=Main.sc.nextLine().trim();
        if(!input.equals("")) {
            app=Main.verifyFormatModification(input);
        }
        System.out.print("  Ville : ");
        ville=Main.verifyFormatCreation();
        System.out.print("  Pays :");
        pays=verifyCountryCreation();
        if(pays.equals("Canada")) {
            System.out.print("  Province : ");
            province = verifyProvinceCreation();
        }
    }

    public void modifierAdresse(){
        String input;
        System.out.println("Adresse : ");
        System.out.print("  Numéro de porte (" + numP + ") : ");
        input=Main.sc.nextLine().trim();
        if(!input.equals("")) {
            numP=Main.verifyFormatModification(input);
        }
        System.out.print("  Rue (" + rue + ") : ");
        input=Main.sc.nextLine().trim();
        if(!input.equals("")) {
            rue=Main.verifyFormatModification(input);
        }
        System.out.print("  Appartement (" + app + ") : ");
        input=Main.sc.nextLine().trim();
        if(!input.equals("")) {
            app=Main.verifyFormatModification(input);
        }
        System.out.print("  Ville (" + ville + ") : ");
        input=Main.sc.nextLine().trim();
        if(!input.equals("")) {
            ville=Main.verifyFormatModification(input);
        }
        System.out.print("  Pays (" + pays + ") : ");
        input=Main.sc.nextLine().trim();
        if(!input.equals("")) {
            pays=verifyCountryModification(input);
        }
        if(pays.equals("Canada")) {
            System.out.print("  Province (" + province + ") : ");
            input = Main.sc.nextLine().trim();
            if (!input.equals("")) {
                province = verifyProvinceModification(input);
            }
        }
    }

    public void afficherAdresse(){
        System.out.println("Adresse : ");
        System.out.println("  Numéro de porte : "+numP);
        System.out.println("  Rue : "+rue);
        System.out.println("  Appartement : "+app);
        System.out.println("  Ville : "+ville);
        System.out.println("  Pays : "+pays);
        if(pays.equals("Canada")) {
            System.out.println("  Province : " + province);
        }
    }

    public static String verifyCountryCreation(){
        String pays="";
        boolean vraiPays=false;
        while(vraiPays==false){
            pays=Main.sc.nextLine().trim();
            vraiPays=countryVerification(pays);
        }
        return pays;
    }

    public static String verifyCountryModification(String pays){
        boolean firstTime=true;
        boolean vraiPays=false;
        while(vraiPays==false){
            if(firstTime==false) {
                pays = Main.sc.nextLine().trim();
            }
            else{
                firstTime=false;
            }
            vraiPays=countryVerification(pays);
        }
        return pays;
    }

    public static boolean countryVerification(String pays){
        boolean vraiPays=false;
        for(int i=0;i<Main.listePays.length;i++){
            if(pays.equals(Main.listePays[i])){
                vraiPays=true;
            }
        }
        if(vraiPays==false){
            System.out.println("Erreur dans le pays. Veuillez le réécrire.");
        }
        return vraiPays;
    }

    public static String verifyProvinceCreation(){
        String province="";
        boolean vraiProvince=false;
        while(vraiProvince==false){
            province=Main.sc.nextLine().trim();
            vraiProvince=provinceVerification(province);
        }
        return province;
    }

    public static String verifyProvinceModification(String province){
        boolean firstTime=true;
        boolean vraiProvince=false;
        while(vraiProvince==false){
            if(firstTime==false) {
                province = Main.sc.nextLine().trim();
            }
            else{
                firstTime=false;
            }
            vraiProvince=provinceVerification(province);
        }
        return province;
    }

    public static boolean provinceVerification(String province){
        boolean vraiProvince=false;
        for(int i=0;i<Main.listeProvince.length;i++){
            if(province.equals(Main.listeProvince[i])){
                vraiProvince=true;
            }
        }
        if(vraiProvince==false){
            System.out.println("Erreur dans la province. Veuillez la réécrire.");
        }
        return vraiProvince;
    }
}