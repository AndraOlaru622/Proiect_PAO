import classes.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import com.mysql.jdbc.Driver;
import javax.swing.*;

public class Main {




    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {



        String nume11=Thread.currentThread().getName();
        System.out.println(nume11);

       /* CSVReader reader = new CSVReader("src/Agenti", "Agent");
        reader.convert_csv_to_objects();
        List agenti = reader.getData();
        s.setAgenti(agenti);
        //s.show_agenti();

        CSVReader<Apartament> reader1 = new CSVReader<>("src/Apartamente", "Apartament");
        reader1.convert_csv_to_objects();
        List<Apartament> apartaments = reader1.getData();
        for (int i = 0; i < apartaments.size(); i++)
            s.add_locuinta(apartaments.get(i));


        CSVReader<Casa> reader2 = new CSVReader<>("src/Case", "Casa");
        reader2.convert_csv_to_objects();
        List<Casa> houses = reader2.getData();

        for (int i = 0; i < houses.size(); i++)
            s.add_locuinta(houses.get(i));
        //  s.show_locuinte_disponibile();
        // s.show_ranking_agenti();*/


        try {
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/testdb?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&serverTimezone=GMT&useSSL=false&allowPublicKeyRetrieval=true";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "000000@222222");
            Service s = new Service(conn);
            DB_Read DB=new DB_Read(conn);
            s.setAgenti(DB.Read_Agenti());
            List<Casa>lista_case=DB.Read_Case();
            List<Apartament>lista_ap=DB.Read_Apartamente();
            for(int i=0;i<lista_case.size();i++)
                s.add_locuinta(lista_case.get(i));
            for(int i=0;i<lista_ap.size();i++)
                s.add_locuinta(lista_ap.get(i));

                   //   DB_Alter d=new DB_Alter(conn);
                    //  d.Alter_Agent(2,200);

















        CSVWriter<Client> wr_client = new CSVWriter<>("src/Clienti.csv", "Client");
        wr_client.write_header();
        CSVWriter<Agent> wr_agent = new CSVWriter<>("src/Agenti.csv", "Agent");
        CSVWriter<Client> wr_vanzare = new CSVWriter<>("src/Vanzari.csv", "Vanzare");
        wr_vanzare.write_header();
        CSVWriter<String> wr_action_date = new CSVWriter<>("src/ActionDate", "Action_Date");
        wr_action_date.write_header();


        Scanner sc_actiune = new Scanner(System.in);
        int indice = -1;
        while (indice != 0) {
            s.show_meniu();
            indice = sc_actiune.nextInt();
            switch (indice) {
                case 1: {
                    s.show_locuinte_disponibile();
                    break;
                }

                case 2: {
                    s.show_clienti();
                    break;
                }
                case 3: {
                    s.show_agenti();
                    break;
                }

                case 4: {
                    s.add_tranzactie();
                    wr_client.write_data(s.getClienti().get(s.getClienti().size() - 1));
                    wr_vanzare.write_data(s.getClienti().get(s.getClienti().size() - 1));
                    DB_Write wr=new DB_Write(conn);
                    wr.Write_Client(s.getNr_locuinte_vandute(),s.getClienti().get(s.getClienti().size()-1).getA1().getIndagent(),s.getClienti().get(s.getClienti().size()-1));
                    break;
                }

                case 5: {
                    s.show_tranzactii();
                    break;
                }
                case 6: {
                    double i1, i2;
                    Scanner sc2 = new Scanner(System.in);
                    System.out.println("Interval:");
                    System.out.println("I1: ");
                    i1 = sc2.nextDouble();
                    System.out.println("I2: ");
                    i2 = sc2.nextDouble();
                    s.show_locuinte_interval(i1, i2);
                    break;
                }
                case 7: {
                    s.show_ranking_agenti();
                    break;
                }
                case 8: {
                    s.modificare_pret_locuinta();
                    break;
                }
                case 9: {
                    Scanner ssc = new Scanner(System.in);
                    System.out.println("Tipuri locuinte:");
                    System.out.println("1.Casa");
                    System.out.println("2.Apartament");
                    System.out.print("Indice tip: ");
                    int ind_tip;
                    ind_tip = ssc.nextInt();
                    if (ind_tip == 1) {
                        Casa new_casa = new Casa();
                        new_casa.new_locuinta();
                        s.add_locuinta(new_casa);
                    } else {
                        Apartament new_apartament = new Apartament();
                        new_apartament.new_locuinta();
                        s.add_locuinta(new_apartament);
                    }

                    break;
                }
                case 10: {
                    Scanner ssc = new Scanner(System.in);
                    String nume, prenume;
                    System.out.print("Nume: ");
                    nume = ssc.nextLine();
                    System.out.print("Prenume: ");
                    prenume = ssc.nextLine();
                    Agent new_agent = new Agent(nume, prenume);

                    s.add_agent(new_agent);
                    wr_agent.write_data(new_agent);
                    break;
                }
                default: {
                    if (indice != 0)
                        System.out.println("Indice indisponibil.");
                }


            }
            //System.out.println( Action_Date.getActions());
            if (indice >= 0 && indice <= 10) {
                Action_Date ac = new Action_Date(indice);
                ac.write_action_date_csv();
            }
        }
            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

    }

}
