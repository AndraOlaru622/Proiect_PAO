package classes;

import java.sql.*;

public class DB_Alter {

    Connection conn;

    public DB_Alter(Connection c){
        this.conn=c;
    }

    public void Alter_Agent(int indice,double val) throws SQLException {


        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(indice);
        String strI = sb.toString();
        String query="SELECT * FROM AGENTI WHERE idagent="+strI;
        Statement st = this.conn.createStatement();
        ResultSet rs = st.executeQuery(query);


        while (rs.next()){
        Double val_act=rs.getDouble("suma_totala");
        Double val_noua=val+val_act;


            String query1 = "UPDATE agenti SET suma_totala = ? WHERE idagent = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(query1);
            preparedStatement.setDouble(1, val_noua);
            preparedStatement.setInt(2, indice);
            preparedStatement.executeUpdate();

        }





    }

    public void Alter_Locuinta(Locuinta locuinta,Double val_noua) throws SQLException
    {
        if(locuinta.getClass().toString().equals("class classes.Apartament")){

            String query = "UPDATE apartamente SET pret = ? WHERE adresa = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setDouble(1, val_noua);
            preparedStatement.setString(2, (((Apartament)locuinta).get_Adresa()));
            preparedStatement.executeUpdate();





        }
        else
        if(locuinta.getClass().toString().equals("class classes.Casa")){
            String query = "UPDATE case1 SET pret = ? WHERE adresa = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setDouble(1, val_noua);
            preparedStatement.setString(2, (((Casa)locuinta).get_Adresa()));
            preparedStatement.executeUpdate();

        }

    }

}
