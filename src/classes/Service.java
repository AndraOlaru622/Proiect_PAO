package classes;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Service {
    private List<Client> clienti_total;
    private List<Agent> agenti_total;
    private List<Locuinta> locuinte_total;
    private List<Achizitie> achizitii_total;

    public Service() {
    }



    public void show_clienti(){
        for(int i=0; i<clienti_total.size();i++){
            System.out.println("Client "+i+": "+"Nume: "+clienti_total.get(i).getNume()+" "+clienti_total.get(i).getNume());

        }}

    public void show_agenti(){
        for(int i=0; i<agenti_total.size();i++){
            System.out.println("Agent "+i+": "+"Nume: "+agenti_total.get(i).getNume()+" "+agenti_total.get(i).getPrenume());

        }
    }

    public void show_locuinte(){
        for(int i=0; i<locuinte_total.size();i++){
            {
                if(locuinte_total.get(i).getClass()==Casa.class)
                {System.out.println("Locuinta "+i+" Tip: Casa "+"Suprafata: "+ ((Casa)locuinte_total.get(i)).getSuprafata()+" Numar Etaje: "+((Casa)locuinte_total.get(i)).getNr_etaje()+
                        " Pret: "+((Casa)locuinte_total.get(i)).getPret()+" Adresa: "+locuinte_total.get(i).getAdresa());

                }
                else{System.out.println("Locuinta "+i+
                        " Tip: Apartament "+
                        "Suprafata: "+ ((Apartament)locuinte_total.get(i)).getSuprafata()+
                        " Numar Camera: "+((Apartament)locuinte_total.get(i)).getNr_camere()+
                        " Pret: "+((Apartament)locuinte_total.get(i)).getPret()+
                        " Adresa: "+(locuinte_total.get(i)).getAdresa()+
                        " Etaje: "+((Apartament)locuinte_total.get(i)).getEtaj()+
                        " Numar: "+((Apartament)locuinte_total.get(i)).getNumar());

                }

            }
        }

    }

    public void add_client(Client x){
        clienti_total.add(x); }


        public void add_tranzactie(){
        Scanner sc=new Scanner(System.in);
        Client x=new Client();
        System.out.print("Nume: ");
        String nume=sc.nextLine();
        x.setNume(nume);
        System.out.print("Prenume: ");
        String prenume=sc.nextLine();
        x.setNume(prenume);

        System.out.println("Alegeti agent (indice)");
        this.show_agenti();
        System.out.println("Indice agent: ");
        int ind;
        ind=sc.nextInt();
        x.setA1(this.agenti_total.get(ind));

        System.out.println("Alegeti o locuinta (indice):");
        this.show_locuinte();
            System.out.println("Indice locuinta: ");
        int ind_loc;
        ind_loc=sc.nextInt();
        x.setLoc(this.locuinte_total.get(ind_loc));

        if(this.locuinte_total.get(ind_loc).getClass()==Casa.class)
        agenti_total.get(ind).setTotal_vanzari(agenti_total.get(ind).getTotal_vanzari()+((Casa)locuinte_total.get(ind_loc)).getPret());
        else
            agenti_total.get(ind).setTotal_vanzari(agenti_total.get(ind).getTotal_vanzari()+((Apartament)locuinte_total.get(ind_loc)).getPret());
            locuinte_total.remove(ind_loc);
        System.out.println("Tip tranzactie");
        System.out.println("1.Vanzare");
        System.out.println("2.Inchiriere");
        int ind_tranz=sc.nextInt();
        if(ind_tranz==1){
            Vanzare v=new Vanzare();
            if(this.locuinte_total.get(ind_loc).getClass()==Casa.class)
            v.setPret(((Casa)x.getLoc()).getPret());
            else
                v.setPret(((Apartament)x.getLoc()).getPret());
                x.setAc1(v);
        }
        else if(ind_tranz==2){
            Inchiriere inc=new Inchiriere();
            double pret_total;
            if(this.locuinte_total.get(ind_loc).getClass()==Casa.class)
                pret_total=((Casa)x.getLoc()).getPret();
            else
                pret_total=((Apartament)x.getLoc()).getPret();

            System.out.print("Numar luni inchiriere: ");
            int nr_luni;
            nr_luni=sc.nextInt();
            inc.setNr_luni(nr_luni);
            inc.setRata(pret_total/(double)nr_luni);



        }
        else
            System.out.println("Introduceti indice valid");

    }
}
