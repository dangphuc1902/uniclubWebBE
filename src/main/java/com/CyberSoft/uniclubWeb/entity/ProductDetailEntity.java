//package com.CyberSoft.uniclubWeb.entity;
//
//import com.CyberSoft.uniclubWeb.entity.key.ProductDetailID;
//import com.CyberSoft.uniclubWeb.service.imp.ProductServiceImp;
//import jakarta.persistence.*;
//import lombok.*;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity(name = "productdetail")
//public class ProductDetailEntity {
//    @EmbeddedId
//    private ProductDetailID id;
//
////    @ManyToOne
////    @JoinColumn(name = "ID_product", referencedColumnName = "id")
////    private ProductEntity product;
////
////    @ManyToOne
////    @JoinColumn(name = "ID_category", referencedColumnName = "id")
////    private  category;
////    @JoinColumn(name = "ID_color", referencedColumnName = "id")
////    private ColorEN color;
////
////    @ManyToOne
////    @JoinColumn(name = "ID_size", referencedColumnName = "id")
////    private Size size;
//
////    Map quan hệ về nhà map.
//    @Column(name = "Soluong")
//    private int soLuong;
//    public ProductDetailID getId(){
//        return id;
//    }
//    public void setId(ProductDetailID id){
//        this.id =id;
//    }
//}

package com.CyberSoft.uniclubWeb.entity;

import com.CyberSoft.uniclubWeb.entity.key.ProductDetailID;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "productdetail")
public class ProductDetailEntity {

    @EmbeddedId
    private ProductDetailID id;

    @ManyToOne
    @JoinColumn(name = "ID_product", referencedColumnName = "ID_product", nullable = false)
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "ID_category", referencedColumnName = "id", nullable = false)
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "ID_color", referencedColumnName = "id", nullable = false)
    private ColorEntity color;

    @ManyToOne
    @JoinColumn(name = "ID_size", referencedColumnName = "id", nullable = false)
    private SizeEntity size;

    @Column(name = "Soluong", nullable = false)
    private int soLuong;

    public ProductDetailID getId() {
        return id;
    }

    public void setId(ProductDetailID id) {
        this.id = id;
    }
}
