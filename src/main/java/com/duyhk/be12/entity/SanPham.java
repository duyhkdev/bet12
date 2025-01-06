package com.duyhk.be12.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "ma")
    String ma;
    @Column(name = "ten")
    String ten;
    @Column(name = "gia")
    Long gia;
    @Column(name = "so_luong_ton_kho")
    Long soLuongTonKho;
    @Column(name = "so_luong_da_ban")
    Long soLuongDaBan;
    @Column(name = "mo_ta")
    String moTa;
    @Column(name = "trang_thai")
    Integer trangThai;

    @JoinColumn(name = "loai_san_pham_id")
    @ManyToOne // 1 loại sản phẩm co nhieu san pham <=> nhieu sp co cung 1 loai sp
    LoaiSanPham loaiSanPham;
    // 1 san pham co nhieu anh <=> nhieu anh co cung 1 sp
    @CollectionTable(name = "anh_san_pham")
    @ElementCollection(fetch = FetchType.EAGER)
    List<String> anhSanPhamUrl;

}
