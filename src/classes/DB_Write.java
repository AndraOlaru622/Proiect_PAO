package classes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_Write {

    private Connection conn;
    public DB_Write(Connection c){
        this.conn=c;
    }

    public void Write_Client(int ind_client,int ind_agent,Client cl) throws SQLException {
        String nume2=cl.getNume().substring(0,3);
        String prenume2=cl.getPrenume().substring(0,3);
        String idclient=nume2.concat(prenume2);

        String sql = "INSERT INTO clienti(idclient,nume_client,prenume_client,idagent) VALUES(?,?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            {
                pstmt.setString(1, idclient);
                pstmt.setString(2, cl.getNume());
                pstmt.setString(3, cl.getPrenume());
                pstmt.setInt(4, ind_agent);
                pstmt.executeUpdate();
            }
        }
    }

    public void Write_Tranzactie(String tip_locuinta,String tip_tranzactie,Double pret, String nume_client,String nume_agent){




        String sql = "INSERT INTO tranzactii(tip_locuinta,tip_tranzactie,pret,nume_client,nume_agent) VALUES(?,?,?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            {

                pstmt.setString(1, tip_locuinta);
                pstmt.setString(2, tip_tranzactie);
                pstmt.setDouble(3,pret );
                pstmt.setString(4,nume_client);
                pstmt.setString(5,nume_agent);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void Write_Agent(int indice,Agent a){

        String sql="INSERT INTO agenti(idagent,nume_agent,prenume_agent,suma_totala) VALUES(?,?,?,?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            {

                pstmt.setInt(1, indice);
                pstmt.setString(2, a.getNume());
                pstmt.setString(3,a.getPrenume());
                pstmt.setDouble(4,a.getSuma_totala_vanzari());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }

    public void Write_Casa(Casa c){

        String sql="INSERT INTO case1(pret,suprafata,adresa,nr_etaje) VALUES(?,?,?,?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            {

                pstmt.setDouble(1, c.getPret());
                pstmt.setDouble(2, c.getSuprafata());
                pstmt.setString(3, c.get_Adresa());
                pstmt.setInt(4, c.getNr_etaje());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    public void Write_Apartament(Apartament a){

        String sql="INSERT INTO apartamente(pret,suprafata,adresa,nr_camere,etaj,numar) VALUES(?,?,?,?,?,?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            {

                pstmt.setDouble(1, a.getPret());
                pstmt.setDouble(2, a.getSuprafata());
                pstmt.setString(3, a.get_Adresa());
                pstmt.setInt(4, a.getNr_camere());
                pstmt.setInt(5,a.getEtaj());
                pstmt.setInt(6,a.getNumar());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }






}
