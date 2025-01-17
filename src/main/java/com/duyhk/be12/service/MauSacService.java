package com.duyhk.be12.service;

import com.duyhk.be12.dto.MauSacDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MauSacService {
    Page<MauSacDTO> getAll(Integer page, Integer pageSize);
    void create(MauSacDTO dto);
    void update(MauSacDTO dto, Long id);
    void delete(Long id);
}
