package Utlidades;

import java.sql.*;

public class Conexion {

    private static Connection con;
    public static Connection conexion(){
        try {
            con = DriverManager.getConnection(Constantes.URL, Constantes.USER, Constantes.PASSWORD);
            return con;
        } catch (SQLException e) {
            Constantes.MENSAJE=e.getMessage();
            return null;
        }
    }
     public static Connection conexionp(){
        try {
            con = DriverManager.getConnection(Constantes.URLPOS, Constantes.USERPOS, Constantes.PASSWORDPOS);
            return con;
        } catch (SQLException e) {
            Constantes.MENSAJE=e.getMessage();
            return null;
        }
    }
      public static Connection conexionl(){
        try {
            con = DriverManager.getConnection(Constantes.URLLITE, Constantes.USERLITE, Constantes.PASSWORDLITE);
            return con;
        } catch (SQLException e) {
            Constantes.MENSAJE=e.getMessage();
            return null;
        }
    }
       public static Connection conexiono(){
        try {
            con = DriverManager.getConnection(Constantes.URLORA, Constantes.USERORA, Constantes.PASSWORDORA);
            return con;
        } catch (SQLException e) {
            Constantes.MENSAJE=e.getMessage();
            return null;
        }
    }

}
