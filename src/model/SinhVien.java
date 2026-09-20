package model;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private static final long serialVersionUID = 1L;

    private String maSV;
    private String hoTen;
    private double diemTB;
    private String lop;

    public SinhVien() {
    }

    public SinhVien(String maSV, String hoTen, double diemTB, String lop) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.diemTB = diemTB;
        this.lop = lop;
    }

    public String getMaSV() { return maSV; }
    public void setMaSV(String maSV) { this.maSV = maSV; }

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }

    public double getDiemTB() { return diemTB; }
    public void setDiemTB(double diemTB) { this.diemTB = diemTB; }

    public String getLop() { return lop; }
    public void setLop(String lop) { this.lop = lop; }

    @Override
    public String toString() {
        return String.format("SV [Mã: %-6s | Tên: %-18s | Lớp: %-8s | ĐTB: %.2f]", 
                maSV, hoTen, lop, diemTB);
    }
}