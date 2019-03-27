package classes;

public class Casa extends Locuinta {
    private int nr_etaje;
    private int pret;
    private double suprafata;

    public Casa(){}

    public Casa(int nr_etaje, double suprafata, String adresa) {
        super(adresa);
        this.nr_etaje = nr_etaje;
        this.suprafata = suprafata;

    }

    public int getNr_etaje() {
        return nr_etaje;
    }

    public void setNr_etaje(int nr_etaje) {
        this.nr_etaje = nr_etaje;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public double getSuprafata() {
        return suprafata;
    }

    public void setSuprafata(double suprafata) {
        this.suprafata = suprafata;
    }
}
