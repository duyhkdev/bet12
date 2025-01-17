package com.duyhk.be12.controller;

import com.duyhk.be12.dto.MauSacDTO;
import com.duyhk.be12.dto.ResponseDTO;
import com.duyhk.be12.dto.SanPhamChiTietDTO;
import com.duyhk.be12.enums.Constants;
import com.duyhk.be12.service.SanPhamChiTietService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/san-pham-chi-tiet")
public class SanPhamChiTietController {

    // controller -> service -> reposiroty

    @Autowired
    private SanPhamChiTietService sanPhamChiTietService;

    @GetMapping
    public ResponseDTO<List<SanPhamChiTietDTO>> getAll(@RequestParam Integer page, // trang hiện tại
                                                       @RequestParam Integer pageSize // số bản ghi trên 1 trang
    ){
        Page<SanPhamChiTietDTO> pageDto = sanPhamChiTietService.getAll(page,pageSize);
        return ResponseDTO.<List<SanPhamChiTietDTO>>builder()
                .message(Constants.MESSAGE.GET_SUCCESS)
                .statusCode(Constants.STATUS.SUCCESS)
                .totalElement(pageDto.getTotalElements())
                .totalPages(pageDto.getTotalPages())
                .data(pageDto.getContent())
                .build();
    }

    @PostMapping
    public ResponseDTO<Void> create(@RequestBody @Valid SanPhamChiTietDTO dto){
        sanPhamChiTietService.create(dto);
        return ResponseDTO.<Void>builder()
                .message(Constants.MESSAGE.CREATE_SUCCESS)
                .statusCode(Constants.STATUS.SUCCESS)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseDTO<Void> update(@PathVariable("id") Long id, @RequestBody SanPhamChiTietDTO dto){
        sanPhamChiTietService.update(dto, id);
        return ResponseDTO.<Void>builder()
                .message(Constants.MESSAGE.UPDATE_SUCCESS)
                .statusCode(Constants.STATUS.SUCCESS)
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseDTO<Void> delete(@PathVariable("id") Long id){
        sanPhamChiTietService.delete(id);
        return ResponseDTO.<Void>builder()
                .message(Constants.MESSAGE.DELETE_SUCCESS)
                .statusCode(Constants.STATUS.SUCCESS)
               .build();
    }
}
