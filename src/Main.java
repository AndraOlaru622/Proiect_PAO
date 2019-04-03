import classes.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


    Service s=new Service();
    int numar_agenti;
        File file =
                new File("src/Agenti.txt");
        Scanner sc = new Scanner(file);

        int nr_agenti;
            nr_agenti=sc.nextInt();
            sc.nextLine();

            for(int i=0;i<nr_agenti;i++){
                String nume,prenume;
                nume=sc.nextLine();
                prenume=sc.nextLine();
                Agent ag=new Agent(nume,prenume);
                s.add_agent(ag);
            }
            sc.close();
            s.show_agenti();

        File file1 =
                new File("src/Locuinte.txt");
        Scanner sc1 = new Scanner(file1);
        int nr_locuinte;
        nr_locuinte=parseInt(sc1.nextLine());

        String tip_locuinta;
        for(int i=0;i<nr_locuinte;i++){

            tip_locuinta=sc1.nextLine();

            if(tip_locuinta.equals("Casa")){
                String adresa=sc1.nextLine();
                int nr_etaje=parseInt(sc1.nextLine());
                double pret=Double.parseDouble(sc1.nextLine());
                double suprafata=Double.parseDouble(sc1.nextLine());

                Casa new_casa=new Casa(pret,nr_etaje,suprafata,adresa);
                s.add_locuinta(new_casa);
            }
            else
                if(tip_locuinta.equals("Apartament"))
                {
                    String adresa=sc1.nextLine();
                    double pret=Double.parseDouble(sc1.nextLine());
                    double suprafata=Double.parseDouble(sc1.nextLine());
                    int nr_camere=parseInt(sc1.nextLine());

                    int etaj=parseInt(sc1.nextLine());
                    int numar=parseInt(sc1.nextLine());
                    Apartament new_apartament=new Apartament(adresa,etaj,numar,pret,suprafata,nr_camere);
                    s.add_locuinta(new_apartament);
                }
        }
        sc1.close();

        Scanner sc_actiune=new Scanner(System.in);
        int indice=-1;
        while(indice!=0){
         s.show_meniu();
         indice=sc_actiune.nextInt();
         if(indice==1)
             s.show_locuinte_disponibile();
         else
             if(indice==2)
                 s.show_clienti();
             else
                 if(indice==3)
                     s.show_agenti();
                 else
                     if(indice==4)
                         s.add_tranzactie();
                     else
                         if (indice==5)
                             s.show_tranzactii();
                         else
                             if(indice==6)
                             {
                                 double i1,i2;
                                 Scanner sc2=new Scanner(System.in);
                                 System.out.println("Interval:");
                                 System.out.println("I1: ");
                                 i1=sc2.nextDouble();
                                 System.out.println("I2: ");
                                 i2=sc2.nextDouble();
                                 s.show_locuinte_interval(i1,i2);

                             }
                             else
                                 if(indice==7)
                                     s.show_ranking_agenti();
                                 else
                                     if(indice==8)
                                         s.modificare_pret_locuinta();
                                     else
                                         if(indice==9){
                                             Scanner ssc=new Scanner(System.in);
                                             System.out.println("Tipuri locuinte:");
                                             System.out.println("1.Casa");
                                             System.out.println("2.Apartament");
                                             System.out.print("Indice tip: ");
                                             int ind_tip;
                                             ind_tip=ssc.nextInt();
                                             if(ind_tip==1)
                                             {
                                                 Casa new_casa=new Casa();
                                                 new_casa.new_locuinta();
                                                 s.add_locuinta(new_casa);
                                             }
                                             else
                                             {
                                                 Apartament new_apartament=new Apartament();
                                                 new_apartament.new_locuinta();
                                                 s.add_locuinta(new_apartament);
                                             }

                                         }
                                         else
                                             if(indice==10){
                                                 Scanner ssc=new Scanner(System.in);
                                                 String nume,prenume;
                                                 System.out.print("Nume: ");
                                                 nume=ssc.nextLine();
                                                 System.out.print("Prenume: ");
                                                 prenume=ssc.nextLine();
                                                 Agent new_agent=new Agent(nume,prenume);

                                                 s.add_agent(new_agent);}



        }

    }






}

