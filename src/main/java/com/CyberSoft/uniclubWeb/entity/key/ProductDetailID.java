package com.CyberSoft.uniclubWeb.entity.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class ProductDetailID implements Serializable {

    @Column(name = "ID_product")
    private int idProduct;

    @Column(name = "ID_tag")
    private int idTag;

    @Column(name = "ID_category")
    private int idCategory;

    @Column(name = "ID_color")
    private int idColor;

    @Column(name = "ID_size")
    private int idSize;

}
