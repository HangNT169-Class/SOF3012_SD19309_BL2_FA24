package com.poly.hangnt169.B1_Hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "product")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_name")
    private String productNam;

    @Column
    private Float price;

    @Column
    private String description;

    // Khoa ngoai - categoryID
    // 1 Product - 1 Cate
    // 1 Cate - N product

    // 1-1: OneToOne
    // 1-N: OneToMany
    // N-1: ManyToOne
    // N-N: ManyToMany

    // Khai bao doi tuong
    // Danh dau MQH 2 bang
    // fetch : Lay du lieu
    // Lazy: luoi. Khi nao dung thi moi lay => null
    // Eager: lay ra tat ca. Khong dung cung lay => nang
    // Default many to one => eager
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category1 cate;

}
