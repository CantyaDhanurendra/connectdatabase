import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dhanurendra on 06/10/15.
 */
public class MainApp {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/cobadb";

    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {

        Connection conn = null;
        java.sql.Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Connected database successfully...");

            //View Join
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String query ="SELECT student.nim , student.nama , praktikum.nama_prak , asisten.nama_asisten" +
                    " FROM student,praktikum,asisten" +
                    " WHERE student.id_prak = praktikum.id_prak AND praktikum.id_asisten = asisten.id_asisten";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println();
            System.out.println("NIM , NAMA , Nama_Prak , Nama_Asisten");
            while (rs.next()) {
                String nim = rs.getString("nim");
                String nama = rs.getString("nama");
                String nama_prak = rs.getString("nama_prak");
                String nama_asisten = rs.getString("nama_asisten");
                System.out.println(nim + "  " + nama + "   " + nama_prak + "  " + nama_asisten);

            }
            System.out.println();
        } catch (ClassNotFoundException e) {
            System.err.println("Join Failed : "+e.getMessage());
        } catch (SQLException e) {
            System.err.println("Connection Failed : " + e.getMessage() + " " +e.getSQLState());
        } catch (Exception e) {
            System.err.println("Unknown Exception : "+e.getMessage());
        } finally{
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }



}
