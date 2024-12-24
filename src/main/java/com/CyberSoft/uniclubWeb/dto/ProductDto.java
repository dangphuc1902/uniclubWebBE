package com.CyberSoft.uniclubWeb.dto;

import java.io.Serializable;

public class ProductDto implements Serializable {

    private String tensp;
    private String gia;
    private String image;



    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private int idSanPham;
    private String desc;

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ProductDto() {
    }

    public ProductDto(String tensp, String gia, String image, int idSanPham, String desc) {
        this.tensp = tensp;
        this.gia = gia;
        this.image = image;
        this.idSanPham = idSanPham;
        this.desc = desc;
    }
}
