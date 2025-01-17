package com.duyhk.be12.service.iplm;

import com.duyhk.be12.dto.TaiKhoanDTO;
import com.duyhk.be12.entity.GioHang;
import com.duyhk.be12.entity.TaiKhoan;
import com.duyhk.be12.enums.HangTaiKhoan;
import com.duyhk.be12.enums.Role;
import com.duyhk.be12.enums.TrangThai;
import com.duyhk.be12.repository.GioHangRepo;
import com.duyhk.be12.repository.TaiKhoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaiKhoanService {

    @Autowired
    private TaiKhoanRepo taiKhoanRepo;

    @Autowired
    private GioHangRepo gioHangRepo;

    public void register(TaiKhoanDTO dto){
        TaiKhoan entity = new TaiKhoan();

        entity.setSoDienThoai(dto.getSoDienThoai());
        entity.setMatKhau(dto.getMatKhau());
        entity.setRole(Role.KHACHHANG);
        entity.setTongTien(0l);
        entity.setHangTaiKhoan(HangTaiKhoan.KH_THUONG);
        entity.setTrangThai(TrangThai.HOAT_DONG);

        entity = taiKhoanRepo.save(entity);

        GioHang gioHang = new GioHang();
        gioHang.setTongSoSanPham(0l);
        gioHang.setTaiKhoan(entity);

        gioHangRepo.save(gioHang);

    }

}
