package com.duyhk.be12.service;

import com.duyhk.be12.dto.SanPhamDTO;
import org.springframework.data.domain.Page;

import java.io.IOException;

public interface SanPhamService {
    Page<SanPhamDTO> getAll(Integer page, Integer pageSize);
    void create(SanPhamDTO dto) throws IOException;
    void update(SanPhamDTO dto, Long id) throws IOException;
    void delete(Long id);
}
