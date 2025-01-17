package com.duyhk.be12.entity;

import com.duyhk.be12.enums.HangTaiKhoan;
import com.duyhk.be12.enums.Role;
import com.duyhk.be12.enums.TrangThai;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ma;
    String email;
    String soDienThoai;
    String matKhau;
    String hoTen;
    Role role;
    Long tongHoaDon;
    Long tongTien;
    HangTaiKhoan hangTaiKhoan;
    TrangThai trangThai;
}
// khi tao tkoan se tao luon gio hang
// 1 taif khoan <=> 1 gio hang