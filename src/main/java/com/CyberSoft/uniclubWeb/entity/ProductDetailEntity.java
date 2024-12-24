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
    // Thuộc tính insertable = false, updatable = false:
    //Được thêm vào @JoinColumn để ngăn Hibernate xử lý các cột ID_product, ID_category, ID_color, ID_size, và ID_tag như một phần của @ManyToOne.
    @ManyToOne
    @JoinColumn(name = "ID_product", referencedColumnName = "ID_product", insertable = false, updatable = false, nullable = false)
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "ID_category", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "ID_color", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private ColorEntity color;

    @ManyToOne
    @JoinColumn(name = "ID_size", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private SizeEntity size;

    @ManyToOne
    @JoinColumn(name = "ID_tag", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private TagEntity tag;

    @Column(name = "Soluong", nullable = false)
    private int soLuong;

    // Getters and Setters
    public ProductDetailID getId() {
        return id;
    }

    public void setId(ProductDetailID id) {
        this.id = id;
    }
}
