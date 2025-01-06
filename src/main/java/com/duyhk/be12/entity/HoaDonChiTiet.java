package com.duyhk.be12.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long donGia;
    Long soLuong;
    Long thanhTien;
    @ManyToOne
    SanPhamChiTiet sanPhamChiTiet;
    @ManyToOne
    HoaDon hoaDon;
}
