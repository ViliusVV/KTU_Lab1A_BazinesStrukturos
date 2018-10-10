/** @author Eimutis Karčiauskas, KTU IF Programų inžinerijos katedra, 2013 09 02
 *
 * Tai yra demonstracinės pasisveikinimo klasės sekantis etapas.
 * Atsisakoma static metodų, todėl reikia sukurti vieną klasės objektą,
 * kas yra atliekama privalomame statiniame metode main.
 * Į tokio stiliaus programas galima tiesiog perkelti C programų tekstus.
   *  IŠBANDYKITE Java programą, kai sukuriamas naujas demonstracinis objektas.
   *  SURAŠYKITE reikiamus veiksmus neužbaigtame metode ir išbandykite.
   *  PAPILDYKITE naujais skaičiavimo metodais, 
   *              tiesiog perkeldami tekstą iš C kalbos pavyzdžių.
   ****************************************************************************/

public class B_Labas {
    void sveikintis(){
        System.out.println("LABAS pasauli ");
    }
    void sveikintis(String kalba){
        String atsakymas;
        switch(kalba){
            case "LTU": atsakymas = "Labas pasauli"; break;
            case "ENG": atsakymas = "Hello WORLD";   break;
            case "SWE": atsakymas = "Hallå världen"; break;
            case "GRE": atsakymas = "Γεια κόσμος";   break;
            case "FRA": atsakymas = "Bonjour tout le monde"; break;   
            case "RUS": atsakymas = "привет мир";    break;
            default:    atsakymas = "Atsiprašau - nesupratau";
        }   
        System.out.println("Kalba " + kalba + ": " + atsakymas);
    }
    double skaičiuotiKambarioTūrį(double ilgis, double plotis, double aukštis){
        // surašykite reikiamus veiksmus ir išbandykite
        double volume = ilgis * plotis * aukštis;
        return volume;
    }
    double atstumasTarpTaškų(int x1, int y1, int x2, int y2){
        // surašykite reikiamus veiksmus ir išbandykite
        return Math.sqrt(Math.pow((x2-x1), 2.0) + Math.pow((y2-y1), 2.0));
    }
    void demo(){
        sveikintis();
        sveikintis("SWE");
        sveikintis("GRE");
        sveikintis("LAT");
        sveikintis("FRA");   // kodėl ne taip, kur klaida? Trūko break  
    }
    public static void main(String[] args) {
        //new B_Labas().demo();
        // galimas alternatyvinis varijantas dviejose eilutėse, išbandykite
        B_Labas o = new B_Labas();
        o.demo();
        System.out.printf("Turis: %s%n",o.skaičiuotiKambarioTūrį(5, 5, 5));
        System.out.printf("Atstumas: %s%n ",o.atstumasTarpTaškų(0, 0, 5, 5));
    }    
}
