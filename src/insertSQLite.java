

import java.sql.*;

public class insertSQLite {

    static String archivoDB = themovieDBproject.ficheroDB;
    static String tablaPelis = themovieDBproject.nombreTablaPeliculas;
    static String tablaActores = themovieDBproject.nombreTablaActores;

    static String dbUser = themovieDBproject.dbUser;
    static String dbPass = themovieDBproject.dbPassword;

    static Connection c;
    static Statement stmt;

    public static void insertTablaPelis(int id, String titulo, String fecha) {
        {
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager.getConnection(archivoDB,dbUser,dbPass);
                c.setAutoCommit(false);

                stmt = c.createStatement();
                String sql = "INSERT INTO "+tablaPelis+" (ID,TITULO,FECHA) "
                            +"VALUES ("+id+",'"+titulo+"','"+fecha+"');";
                stmt.executeUpdate(sql);

                stmt.close();
                c.commit();
                c.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        }
    }

    public static void insertTablaActores(int id, String nombre, long actor, String personaje, int idPeli) {
        {
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager.getConnection(archivoDB,dbUser,dbPass);
                c.setAutoCommit(false);

                stmt = c.createStatement();
                String sql = "INSERT INTO "+tablaActores+" (ID,NOMBRE,ID_ACTOR,PERSONAJE,ID_PELICULA) "
                        +"VALUES ("+id+",'"+nombre+"',"+actor+",'"+personaje+"',"+idPeli+");";
                stmt.executeUpdate(sql);

                stmt.close();
                c.commit();
                c.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName()+e.getClass().getMethods() + ": " + e.getMessage());
                System.exit(0);
            }
            //System.out.println("Guardado ("+nombre+") en ("+themovieDBproject.nombreTablaActores+")");        FLAG
        }
    }
}
