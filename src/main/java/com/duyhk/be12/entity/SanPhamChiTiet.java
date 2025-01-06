package com.duyhk.be12.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SanPhamChiTiet {
    /*
    id bigInt, ma varchar(255), ten varchar(255), gia bigint,
    so_luong_ton_kho bigint, so_luong_da_ban bigint, trang_thai int,
    san_pham_id bigint (khóa phụ), mau_sac_id bigint (khóa phụ), kich_co_id bigint (khóa phụ)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ma;
    private String ten;
    private Long gia;
    private Long soLuongTonKho;
    private Long soLuongDaBan;
    private Integer trangThai;

    @ManyToOne
    private SanPham sanPham;
    @ManyToOne
    private MauSac mauSac;
    @ManyToOne
    private KichCo kichCo;
}
