package classes;

public class Apartament extends Cladire {
    private int etaj;
    private int numar;
    private double pret;
    private double suprafata;
    private int nr_camere;

    public Apartament() {}

    public Apartament(int nr_ap_disponibile, int nr_etaje, String adresa, int etaj, int numar, double pret, double suprafata, int nr_camere) {
        super(nr_ap_disponibile, nr_etaje, adresa);
        this.etaj = etaj;
        this.numar = numar;
        this.pret = pret;
        this.suprafata = suprafata;
        this.nr_camere = nr_camere;
    }

    public int getEtaj() {
        return etaj;
    }

    public void setEtaj(int etaj) {
        this.etaj = etaj;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public double getSuprafata() {
        return suprafata;
    }

    public void setSuprafata(double suprafata) {
        this.suprafata = suprafata;
    }

    public int getNr_camere() {
        return nr_camere;
    }

    public void setNr_camere(int nr_camere) {
        this.nr_camere = nr_camere;
    }
}
