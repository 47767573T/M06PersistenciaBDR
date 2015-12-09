import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class selectSQLite {

    static Connection c;
    static Statement stmt;
    static String archivoDB = themovieDBproject.ficheroDB;
    static String tablaPelis = themovieDBproject.nombreTablaPeliculas;
    static String tablaActores = themovieDBproject.nombreTablaActores;

    static String dbUser = themovieDBproject.dbUser;
    static String dbPass = themovieDBproject.dbPassword;

    public static void movieList (){
        int numIndex = 0;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(archivoDB,dbUser,dbPass);
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT ID, TITULO FROM "+tablaPelis);
            while ( rs.next() ) {
                numIndex++;
                int id = rs.getInt("ID");
                String titulo = rs.getString("TITULO");
                System.out.println(numIndex+"\t("+id+")"+titulo);
            }

            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

    public static void actorList (){
        int numIndex = 0;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(archivoDB);
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT DISTINCT ID_ACTOR, NOMBRE FROM "+tablaActores);
            while ( rs.next() ) {
                numIndex++;
                int id = rs.getInt("ID_ACTOR");
                String nombre = rs.getString("NOMBRE");
                System.out.println(numIndex+"\t("+id+")"+nombre);
            }

            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("consulta realizada correctamente");

    }
}


