package classes;

import java.util.Scanner;

public class Apartament implements Locuinta {
    private int etaj;
    private int numar;
    private double pret;
    private double suprafata;
    private int nr_camere;
    private String adresa;

    public Apartament() {}



    public Apartament( String adresa, int etaj, int numar, double pret, double suprafata, int nr_camere) {
        this.adresa=adresa;
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



    @Override
    public void afisare() {
      System.out.print("Tip locuinta: Apartament");
      System.out.print(" Pret: "+this.pret);
      System.out.print(" Suprafata: "+this.suprafata);
      this.afisare_adresa();


    }

    @Override
    public void new_locuinta(){
        Scanner sc=new Scanner(System.in);
        double pret_l,suprafata_l;
        int et,nr,nrc;
        String adresa_l;
        System.out.print("Suprafata: ");
        suprafata_l=sc.nextDouble();
        System.out.print("Numar camere: ");
        nrc=sc.nextInt();
        System.out.print("Pret: ");
        pret_l=sc.nextDouble();
        System.out.print("Etaj: ");
        et=sc.nextInt();
        System.out.print("Numar: ");
        nr=sc.nextInt();
        System.out.print("Adresa: ");
        String sp=sc.next();
        adresa_l=sc.nextLine();
        this.setAdresa(adresa_l);
        this.setEtaj(et);
        this.setNr_camere(nrc);
        this.setNumar(nr);
        this.setPret(pret_l);
        this.setSuprafata(suprafata_l);}

    @Override
    public void afisare_adresa() {
        System.out.println(" Adresa: "+adresa+" Etaj: "+this.etaj+" Numar: "+this.numar);
    }

    @Override
    public void modificare_pret(double x){
        this.pret=x;
        System.out.println("Pretul a fost modificat.");

    }

    @Override
    public void afisare_tip_pret(){
        System.out.print("Tip: Casa Pret: "+pret);
    }


    public String get_Adresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String get_Type(){ return "Apartament";}
}
