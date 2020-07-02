/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Pembeli_07031;
import Database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author M Yusuf Ariesandy
 */
public class Controller_Pembeli {
    Koneksi koneksi;
    ArrayList<Pembeli_07031> arrpembeli;
    
    public Controller_Pembeli () throws SQLException{
        this.koneksi= new Koneksi();
        this.arrpembeli = new ArrayList<>();
    }
    // INPUT DATA PEMBELI    
    public void insertPembeli_07031(Pembeli_07031 pembeli) {
        
        this.koneksi.ManipulasiData("INSERT INTO PEMBELI_07031 (ID_PEMBELI, N0_TELP, NAMA_PEMBELI_07031) "
                + "VALUES ('"+pembeli.getId_Pembeli()+"','"+pembeli.getNo_Telp()+"','"+pembeli.getNama_Pembeli_07031()+"')");
        System.out.println("INSERT INTO PEMBELI_07031 (ID_PEMBELI, NO_TELP, NAMA_PEMBELI_07031) "
                + "VALUES ('"+pembeli.getId_Pembeli()+"','"+pembeli.getNo_Telp()+"','"+pembeli.getNama_Pembeli_07031()+"')");
    }
    // DELETE DATA PEMBELI
   public void DeletePembeli_07031(Pembeli_07031 pembeli){
       this.koneksi.ManipulasiData("DELETE FROM PEMBELI_07031 WHERE ID_PEMBELI = " + pembeli.getId_Pembeli());
   } 
    
    public ArrayList<Pembeli_07031> getDataPembeli_07031() throws SQLException {
        this.arrpembeli.clear();
        ResultSet rs =  this.koneksi.GetData("SELECT * FROM PEMBELI_07031 ORDER BY ID_PEMBELI ASC");
        while (rs.next()){
            Pembeli_07031 p = new Pembeli_07031();
            p.setId_Pembeli(rs.getInt("ID_PEMBELI"));
            p.setNo_Telp(rs.getString("NO_TELP"));
            p.setNama_Pembeli_07031(rs.getString("NAMA_PEMBELI_07031"));;
            this.arrpembeli.add(p);
        }
        return this.arrpembeli;
    
    }
}
