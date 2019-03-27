package classes;

public class Vanzare implements Achizitie{
    private double pret;

    public Vanzare() {
    }

    public Vanzare(double pret) {
        this.pret = pret;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }
}
