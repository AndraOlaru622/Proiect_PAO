package classes;

import sort.Sort_Agenti;

import java.util.*;

public class Service {
  private int nr_locuinte_vandute;
  private List<Client> clienti;
  private List<Agent> agenti;
  private List<Locuinta> locuinte_disponibile;

  private ArrayList<Agent> agenti_ranking;
  private HashMap<java.lang.Integer,Locuinta>locuinte_vandute;
  HashMap<java.lang.Integer,Achizitie>achizitii_realizate;

    public Service() {
        this.nr_locuinte_vandute = 0;
        clienti = new ArrayList<>();
        agenti=new ArrayList<>();
        locuinte_disponibile=new ArrayList<>();
        locuinte_vandute=new HashMap<>();
        achizitii_realizate=new HashMap<>();


        };




  public void show_clienti(){
      //Nume client+Tip achizitie
      for(int i=0;i<clienti.size();i++)
      {  int j=i+1;
      System.out.print(j+". Nume: "+clienti.get(i).getNume()+" Prenume: "+clienti.get(i).getPrenume());

  }}

  public void show_agenti(){
      //Nume agent
      for(int j=0;j<agenti.size();j++)
      {  int k=j+1;
          System.out.println(k+". Nume: "+agenti.get(j).getNume()+" Prenume: "+agenti.get(j).getPrenume());
      }
  }

  public void show_locuinte_disponibile(){
       // System.out.print("dfdsf");
      for(int i=0;i<locuinte_disponibile.size();i++){
          int indice=i+1;
          System.out.print(indice+". ");
          locuinte_disponibile.get(i).afisare();
      }
  }

  public void add_agent(Agent x){agenti.add(x);}

  public void add_locuinta(Locuinta x){locuinte_disponibile.add(x);}

  public void add_tranzactie(){
      //Client
      Client new_client=new Client();
      Scanner sc=new Scanner(System.in);
      System.out.print("Nume client: ");
      String nume=sc.nextLine();
      new_client.setNume(nume);
      System.out.print("Prenume client: ");
      String prenume=sc.nextLine();
      new_client.setPrenume(prenume);


      //Alegere agent
      System.out.println("Lista agenti:");
      this.show_agenti();
      System.out.println("Alegeti indice agent!" );
           System.out.println("Indice: ");
      int indice_agent=sc.nextInt();
      int ind_ag=indice_agent-1;
      new_client.setA1(agenti.get(ind_ag));

      //Alegere locuinta
      System.out.println("Locuinta disponibile: ");
      this.show_locuinte_disponibile();
      System.out.println("Alegeti indice locuinta!");

      System.out.println("Indice: ");
      int indice_locuinta=sc.nextInt();

      int i1=indice_locuinta-1;
      System.out.println(i1);
      locuinte_disponibile.get(i1).afisare();
      //new_client.setLoc(locuinte_disponibile.get(i1));

      //Alegere tip tranzactie
      System.out.println("Tip achizitie:");
      System.out.println("1.Vanzare");
      System.out.println("2.Inchiriere");
      System.out.println("Indice:");
      int indice_tip_tranzactie=sc.nextInt();
      int ok=0;
      while(ok==0){
          if(indice_tip_tranzactie==1){
              Vanzare v=new Vanzare();
              v.setPret(locuinte_disponibile.get(i1).getPret());
              nr_locuinte_vandute++;
              //Adaugare achizitie
              achizitii_realizate.put(nr_locuinte_vandute,v);
              //Adaugare locuinta vanduta
              locuinte_vandute.put(nr_locuinte_vandute,locuinte_disponibile.get(i1));

              //System.out.print(nr_locuinte_vandute);
              //Adaugare la profit agent
              agenti.get(ind_ag).setSuma_totala_vanzari(agenti.get(ind_ag).getSuma_totala_vanzari()+locuinte_disponibile.get(i1).getPret());
              //Stergere din locuinta disponibile
              locuinte_disponibile.remove(locuinte_disponibile.get(i1));


          ok=1;    }
          else
          if(indice_tip_tranzactie==2){
              Inchiriere i=new Inchiriere();
              System.out.print("Numar luni inchiriere: ");
              int nr_Luni=sc.nextInt();
              nr_locuinte_vandute++;
              i.setRata(locuinte_disponibile.get(i1).getPret()/nr_Luni);
              i.setNr_luni(nr_Luni);
              achizitii_realizate.put(nr_locuinte_vandute,i);
              locuinte_vandute.put(nr_locuinte_vandute,locuinte_disponibile.get(i1));
              agenti.get(ind_ag).setSuma_totala_vanzari(agenti.get(ind_ag).getSuma_totala_vanzari()+locuinte_disponibile.get(i1).getPret());
              locuinte_disponibile.remove(locuinte_disponibile.get(i1));
          ok=1;}
          else {
              System.out.println("Introduceti indice valid.");
              System.out.println("Indice:");
              indice_tip_tranzactie=sc.nextInt();
          }

          }
      clienti.add(new_client);
      }

  public void show_ranking_agenti(){
      agenti_ranking = new ArrayList<Agent>();
      for(int i=0;i<agenti.size();i++)
          agenti_ranking.add(agenti.get(i));


      Collections.sort(agenti_ranking,new Sort_Agenti());

      for (int i=0;i<agenti_ranking.size();i++) {

          System.out.println("Nume agent: "+agenti_ranking.get(i).getNume()+" "+agenti_ranking.get(i).getPrenume()+" Suma vanzari totale: "+agenti_ranking.get(i).getSuma_totala_vanzari());
      }

  }

  public void show_tranzactii(){

      for(int i=0;i<locuinte_vandute.size();i++)
      {
          System.out.print(i+1);
          System.out.print(" ");
          locuinte_vandute.get(i+1).afisare();
          System.out.print(" ");
          achizitii_realizate.get(i+1).afisare();
          System.out.println();
      }
      };

  public void show_locuinte_interval(double i1,double i2){
      int nr_locuinte=0;
      for(int i=0;i<locuinte_disponibile.size();i++){
          if(locuinte_disponibile.get(i).getPret()>=i1&&locuinte_disponibile.get(i).getPret()<=i2){
              nr_locuinte++;
              System.out.print(i+1);
              System.out.print(" ");
              locuinte_disponibile.get(i).afisare();
          }
      }
      if(nr_locuinte==0)
          System.out.print("Nu exista locuinte disponibile!");

  }

  public void show_meniu(){
      System.out.println("Meniu:");
      System.out.println("1.  Afisare locuinte disponibile");
      System.out.println("2.  Afisare clienti");
      System.out.println("3.  Afisare agenti imobiliari");
      System.out.println("4.  Realizare tranzactie");
      System.out.println("5.  Afisare locuinte vandute");
      System.out.println("6.  Afisare locuinte cu pret in interval dat");
      System.out.println("7.  Afisare agenti ordonati dupa vanzarile totale");
      System.out.println("8.  Modificare pret locuinta");
      System.out.println("9.  Adaugare locuinta");
      System.out.println("10. Adaugare agent");
      System.out.println("0.  Iesire");
      System.out.println("Indice actiune:");

  }



    public void modificare_pret_locuinta()
    {  Scanner sc=new Scanner(System.in);
        this.show_locuinte_disponibile();
        int indice;
        System.out.println("Indice locuinta: ");
        indice=sc.nextInt();
        System.out.println("Pret nou: ");
        double pret_nou;
        pret_nou=sc.nextDouble();
        this.locuinte_disponibile.get(indice-1).modificare_pret(pret_nou);

    }


    public int getNr_locuinte_vandute() {
        return nr_locuinte_vandute;
    }

    public void setNr_locuinte_vandute(int nr_locuinte_vandute) {
        this.nr_locuinte_vandute = nr_locuinte_vandute;
    }

    public List<Client> getClienti() {
        return clienti;
    }

    public void setClienti(List<Client> clienti) {
        this.clienti = clienti;
    }

    public List<Agent> getAgenti() {
        return agenti;
    }

    public void setAgenti(List<Agent> agenti) {
        this.agenti = agenti;
    }

    public List<Locuinta> getLocuinte_disponibile() {
        return locuinte_disponibile;
    }

    public void setLocuinte_disponibile(List<Locuinta> locuinte_disponibile) {
        this.locuinte_disponibile = locuinte_disponibile;
    }


    public HashMap<Integer, Locuinta> getLocuinte_vandute() {
        return locuinte_vandute;
    }

    public void setLocuinte_vandute(HashMap<Integer, Locuinta> locuinte_vandute) {
        this.locuinte_vandute = locuinte_vandute;
    }

    public HashMap<Integer, Achizitie> getAchizitii_realizate() {
        return achizitii_realizate;
    }

    public void setAchizitii_realizate(HashMap<Integer, Achizitie> achizitii_realizate) {
        this.achizitii_realizate = achizitii_realizate;
    }
}