package classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DB_Read {
    private Connection conn;

    public DB_Read(Connection c){this.conn=c;}

    public List<Client> Read_Clienti() throws SQLException{
        String query="SELECT * FROM clienti";
        Statement st =this.conn.createStatement();
        ResultSet rs=st.executeQuery(query);
        List<Client>l_c=new ArrayList<>();

        while (rs.next()){
            Client cl_aux= new Client();
            String nume_cl=rs.getString("nume_client");
            String prenume_cl=rs.getString("prenume_client");
            int indag=rs.getInt("idagent");
            cl_aux.setNume(nume_cl);
            cl_aux.setPrenume(prenume_cl);
            l_c.add(cl_aux);

        }
        return l_c;

    }

    public List<Agent> Read_Agenti() throws SQLException {
        String query = "SELECT * FROM agenti";
        Statement st = this.conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        List<Agent>l_a=new ArrayList<>();

        while (rs.next())
        {
            Agent ag_aux=new Agent();
            int id = rs.getInt("idagent");
            String firstName = rs.getString("prenume_agent");
            String lastName = rs.getString("nume_agent");
            Double suma=rs.getDouble("suma_totala");
            ag_aux.setSuma_totala_vanzari(suma);
            ag_aux.setNume(lastName);
            ag_aux.setPrenume(firstName);
            ag_aux.setIndagent(id);
            l_a.add(ag_aux);

    }
    return l_a;
    }

    public List<Casa> Read_Case() throws SQLException {
        String query = "SELECT * FROM case1";
        Statement st = this.conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        List<Casa>l_c=new ArrayList<>();

        while (rs.next())
        {
            Casa casa_aux=new Casa();
            int id = rs.getInt("idcasa");
            casa_aux.setPret(rs.getDouble("pret"));
            casa_aux.setSuprafata(rs.getDouble("suprafata"));
            casa_aux.setNr_etaje(rs.getInt("nr_etaje"));
            casa_aux.setAdresa(rs.getString("adresa"));

            l_c.add(casa_aux);

        }
        return l_c;
    }


    public List<Apartament> Read_Apartamente() throws SQLException {
        String query = "SELECT * FROM apartamente";
        Statement st = this.conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        List<Apartament>l_ap=new ArrayList<>();

        while (rs.next())
        {
            Apartament ap_aux=new Apartament();
            int id = rs.getInt("idapartament");
            ap_aux.setPret(rs.getDouble("pret"));
            ap_aux.setSuprafata(rs.getDouble("suprafata"));
            ap_aux.setAdresa(rs.getString("adresa"));
            ap_aux.setNr_camere(rs.getInt("nr_camere"));
            ap_aux.setEtaj(rs.getInt("etaj"));
            ap_aux.setNumar(rs.getInt("numar"));
            l_ap.add(ap_aux);

        }
        return l_ap;
    }








}

