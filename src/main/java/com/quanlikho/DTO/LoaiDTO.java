package com.quanlikho.DTO;

public class LoaiDTO {
    private String maLoai;
    private String tenLoai;

    // Constructors
    public LoaiDTO() {
    }

    public LoaiDTO(String maLoai, String tenLoai) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
    }

    // Getters and Setters
    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    // Override toString() method
    @Override
    public String toString() {
        return "LoaiDTO{" +
                "maLoai='" + maLoai + '\'' +
                ", tenLoai='" + tenLoai + '\'' +
                '}';
    }
}
