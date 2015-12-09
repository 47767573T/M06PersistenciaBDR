
import java.sql.*;

public class createSQLite {

    static String tablaPelis = themovieDBproject.nombreTablaPeliculas;
    static String tablaActores = themovieDBproject.nombreTablaActores;

    static String archivoDB = themovieDBproject.ficheroDB;
    static String dbUser = themovieDBproject.dbUser;
    static String dbPass = themovieDBproject.dbPassword;

    public static void createTabla() {

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(archivoDB,dbUser,dbPass);
            System.out.println("acceso correcto a Base de datos");
            stmt = c.createStatement();

            //Definimos la estructura de las tablas para peliculas
            String sqlPeli = "CREATE TABLE " + tablaPelis
                    + " (ID INT PRIMARY KEY     NOT NULL,"
                    + " TITULO CHAR(100),"
                    + " FECHA CHAR(20))";

            //Definimos la estructura de las tablas para actores
            String sqlActor = "CREATE TABLE " + tablaActores
                    + "(ID INT PRIMARY KEY NOT NULL,"
                    + " NOMBRE         CHAR(50),"
                    + " ID_ACTOR       INT,"
                    + " PERSONAJE      CHAR(50),"
                    + " ID_PELICULA    INT)";

            stmt.executeUpdate(sqlPeli);
            stmt.executeUpdate(sqlActor);

            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Tabla de "+tablaPelis+" y "+tablaActores
                +" creada en "+ themovieDBproject.ficheroDB);

    }

}