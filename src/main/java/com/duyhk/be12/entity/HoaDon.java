package com.duyhk.be12.entity;

import com.duyhk.be12.enums.LoaiHoaDon;
import com.duyhk.be12.enums.TrangThaiHoaDon;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String maHoaDon;
    Long tongSoSanPham;
    Long tongSoTien;
    String soDienThoai;
    String diaChi;
    String hoTen;
    LocalDate ngayTao;
    LocalDate ngayHoanThanh;
    String lyDoHuy;
    TrangThaiHoaDon trangThai;
    LoaiHoaDon loaiHoaDon;

    @ManyToOne
    TaiKhoan taiKhoan;
}
