//import java.sql;
import javax.xml.transform.Result;
import java.sql.*;

/**
 * Created by dhanurendra on 03/10/15.
 */
public class student {

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

            String sql = "INSERT INTO student(nim,nama,id_prak)" +
                    "VALUES ('86','Cantya','501')";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO student(nim,nama,id_prak)" +
                    "VALUES ('89','Bambang','503')";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO student(nim,nama,id_prak)" +
                    "VALUES ('90','Ani','504')";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO student(nim,nama,id_prak)" +
                    "VALUES ('91','Ali','504')";
            stmt.executeUpdate(sql);
            */



            //update
            /*System.out.println("Creating statement");
            stmt = conn.createStatement();

            String sql = "UPDATE student " + "SET nama = 'Danu' WHERE nim = '89' ";
            stmt.executeUpdate(sql);*/

            //delete
            /*System.out.println("Creating Statement");
            stmt = conn.createStatement();

            String sql = "DELETE FROM student " + "WHERE nim = '90' ";
            stmt.executeUpdate(sql);*/

            //select
            System.out.println("Creating Statement");
            stmt = conn.createStatement();

            String query = "SELECT nim,nama,id_prak FROM student";
            ResultSet rs =stmt.executeQuery(query);
            System.out.println();
            System.out.println("nim,nama");

            while (rs.next()){
                String nim = rs.getString("nim");
                String nama = rs.getString("nama");
                String id_prak = rs.getString("id_prak");
                System.out.println(nim+" "+nama+" "+id_prak);
            }

            System.out.println("Fetching records with condition...");
            String sql = "SELECT a.nim , a.nama , b.nama_prak , c.nama_asiste FROM student a,praktikum b,asisten c" +
                    "WHERE a.id_prak = b.id_prak and b.id_asisten = c.id_asisten";
            rs = stmt.executeQuery(sql);

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



