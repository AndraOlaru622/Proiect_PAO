package classes;

public class Client {
    private String nume;
    private String prenume;
    private Agent a1;
    private Achizitie ac1;
    private Locuinta loc;

    public Client() {}

    public Client(String nume, String prenume, Agent a1, Achizitie ac1, Locuinta loc) {
        this.nume = nume;
        this.prenume = prenume;
        this.a1 = a1;
        this.ac1 = ac1;
        this.loc = loc;
    }

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

    public Agent getA1() {
        return a1;
    }

    public void setA1(Agent a1) {
        this.a1 = a1;
    }

    public Achizitie getAc1() {
        return ac1;
    }

    public void setAc1(Achizitie ac1) {
        this.ac1 = ac1;
    }

    public Locuinta getLoc() {
        return loc;
    }

    public void setLoc(Locuinta loc) {
        this.loc = loc;
    }
}
