package classes;

public class Vanzare implements Achizitie{
    private double pret;

    public String get_type(){
        return "Vanzare";
    }



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

    public void afisare(){
        System.out.print(" Pret: "+pret);
    }
}
