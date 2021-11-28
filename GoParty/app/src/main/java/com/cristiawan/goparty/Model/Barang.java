package com.cristiawan.goparty.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 2/3/17.
 */

public class Barang {

    @SerializedName("idbarang")
    @Expose
    private Integer idbarang;
    @SerializedName("idpenjual")
    @Expose
    private Integer idpenjual;
    @SerializedName("idkategori")
    @Expose
    private Integer idkategori;
    @SerializedName("namabarang")
    @Expose
    private String namabarang;
    @SerializedName("harga")
    @Expose
    private String harga;
    @SerializedName("jumlah")
    @Expose
    private Integer jumlah;
    @SerializedName("imgbarang")
    @Expose
    private String imgbarang;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("namakategori")
    @Expose
    private String namakategori;
    @SerializedName("namapenjual")
    @Expose
    private String namapenjual;

    public Integer getIdbarang() {
        return idbarang;
    }

    public void setIdbarang(Integer idbarang) {
        this.idbarang = idbarang;
    }

    public Integer getIdpenjual() {
        return idpenjual;
    }

    public void setIdpenjual(Integer idpenjual) {
        this.idpenjual = idpenjual;
    }

    public Integer getIdkategori() {
        return idkategori;
    }

    public void setIdkategori(Integer idkategori) {
        this.idkategori = idkategori;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public String getImgbarang() {
        return imgbarang;
    }

    public void setImgbarang(String imgbarang) {
        this.imgbarang = imgbarang;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getNamakategori() {
        return namakategori;
    }

    public void setNamakategori(String namakategori) {
        this.namakategori = namakategori;
    }

    public String getNamapenjual() {
        return namapenjual;
    }

    public void setNamapenjual(String namapenjual) {
        this.namapenjual = namapenjual;
    }
}

