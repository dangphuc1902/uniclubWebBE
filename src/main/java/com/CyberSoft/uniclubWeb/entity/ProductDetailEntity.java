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
    @JoinColumn(name = "product", referencedColumnName = "ID_product", nullable = false)
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "id", nullable = false)
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "color", referencedColumnName = "id", nullable = false)
    private ColorEntity color;

    @ManyToOne
    @JoinColumn(name = "size", referencedColumnName = "id", nullable = false)
    private SizeEntity size;
    @ManyToOne
    @JoinColumn(name = "tag", referencedColumnName = "id", nullable = false)
    private TagEntity tag;
    @Column(name = "Soluong", nullable = false)
    private int soLuong;

    public ProductDetailID getId() {
        return id;
    }

    public void setId(ProductDetailID id) {
        this.id = id;
    }
}
