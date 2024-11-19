//package com.poly.hangnt169.B1_Hibernate.entity;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//import java.util.List;
//
//@Table(name = "category")
//@Entity // TRUY VAN TREN THUC THE => KHONG CO ENTITY
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString
//@Builder // contructor tuy y ts
//public class Category1 {
//    /**
//     * J3: JDBC - Java Database Connectity
//     *      => Truy van SQL
//     * J4: Hibernate => Truy van HQL(Hibernate Query Languagae)
//     * ORM(Object Relational Mapping)
//     *      => Mapping ca quan he ( 1-1, 1-N..)
//     *    => Truy van tren thuc the
//     *      => Bien cac class trong entity => Thanh table
//     */
//    @Id // Mapping khoa chinh
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id1;
//    @Column(name = "category_code")
//    private String categoryCode;
//
//    @Column(name = "category_name")
//    private String categoryName;
//
//
////    @OneToMany
////    private List<Product>products;
//}
