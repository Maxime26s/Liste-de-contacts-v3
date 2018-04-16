import java.io.Serializable;

public class Telephone implements Serializable{
    private String info;
    private String num;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public static Telephone creerTelephone() {
        Telephone telephone = new Telephone();
        System.out.print("À quoi correspond ce numéro (cellulaire, maison, travail, …) ? ");
        telephone.info = Main.verifyFormatCreation();
        System.out.print("Quel est le numéro ? ");
        telephone.num = verifyNumberCreation();
        return telephone;
    }

    public void modifierTelephone() {
        String input;
        System.out.print("  " + info + " (" + num + ") : ");
        input = Main.sc.nextLine().trim();
        if (!input.equals("")) {
            num=verifyNumberModification(input);
        }
    }

    public static String verifyNumberCreation(){
        String numberTemp = "";
        boolean format=true;
        while(format==false||numberTemp.length()!=12) {
            numberTemp=Main.sc.nextLine().trim();
            format=numberVerification(numberTemp);
        }
        return numberTemp;
    }

    public static String verifyNumberModification(String numberTemp){
        boolean format=true;
        boolean firstTime=true;
        while(format==false||numberTemp.length()!=12) {
            if(firstTime==false) {
                numberTemp = Main.sc.nextLine().trim();
            }
            else{
                firstTime=false;
            }
            format=numberVerification(numberTemp);
        }
        return numberTemp;
    }

    public static boolean numberVerification(String numberTemp){
        boolean format=true;
        if(numberTemp.length()!=12){
            format=false;
        }
        for (int i = 0; i <numberTemp.length();i++){
            if (i>=0&&i<3||i>3&&i<7||i>7&&i<12){
                if((int)numberTemp.charAt(i)<47||numberTemp.charAt(i)>58){
                    format=false;
                }
            }
            else if(i==3||i==7){
                if(numberTemp.charAt(i)!='-'){
                    format=false;
                }
            }
        }
        if(format==false||numberTemp.length()!=12){
            System.out.println("Erreur dans le format du numéro. Veuillez le réécrire.");
        }
        return format;
    }
}