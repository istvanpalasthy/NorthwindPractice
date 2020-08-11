package com.codecool.NorthwindPractice.model;


import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long productId;
    @NotBlank(message = "Product Code cannot be empty or Null")
    private String productCode;
    @NotBlank(message = "Product Name cannot be empty or Null")
    private String productName;
    @Nullable
    private String description;
    /*@ManyToMany
    @JoinTable(name = "supplier_product", joinColumns = @JoinColumn(name = "suppliers", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "supplier_id", referencedColumnName = "id"))
    private List<Long> supplierId;*/
    @Min(0)
    private Double standardCost;
    @Min(0)
    private Double listPrice;

    private String Category;


}
