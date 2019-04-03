package classes;

import java.util.Scanner;

public class Casa implements Locuinta {
    private int nr_etaje;
    private double pret;
    private double suprafata;
    private String adresa;

    public Casa(){}

    public Casa(double pret,int nr_etaje, double suprafata, String adresa) {
        this.adresa=adresa;
        this.nr_etaje = nr_etaje;
        this.suprafata = suprafata;
          this.pret=pret;
    }

    public int getNr_etaje() {
        return nr_etaje;
    }

    public void setNr_etaje(int nr_etaje) {
        this.nr_etaje = nr_etaje;
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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    @Override
    public void new_locuinta(){
        Scanner sc=new Scanner(System.in);
        double pret_l,suprafata_l;
        int nret_l;
        String adresa_l;
        System.out.print("Suprafata: ");
        suprafata_l=sc.nextDouble();
        System.out.print("Pret: ");
        pret_l=sc.nextDouble();
        System.out.print("Numar etaje: ");
        nret_l=sc.nextInt();
        System.out.print("Adresa: ");
        adresa_l=sc.next();
        this.setAdresa(adresa_l);
        this.setNr_etaje(nret_l);
        this.setPret(pret_l);
        this.setSuprafata(suprafata_l);

    }

    @Override
    public void afisare() {
        System.out.print("Tip locuinta: Casa");
        System.out.print(" Pret: "+this.pret);
        System.out.print(" Suprafata: "+this.suprafata);
        System.out.print(" Numar etaje: "+this.nr_etaje);
        this.afisare_adresa();
        System.out.println();

    }

    @Override
    public void afisare_adresa() {
        System.out.print(" Adresa: "+adresa);
    }

    @Override
    public void modificare_pret(double x) {
        this.pret=x;
        System.out.println("Pretul a fost modificat.");
    }

    @Override
    public void afisare_tip_pret(){
        System.out.print("Tip: Casa Pret: "+pret);
    }

}
