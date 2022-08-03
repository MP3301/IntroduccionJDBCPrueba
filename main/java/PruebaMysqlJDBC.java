import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class PruebaMysqlJDBC {

    public static void main(String[] args) {

        // db : testdbJDBC crea en php my admin
        String url = "jdbc:mysql://localhost:3306/testdbJDBC?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";


        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //cadena conn
            Connection conexion = DriverManager.getConnection(url,"root",null);
            //sentencia declaracion
            Statement instruccion = conexion.createStatement();

            //uso sentencia
            String sql = "SELECT * FROM nombre";

            ResultSet resultado = instruccion.executeQuery(sql);

            // while resulset tenga valor haz el while
            while (resultado.next()){

                System.out.println("Usuario="+resultado.getString("Usuario"));
                System.out.println("Nombre="+resultado.getString("Nombre"));
                System.out.println("Apellido="+resultado.getString("Apellido"));
                System.out.println("id="+resultado.getInt("id"));

            }

            resultado.close();
            instruccion.close();
            conexion.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }
}
