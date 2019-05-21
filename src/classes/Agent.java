package classes;

import java.util.HashMap;


public class Agent extends Persoana{


    private HashMap<java.lang.Integer,Client> clienti;
    private HashMap<java.lang.Integer,Achizitie> vanzari;
    private double suma_totala_vanzari;
    private int indagent;

    public int getIndagent() {
        return indagent;
    }

    public void setIndagent(int indagent) {
        this.indagent = indagent;
    }

    public void addClient(Client cl){
        this.clienti.put(clienti.size()+1,cl);
    }

    public void addVanzare(Vanzare v){
        this.vanzari.put(vanzari.size()+1,v);
    }

    public Agent(){
        super();
        this.suma_totala_vanzari=0;
        clienti=new HashMap<>();
        vanzari=new HashMap<>();
    }


    public Agent(String nume, String prenume, HashMap<java.lang.Integer, Client> clienti, HashMap<java.lang.Integer, Achizitie> vanzari, double suma_totala_vanzari) {
        super(nume, prenume);
        this.clienti = clienti;
        this.vanzari = vanzari;
        this.suma_totala_vanzari = suma_totala_vanzari;
    }
    public Agent(String nume, String prenume){
        super(nume, prenume);
        this.suma_totala_vanzari=0;
        clienti=new HashMap<>();
        vanzari=new HashMap<>();
    }

    public Agent(String nume, String prenume, Double suma){
        super(nume, prenume);
        this.suma_totala_vanzari=suma;
        clienti=new HashMap<>();
        vanzari=new HashMap<>();
    }

    /*public void afisare(){
        System.out.print("Nume agent: ");
        System.out.print(getNume());
        System.out.print(" Prenume agent: ");
        System.out.print(getPrenume());
        System.out.println();
    }*/


  /*  public HashMap<Integer, Client> getClienti() {
        return clienti;
    }*/

   /* public void setClienti(HashMap<Integer, Client> clienti) {
        this.clienti = clienti;
    }*/

  /*  public HashMap<Integer, Achizitie> getVanzari() {
        return vanzari;
    }*/

  /*  public void setVanzari(HashMap<Integer, Achizitie> vanzari) {
        this.vanzari = vanzari;
    }*/

    public double getSuma_totala_vanzari() {
        return suma_totala_vanzari;
    }

    public void setSuma_totala_vanzari(double suma_totala_vanzari) {
        this.suma_totala_vanzari = suma_totala_vanzari;
    }
}
