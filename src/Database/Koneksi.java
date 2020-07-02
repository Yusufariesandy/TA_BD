package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Koneksi {
    private Connection connect;
    private Statement db;
    private String database = "myusufa_07031";
    
    public Koneksi(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Class Driver Ditemukan");
            try{
                connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","myusufa_07031","myusufa");
                System.out.println("Koneksi Database Sukses");
                
            }catch(SQLException se){
                System.out.println("Koneksi Database Gagal : "+se);
            }
        }catch(ClassNotFoundException err){
            System.out.println("Class Driver tidak ditemukan,terjadi kesalahan pada : "+err);
        }
    }
    public ResultSet GetData(String sql){
        try{
            db=connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//            System.out.println(sql);
//            if(sql.equals("1")){
//                String s = "select ID_PEMESANAN.CURRVAL from DUAL";
//                PreparedStatement ps = connect.prepareStatement(s);
//                ResultSet rs = ps.executeQuery();
//                System.out.println("Sini");
//                int id=0;
//                id = rs.getInt(1);
//                System.out.println("id : " + String.valueOf(id));
//            }
            return db.executeQuery(sql);
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public int ManipulasiData(String sql){
        try{
            db=connect.createStatement();
            return db.executeUpdate(sql);
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
