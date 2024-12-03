package com.CyberSoft.uniclubWeb.dto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProductDetailDto {
    private int idSp;
    private int idThe;
    private int idLoaiSp;
    private int idMau;
    private int idKichThuoc;
    private int idSoluong;

    public ProductDetailDto(int idSp, int idThe, int idLoaiSp, int idMau, int idKichThuoc, int idSoluong) {
        this.idSp = idSp;
        this.idThe = idThe;
        this.idLoaiSp = idLoaiSp;
        this.idMau = idMau;
        this.idKichThuoc = idKichThuoc;
        this.idSoluong = idSoluong;
    }
}
