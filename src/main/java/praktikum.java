//import java.sql;
import java.sql.*;

/**
 * Created by dhanurendra on 04/10/15.
 */
public class praktikum {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/cobadb";

    static final String USER ="root";
    static final String PASS ="root";

    public static void main(String[] args) {
        Connection conn = null;
        java.sql.Statement stmt = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            System.out.println("Connected database succefully");

            //insert
            /*System.out.println("Insert record into the table");
            stmt = conn.createStatement();

            String sql = "INSERT INTO praktikum(id_prak,nama_prak,id_asisten)" +
                    "VALUES ('501','PWD','100')";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO praktikum(id_prak,nama_prak,id_asisten)" +
                    "VALUES ('502','PAM','100')";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO praktikum(id_prak,nama_prak,id_asisten)" +
                    "VALUES ('503','RPL','102')";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO praktikum(id_prak,nama_prak,id_asisten)" +
                    "VALUES ('504','KCB','103')";
            stmt.executeUpdate(sql);*/

            //update
            /*System.out.println("Creating statement");
            stmt = conn.createStatement();

            String sql = "UPDATE praktikum " + "SET nama_prak = 'PBPS' WHERE id_prak = '503' ";
            stmt.executeUpdate(sql);*/

            //delete
            /*System.out.println("Creating Statement");
            stmt = conn.createStatement();

            String sql = "DELETE FROM praktikum " + "WHERE id_prak = '503' ";
            stmt.executeUpdate(sql);*/

            //select
            System.out.println("Creating Statement");
            stmt = conn.createStatement();

            String query = "SELECT id_prak,nama_prak,id_asisten FROM praktikum";
            ResultSet rs =stmt.executeQuery(query);
            System.out.println();
            System.out.println("id_prak,nama_prak,id_asisten");

            while (rs.next()){
                String id_prak = rs.getString("id_prak");
                String nama_prak = rs.getString("nama_prak");
                String id_asisten = rs.getString("id_asisten");
                System.out.println(id_prak+" "+nama_prak+" "+id_asisten);
            }
            System.out.println();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e ) {
            e.printStackTrace();
        }
        finally {
            try {
                if(conn!=null)
                    conn.close();
            }
            catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}


