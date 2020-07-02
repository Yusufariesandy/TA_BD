/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Barang_07031;
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
public class Controller_Barang {
    Koneksi koneksi;
    ArrayList<Barang_07031> arrBarang_07031;
    
    public Controller_Barang () throws SQLException{
        this.koneksi= new Koneksi();
        this.arrBarang_07031 = new ArrayList<>();
        
    }
    // INPUT DATA BARANG    
    public void insertBarang_07031(Barang_07031 barang) {
      
        this.koneksi.ManipulasiData("INSERT INTO BARANG_07031 (ID_BARANG, NAMA_BARANG, JENIS_BARANG, HARGA, STOCK) "
                + "VALUES ('"+barang.getId_Barang()+"','"+barang.getNama_Barang()+"','"+barang.getJenis_Barang()+"','"
                + barang.getHarga()+"','"+barang.getStock()+"')");
        System.out.println("INSERT INTO BARANG_07031 (ID_BARANG, NAMA_BARANG, JENIS_BARANG, HAGA, STOCK) "
                + "VALUES ('"+barang.getId_Barang()+"','"+barang.getNama_Barang()+"','"+barang.getJenis_Barang()+"','"
                + barang.getHarga()+"','"+barang.getStock()+"')");
    }

// UPDATE DATA DBARANG
    public void UpdateBarang_07031(Barang_07031 barang){
     
        this.koneksi.ManipulasiData("UPDATE BARANG_07031 SET "+" Nama_Barang = '"+ barang.getNama_Barang() +"', Jenis_Barang = '"+barang.getJenis_Barang()+"',Harga = '"
                + barang.getHarga()+"',Stock = '"+ barang.getStock() +"'WHERE ID_BARANG = "+ barang.getId_Barang());
        System.out.println("UPDATE BARANG_07031 "+" Id_Barang = .'" +barang.getId_Barang()+"','"+barang.getNama_Barang()+"','"+barang.getJenis_Barang()+"','"
                + barang.getHarga()+"','"+barang.getStock()+"')");
              
    }
    
// DELETE DATA BARANG
   public void DeleteBarang_07031(Barang_07031 barang){
       this.koneksi.ManipulasiData("DELETE FROM BARANG_07031 WHERE ID_BARANG = " + barang.getId_Barang());
   } 
    
    public ArrayList<Barang_07031> getDataBarang_07031() throws SQLException {
        this.arrBarang_07031.clear();
        ResultSet rs =  this.koneksi.GetData("SELECT * FROM BARANG_07031 ORDER BY ID_BARANG ASC");
        while (rs.next()){
            Barang_07031 b = new Barang_07031();
            b.setId_Barang(rs.getInt("ID_BARANG"));
            b.setNama_Barang(rs.getString("NAMA_BARANG"));
            b.setJenis_Barang(rs.getString("JENIS_BARANG"));
            b.setHarga(rs.getInt("HARGA"));
            b.setStock(rs.getInt("STOCK"));
            this.arrBarang_07031.add(b);
        }
        return this.arrBarang_07031;
    
    }

}
