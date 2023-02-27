package com.example.customlistview2;

public class DocGia  {
   private int idAnh;
    private String maDG;
    private String tenDG;




    public DocGia(int idAnh, String maDG, String tenDG) {
        this.idAnh = idAnh;
        this.maDG = maDG;
        this.tenDG = tenDG;
    }

    public int getIdAnh() {
        return idAnh;
    }

    public void setIdAnh(int idAnh) {
        this.idAnh = idAnh;
    }

    public String getMaDG() {
        return maDG;
    }

    public void setMaDG(String maDG) {
        this.maDG = maDG;
    }

    public String getTenDG() {
        return tenDG;
    }

    public void setTenDG(String tenDG) {
        this.tenDG = tenDG;
    }


}