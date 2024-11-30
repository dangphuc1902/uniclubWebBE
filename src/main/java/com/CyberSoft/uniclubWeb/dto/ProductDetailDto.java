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
}
