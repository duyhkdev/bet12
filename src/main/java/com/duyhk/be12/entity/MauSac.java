package com.duyhk.be12.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mau_sac")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MauSac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ten;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
