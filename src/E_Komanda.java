/** @author Eimutis Karčiauskas, KTU IF Programų inžinerijos katedra, 2014 09 02
   *
   *  Tai yra demonstracinė krepšinio komandos taškų skaičiavimo klasė, 
   *    kurioje demonstruojami įvairūs masyvų apdorojimo metodai.
   *  Atkreipkite dėmesį į ciklo for-each panaudojimą.
   *  Panaudodami Refactor pakeiskite klasės vardą į E_Komanda !!!
   *  IŠBANDYKITE įvairius charakteristikų skaičiavimo metodus.
   *  SURAŠYKITE reikiamus veiksmus, neužbaigtiems metodams.
   *  PAPILDYKITE programą dar kitų komandų duomenimis.
   ****************************************************************************/

import java.util.Arrays;
public class E_Komanda { 
    String pavadinimas;
    int[] taškai;  // komandos žaidėjų pelnyti taškai

    public E_Komanda(String pavadinimas, int[] taškai) {
        this.pavadinimas = pavadinimas;
        this.taškai = taškai;
    }
    int sumaSenuStiliumi(){
        int n = taškai.length;
        int suma = 0;
        for (int i = 0; i < n; i++) {
            suma += taškai[i];
        }
        return suma;
    }
    int sumaForEachStiliumi(){
        int suma = 0;
        for (int a1: taškai) {
            suma += a1;
        }
        return suma;
    }
    int maxSenuStiliumi(){
        int n = taškai.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) 
            if(taškai[i] > max)
                max = taškai[i];
        return max;
    }
    int maxForEachStiliumi(){
        int max = Integer.MIN_VALUE;
        for (int a1: taškai)
            if(a1 > max)
                max = a1;
        return max;
    }    
    int kiekŽaidėjųPelnėTaškus(){
        int kiek = 0;
        for (int a1: taškai){
            if(a1 > 0)
                kiek += a1;
         }
        return 0;
    }
    double koksVidurkis(){
        int sum = 0;
        for (int a1: taškai){
             sum+= a1;
         }
        return sum/ taškai.length;
    }
    
     // Grazina laimejusia komnada/as
     public static String kasLaimėjo(E_Komanda... kiti){
        int maxTask = 0;
        String laimejo = "";
        for(E_Komanda kom: kiti){
            int task = kom.sumaForEachStiliumi();
            if (task > maxTask){
                maxTask = task;
            }
        }
        
        for(E_Komanda kom: kiti){
            int task = kom.sumaForEachStiliumi();
            if (task == maxTask){
                laimejo = laimejo + kom.pavadinimas + " ";
            }
        }
        
        return laimejo;
    }
    
     // Grazina laimejusia komanda
    String kasLaimėjo(E_Komanda kita){
        int task1 = this.sumaForEachStiliumi();
        int task2 = kita.sumaForEachStiliumi();
        if(task1 > task2){
            return this.pavadinimas;
        }
        else if(task2 > task1){
            return kita.pavadinimas;
        }
        else{
            return "Lygiosios";
        }
    }

    void ataskaita(){
        int žaidėjųSkaičius = taškai.length;
        int visoTaškų1 = sumaSenuStiliumi();
        int visoTaškų2 = sumaForEachStiliumi();
        int maxTaškai1 = maxSenuStiliumi();
        int maxTaškai2 = maxForEachStiliumi();
        System.out.println("****** Komandos " + pavadinimas + " ataskaita");
        System.out.println("Komandos žaidėjų skaičius " + žaidėjųSkaičius);
        System.out.println("Surinkti taškai " + Arrays.toString(taškai));
        System.out.println("Taškų suma Senu Stiliumi    " + visoTaškų1);
        System.out.println("Taškų suma ForEach Stiliumi " + visoTaškų2);
        System.out.println("Max taškų Senu Stiliumi    " + maxTaškai1);
        System.out.println("Max taškų ForEach Stiliumi " + maxTaškai2);
        System.out.println("Zaidejai kurie pelne tasku " + kiekŽaidėjųPelnėTaškus());
        System.out.println("Komandos vidurkis " + koksVidurkis() + "\n");
        // papildykite naujai paskaičiuotomis charakteristikomis
    }
    public static void main(String[] args) {
        // suformuojame komandų žaidėjų surinktų taškų masyvus
        int[] mas1 = {5, 2, 12, 21, 26, 0, 0, 7, 2, 11, 17, 0};
        int[] mas2 = {44, 8, 0, 21, 26, 0, 0, 7}; 
        int[] ltuTšk = {44, 8, 0, 21, 26, 0, 0, 7,0,0,5,8,9,7,1};
        int[] usaTšk = {44, 8, 0, 21, 26, 0, 0, 7,0,0,5,8,9,7,1,10,15,88,999};
        int[] usaTšk1 = {44, 8, 0, 21, 26, 0, 0, 7,0,0,5,8,9,7,1,10,15,88,999};
        int[] usaTšk2= {44, 8, 0, 21, 26, 0, 0, 7,0,0,5,8,9,7,1,10,15,88,999};
        E_Komanda kom1 = new E_Komanda("Sakalai", mas1);
        E_Komanda kom2 = new E_Komanda("Ereliai", mas2);
        E_Komanda kom3 = new E_Komanda("LTU", ltuTšk);
        E_Komanda kom4 = new E_Komanda("USA", usaTšk);
        E_Komanda kom5 = new E_Komanda("USA1", usaTšk1);
        E_Komanda kom6 = new E_Komanda("US2", usaTšk2);
        kom1.ataskaita();
        kom2.ataskaita();
        kom3.ataskaita();
        kom4.ataskaita();
        System.out.println("Rungtynes laimėjo " +kom1.kasLaimėjo(kom2));
        System.out.println("Rungtynes laimėjo " +E_Komanda.kasLaimėjo(
                                            kom1, kom2, kom3, kom4));
        System.out.println("Rungtynes laimėjo " +E_Komanda.kasLaimėjo(
                                            kom1, kom2, kom3, kom4,kom5,kom6));
    }    
}
