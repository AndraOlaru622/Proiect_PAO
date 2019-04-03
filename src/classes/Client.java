package classes;

public class Client extends Persoana {

    private Agent a1;
    private Achizitie ac1;
    private Locuinta loc;



    public Client(String nume, String prenume, Agent a1, Achizitie ac1, Locuinta loc) {
       super(nume, prenume);
        this.a1 = a1;
        this.ac1 = ac1;
        this.loc = loc;
    }


    public Client(){
        super();
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
