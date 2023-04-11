package com.example.caculator;

public class SanPham {
    private  String maSP, tenSP, soluong;

    public SanPham() {
    }
    public SanPham(String maSP, String tenSP, String soluong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soluong = soluong;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "maSP='" + maSP + '\'' +
                ", tenSP='" + tenSP + '\'' +
                ", soluong='" + soluong + '\'' +
                '}';
    }
}
