/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author M Yusuf Ariesandy
 */
public class Transaksi_07031 {
    private Integer Id_Transaksi;
    private Pembeli_07031 pembeli;
    private Barang_07031 barang;
    private Integer Harga_Total;
    private ArrayList<Transaksi_07031> arrTransaksi;

    public Integer getId_Transaksi() {
        return Id_Transaksi;
    }

    public void setId_Transaksi(Integer Id_Transaksi) {
        this.Id_Transaksi = Id_Transaksi;
    }

    public Pembeli_07031 getPembeli() {
        return pembeli;
    }

    public void setPembeli(Pembeli_07031 pembeli) {
        this.pembeli = pembeli;
    }

    public Barang_07031 getBarang() {
        return barang;
    }

    public void setBarang(Barang_07031 barang) {
        this.barang = barang;
    }

    public Integer getHarga_Total() {
        return Harga_Total;
    }

    public void setHarga_Total(Integer Harga_Total) {
        this.Harga_Total = Harga_Total;
    }

    public ArrayList<Transaksi_07031> getArrTransaksi() {
        return arrTransaksi;
    }

    public void setArrTransaksi(ArrayList<Transaksi_07031> arrTransaksi) {
        this.arrTransaksi = arrTransaksi;
    }



    
}
