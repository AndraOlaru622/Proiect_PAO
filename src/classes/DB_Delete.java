package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB_Delete {

    private Connection conn;

    public DB_Delete(Connection c){this.conn=c;}

    public void Delete_Locuinta(Locuinta locuinta)throws SQLException {

        if(locuinta.getClass().toString().equals("class classes.Apartament")){


            String query = "DELETE from apartamente WHERE adresa = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, (((Apartament)locuinta).get_Adresa()));
            preparedStatement.executeUpdate();
        }
        else
        if(locuinta.getClass().toString().equals("class classes.Casa")){

            String query = "DELETE from case1 WHERE adresa = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, (((Casa)locuinta).get_Adresa()));
            preparedStatement.executeUpdate();
        }


    }
}
