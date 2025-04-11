package com.CyberSoft.uniclubWeb.entity;

import com.CyberSoft.uniclubWeb.entity.key.ProductDetailID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_details")
public class ProductDetailEntity {

    @EmbeddedId
    private ProductDetailID id;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @MapsId("idProduct")
    @JoinColumn(name = "id_product")
    private ProductEntity product;

    @ManyToOne
    @MapsId("idTag")
    @JoinColumn(name = "id_tag")
    private TagEntity tag;

    @ManyToOne
    @MapsId("idCategory")
    @JoinColumn(name = "id_category")
    private CategoryEntity category;

    @ManyToOne
    @MapsId("idColor")
    @JoinColumn(name = "id_color")
    private ColorEntity color;

    @ManyToOne
    @MapsId("idSize")
    @JoinColumn(name = "id_size")
    private SizeEntity size;

    // Getters and Setters
}
