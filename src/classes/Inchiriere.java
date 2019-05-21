package classes;

public class Inchiriere implements Achizitie {
    private int nr_luni;
    private double rata;

    public String get_type(){
        return "Inchiriere";
    }



    public Inchiriere() {
    }

    public double getPret(){return nr_luni*rata;}

    public Inchiriere(int nr_luni, double rata) {
        this.nr_luni = nr_luni;
        this.rata = rata;
    }

    public int getNr_luni() {
        return nr_luni;
    }

    public void setNr_luni(int nr_luni) {
        this.nr_luni = nr_luni;
    }

    public double getRata() {
        return rata;
    }

    public void setRata(double rata) {
        this.rata = rata;
    }

    public void afisare(){
        System.out.print("Numar luni inchiriere: "+nr_luni+" Rata: "+rata);
    }
}
