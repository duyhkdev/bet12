package com.duyhk.be12.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SanPhamDTO {
    Long id;
    String ma;
    String ten;
    Long gia;
    Long soLuongTonKho;
    Long soLuongDaBan;
    String moTa;
    Integer trangThai;
    LoaiSanPhamDTO loaiSanPham;
    List<String> anhSanPhamUrl;

    @JsonIgnore
    List<MultipartFile> files;
}


/*
1 sp se co nhieu sp chi tiet
so luong cua sp_> sl cua spct
gia -> hien thi theo gia thap nhat cua spct
 */
