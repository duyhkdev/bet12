package com.duyhk.be12.service;

import com.duyhk.be12.dto.SanPhamChiTietDTO;
import org.springframework.data.domain.Page;

public interface SanPhamChiTietService {
    Page<SanPhamChiTietDTO> getAll(Integer page, Integer pageSize);
    SanPhamChiTietDTO getById(Long id);
    void create(SanPhamChiTietDTO dto);
    void update(SanPhamChiTietDTO dto, Long id);
    void delete(Long id);
}
