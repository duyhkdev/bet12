package com.duyhk.be12.dto;

import com.duyhk.be12.enums.Constants;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamChiTietDTO {
    private Long id;
    private String ma;
    @NotBlank(message = Constants.MESSAGE.VALIDATE_TEN)
    private String ten;
    @NotNull(message = Constants.MESSAGE.ERROR_GIA_IS_NULL)
    @Min(value = 10000, message = Constants.MESSAGE.ERROR_GIA_LESS_THAN_MIN)
    private Long gia;
    private Long soLuongTonKho;
    private Long soLuongDaBan;
    private Integer trangThai;

    /** De biet thuoc san pham nao thoi*/
    private Long sanPhamId; // idSanPham

    private MauSacDTO mauSac; // idMsac, tenMauSac
    private KichCoDTO kichCo; // idKco, tenKco
}
