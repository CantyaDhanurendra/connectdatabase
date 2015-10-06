//import java.sql;
//import com.sun.org.apache.xpath.internal.operations.*;

import java.beans.Statement;
import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dhanurendra on 04/10/15.
 */
public class asisten {
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

            String sql = "INSERT INTO asisten(id_asisten,nama_asisten)" +
                    "VALUES ('100','Dhanurendra')";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO asisten(id_asisten,nama_asisten)" +
                    "VALUES ('101','Purdadi')";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO asisten(id_asisten,nama_asisten)" +
                    "VALUES ('102','Fajar')";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO asisten(id_asisten,nama_asisten)" +
                    "VALUES ('103','Imam')";
            stmt.executeUpdate(sql);*/

            //update
            /*System.out.println("Creating statement");
            stmt = conn.createStatement();

            String sql = "UPDATE asisten " + "SET nama_asisten = 'Purwanto' WHERE id_asisten = '101' ";
            stmt.executeUpdate(sql);*/

            //delete
            /*System.out.println("Creating Statement");
            stmt = conn.createStatement();

            String sql = "DELETE FROM asisten " + "WHERE id_asisten = '102' ";
            stmt.executeUpdate(sql);*/

            //select
            System.out.println("Creating Statement");
            stmt = conn.createStatement();

            String query = "SELECT id_asisten,nama_asisten FROM asisten";
            ResultSet rs =stmt.executeQuery(query);
            System.out.println();
            System.out.println("id_asisten,nama_asisten");

            while (rs.next()){
                String id_asisten = rs.getString("id_asisten");
                String nama_asisten = rs.getString("nama_asisten");
                System.out.println(id_asisten+" "+nama_asisten);
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
































    /*
   public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Regrister Class Success");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/cobadb", "root", "root");
            System.out.println("Connecting is now " + (connection.isClosed() ? "Closed" : "Open"));

            //insert
            /*PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO asisten (nim,nama) VALUES (?,?)");
            preparedStatement.setString(1,"102");
            preparedStatement.setString(2, "Pratiwi");
            int affectedRow = preparedStatement.executeUpdate();
            System.out.println("Success Execute Update, Row Affected : " + affectedRow);*/

            //update
          /*  System.out.println("Creating Database...");
            stmt = conn.createStatement();
            String sql= "UPDATE ASISTEN" + "SET nama = 'Parwati' WHERE nim = '102' ";
            stmt.executeUpdate(sql);
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }
        catch (ClassNotFoundException e) {
            System.err.println("Register Field : " + e.getMessage());
        }
        catch (SQLException e) {
            System.err.println("Connection Field : " + e.getMessage() + "" + e.getSQLState());
        }
        catch (Exception e) {
            System.err.println("Unknown Exception : " + e.getMessage());
        }
} }*/
