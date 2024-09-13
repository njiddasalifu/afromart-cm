package com.salif.ecommerce.products.category;


import com.salif.ecommerce.products.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@Entity
public class Category {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE) //here when a category is removed, all products under it are removed too
    private List<Product> products;
}
