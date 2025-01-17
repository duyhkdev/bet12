package com.duyhk.be12.controller;

import com.duyhk.be12.dto.ResponseDTO;
import com.duyhk.be12.dto.SanPhamDTO;
import com.duyhk.be12.enums.Constants;
import com.duyhk.be12.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/san-pham")
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping
    public ResponseDTO<List<SanPhamDTO>> getAll(@RequestParam Integer page,
                                                @RequestParam Integer pageSize){
        Page<SanPhamDTO> pageDto = sanPhamService.getAll(page,pageSize);
        return ResponseDTO.<List<SanPhamDTO>>builder()
                .data(pageDto.getContent())
                .totalPages(pageDto.getTotalPages())
                .totalElement(pageDto.getTotalElements())
                .message(Constants.MESSAGE.GET_SUCCESS)
                .statusCode(Constants.STATUS.SUCCESS)
                .build();
    }

    // ModalAttribute: sẽ dùng cho các trường hợp dto có chưa file
    // RequestBody: dùng cho trường hợp dto khong co file
    @PostMapping
    public ResponseDTO<Void> getAll(@ModelAttribute SanPhamDTO dto) throws IOException {
        sanPhamService.create(dto);
        return ResponseDTO.<Void>builder()
                .message(Constants.MESSAGE.CREATE_SUCCESS)
                .statusCode(Constants.STATUS.SUCCESS)
                .build();
    }
}
