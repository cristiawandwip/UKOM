package com.cristiawan.goparty.Model;

public class History {
    private  String tglorderawal,tglorderakhir;
    private  String jumlah;

    public History(String tglorderawal, String tglorderakhir, String jumlah) {
        this.tglorderawal = tglorderawal;
        this.tglorderakhir = tglorderakhir;
        this.jumlah = jumlah;
    }

    public String getTglorderawal() {
        return tglorderawal;
    }

    public void setTglawal(String tglorderawal) {
        this.tglorderawal = tglorderawal;
    }

    public String getTglorderakhir() {
        return tglorderakhir;
    }

    public void setTglakhir(String tglorderakhir) {
        this.tglorderakhir = tglorderakhir;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String  jumlah) {
        this.jumlah = jumlah;
    }
}
