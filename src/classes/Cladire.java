package classes;

public class Cladire extends Locuinta {

   private int nr_ap_disponibile;
   private int nr_etaje;

   public Cladire(){}

    public Cladire(int nr_ap_disponibile, int nr_etaje, String adresa) {
       super(adresa);
       this.nr_ap_disponibile = nr_ap_disponibile;
        this.nr_etaje = nr_etaje;
    }

    public int getNr_ap_disponibile() {
        return nr_ap_disponibile;
    }

    public void setNr_ap_disponibile(int nr_ap_disponibile) {
        this.nr_ap_disponibile = nr_ap_disponibile;
    }

    public int getNr_etaje() {
        return nr_etaje;
    }

    public void setNr_etaje(int nr_etaje) {
        this.nr_etaje = nr_etaje;
    }
}
