/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.*;
import Database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Controller_Transaksi {
    Koneksi koneksi;
    ArrayList<Pembeli_07031> arrPembeli_07031;
    ArrayList<Barang_07031> arrBarang_07031;
    ArrayList<Transaksi_07031> arrTransaksi_07031;
    
    public Controller_Transaksi () throws SQLException{
        this.koneksi= new Koneksi();
        this.arrPembeli_07031 = new ArrayList<>();
        this.arrBarang_07031 = new ArrayList<>();
        this.arrTransaksi_07031 = new ArrayList<>();
    }
    public ArrayList<Barang_07031> getDataBarang_07031() throws SQLException{
        this.arrBarang_07031.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM BARANG_07031 JOIN TRANSAKSI_07031 ON BARANG_07031.ID_TRANSAKSI=TRANSAKSI_07031.ID_TRANSKASI");
        while (rs.next()){
            Barang_07031 barang = new Barang_07031();
            barang.setId_Barang(rs.getInt("ID_BARANG"));
            barang.setNama_Barang(rs.getString("NAMA_BARANG"));
            barang.setJenis_Barang(rs.getString("JENIS_BARANG"));
            barang.setHarga(rs.getInt("HARGA"));
            barang.setStock(rs.getInt("STOCK"));
                this.arrBarang_07031.add(barang);
               }
        return this.arrBarang_07031;        
        }
    public ArrayList<Pembeli_07031> getDataPembeli_07031() throws SQLException{
        this.arrPembeli_07031.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM PEMBELI_07031");
        while (rs.next()){
            Pembeli_07031 pembeli = new Pembeli_07031();
            pembeli.setId_Pembeli(rs.getInt("ID_PEMBELI"));
            pembeli.setNama_Pembeli_07031(rs.getString("NAMA_PEMBELI_07031"));
            pembeli.setNo_Telp(rs.getString("NO_TELP"));
                this.arrPembeli_07031.add(pembeli);
               }
        return this.arrPembeli_07031;        
        }
    public ArrayList<Transaksi_07031> getDataTransaksi() throws SQLException{
        this.arrTransaksi_07031.clear();
        ResultSet rs = this.koneksi.GetData("SELECT PELANGGAN_07031.ID_PELANGGAN,PELANGGAN_07031.NAMA_DEPAN AS NAMA_DEPAN_PELANGGAN, PELANGGAN_07031.NAMA_BELAKANG AS NAMA_BELAKANG_PELANGGAN, PELANGGAN_07031.TANGGAL_LAHIR AS TANGGAL_LAHIR_PELANGGAN, PELANGGAN_07031.ALAMAT AS ALAMAT_PELANGGAN, PELANGGAN_07031.KODE_POS AS KODE_POS_PELANGGAN, PELANGGAN_07031.NO_TELP AS NO_TELP_PELANGGAN, PEGAWAI_07031.ID_PEGAWAI,PEGAWAI_07031.NAMA_DEPAN AS NAMA_DEPAN_PEGAWAI, PEGAWAI_07031.NAMA_BELAKANG AS NAMA_BELAKANG_PEGAWAI, PEGAWAI_07031.TANGGAL_LAHIR AS TANGGAL_LAHIR_PEGAWAI, PEGAWAI_07031.ALAMAT AS ALAMAT_PEGAWAI, PEGAWAI_07031.KODE_POS AS KODE_POS_PEGAWAI, PEGAWAI_07031.NO_TELP AS NO_TELP_PEGAWAI, PEMESANAN_07031.*,KURIR_07031.* FROM PEMESANAN_07031 JOIN PELANGGAN_07031 ON PEMESANAN_07031.ID_PELANGGAN = PELANGGAN_07031.ID_PELANGGAN JOIN KURIR_07031 ON PEMESANAN_07031.ID_KURIR = KURIR_07031.ID_KURIR JOIN PEGAWAI_07031 ON PEMESANAN_07031.ID_PEGAWAI = PEGAWAI_07031.ID_PEGAWAI ORDER BY ID_PEMESANAN DESC ");
        while (rs.next()){
            Barang_07031 barang = new Barang_07031();
            barang.setId_Barang(rs.getInt("ID_BARANG"));
            barang.setNama_Barang(rs.getString("NAMA_BARANG"));
            barang.setJenis_Barang(rs.getString("JENIS_BARANG"));
            barang.setHarga(rs.getInt("HARGA"));
            barang.setStock(rs.getInt("STOCK"));
            
            Pembeli_07031 pembeli = new Pembeli_07031();
            pembeli.setId_Pembeli(rs.getInt("ID_PEMBELI"));
            pembeli.setNama_Pembeli_07031(rs.getString("NAMA_PEMBELI_07031"));
            pembeli.setNo_Telp(rs.getString("NO_TELP"));
            
            
        }
        return this.arrTransaksi_07031;
    }
}
