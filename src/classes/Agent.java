package classes;

import java.util.List;
import java.util.Set;

public class Agent {
private String nume;
private String prenume;
private Locuinta []locuinte;
private double total_vanzari;
private List<Client> clienti;

public Agent(){}

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Locuinta[] getLocuinte() {
        return locuinte;
    }

    public void setLocuinte(Locuinta[] locuinte) {
        this.locuinte = locuinte;
    }

    public double getTotal_vanzari() {
        return total_vanzari;
    }

    public void setTotal_vanzari(double total_vanzari) {
        this.total_vanzari = total_vanzari;
    }

}
