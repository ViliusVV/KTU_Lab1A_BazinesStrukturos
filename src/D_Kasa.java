/** @author Eimutis Karčiauskas, KTU IF Programų inžinerijos katedra, 2013 09 02
 *                                                        modifikuota 2014 09 03
 * Tai demonstracinė Kasos klasė, kurioje imituojamas prekybos centro darbas.
 * Ji turi sumavimo metodus vienai prekei ir kelioms prekėms.
   *  IŠBANDYKITE pilnai objektinę Java programą.
   *  PAKEISKITE ir PAPILDYKITE duomenis.
   *  IŠBANDYKITE veikimą su reset metodu.
   *  TEISINGAI SUFORMUOKITE laukus prekiųKiekis ir pirkimųKiekis.
   ****************************************************************************/

public class D_Kasa {
    static int bendrasKasųKiekis;
    int kasosNr;        // identifikacinis kasos nr.
    double kaupiamaSuma;
    int prekiųKiekis;   // tolimesniuose metoduose užtikrinkite jų skaičiavimus
    int pirkimųKiekis;  // tolimesniuose metoduose užtikrinkite jų skaičiavimus

    public D_Kasa() {
        kasosNr = bendrasKasųKiekis++;
    }
    void sumuoti(double kaina){  // perkama viena prekė
        kaupiamaSuma += kaina;
        pirkimųKiekis += 1;
        prekiųKiekis += 1;
        registruoti();
    }
    void sumuoti(double... kainos){ // metodas su kintamu argumentų skaičiumi
        pirkimųKiekis += 1;
        for(double kaina: kainos){
            kaupiamaSuma += kaina;
            prekiųKiekis += 1;
        }
        registruoti();
    }
    void sumuoti(int kiekis, double kaina){ // perkamas kiekis tos pačios prekės
        pirkimųKiekis += 1;
        kaupiamaSuma += kiekis * kaina;
        prekiųKiekis += kiekis;
        registruoti();
    }
    void reset() { 
        kaupiamaSuma = 0;
    }
    void registruoti(){
        System.out.println("Kasa nr." + kasosNr + ": " + kaupiamaSuma + ", Pirkimu kiekis: " + pirkimųKiekis +
                  ", Prekių kiekis: " + prekiųKiekis);
    }
    static void demo1(){
        D_Kasa s0 = new D_Kasa();
        D_Kasa s1 = new D_Kasa();
        D_Kasa s2 = new D_Kasa();
        s0.sumuoti(11.99);
        s0.sumuoti(1.00, 3.00, 4.00, 2.00);
        s1.sumuoti(2, 0.91);
        s2.sumuoti(35.68);
        
        s0.sumuoti(20.00);
        s2.sumuoti(40.00);
        s0.sumuoti(5, 40.0);
        s1.sumuoti(6, 50.0);
        // Simbolis _ naudojamas didelių skaičių aiškumui pagerinti
        s2.sumuoti(100_000_000, 0.03); 
        System.out.println("Iš viso sukaupta " + 
                (s0.kaupiamaSuma + s1.kaupiamaSuma + s2.kaupiamaSuma));
    }
    static void demoSuMasyvu(){
        D_Kasa[] norfa = {
            new D_Kasa(),new D_Kasa(),new D_Kasa()}; 
        System.out.println("Pradeda veikti NORFOS prekybos centras");
        norfa[0].sumuoti(11.99);
        norfa[0].sumuoti(1.00, 3.00, 4.00, 2.00);
        norfa[1].sumuoti(2, 0.91);
        norfa[2].sumuoti(35.68);
        norfa[0].sumuoti(20.00);
        norfa[2].sumuoti(40.00);
        norfa[0].sumuoti(5, 40.0);
        norfa[1].sumuoti(6, 50.0);
        norfa[2].sumuoti(100_000_000, 0.03);
        double išViso = 0.0;
        for(D_Kasa s: norfa)
            išViso += s.kaupiamaSuma;
        System.out.println("Norfoje sukaupta iš viso: " + išViso);
    }
    
        static void demoSuMasyvu2(){
        D_Kasa[] maxima = {
            new D_Kasa(),new D_Kasa(),new D_Kasa()}; 
        System.out.println("Pradeda veikti MAXIMA prekybos centras");
        maxima[0].sumuoti(55.99);
        maxima[0].sumuoti(1.5, 3.00, 4.55, 2.5);
        maxima[1].sumuoti(2, 0.91);
        maxima[2].sumuoti(35.55);
        maxima[0].sumuoti(205500);
        maxima[2].sumuoti(40.5);
        maxima[0].sumuoti(5, 40.0);
        maxima[1].sumuoti(6, 50.0);
        maxima[2].sumuoti(100_000_000, 0.03,15,1,515,1,15,5,15,1,51,5);
        double išViso = 0.0;
        for(D_Kasa s: maxima)
            išViso += s.kaupiamaSuma;
        System.out.printf("MAXIMA sukaupta iš viso: %d%n", (long)išViso);
    }
    
    public static void main(String[] args) {
        //demo1();
        //demoSuMasyvu();
        demoSuMasyvu2();
        
    }
}
